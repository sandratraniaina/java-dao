package sql;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import utils.ArrayUtils;
import utils.ReflectUtils;
import utils.SQLUtils;
import utils.StringUtils;

public class SQLBuilder {
    private String getCriteriaQuery(Object object) throws NoSuchFieldException, SecurityException,
            NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        ArrayList<String> temp = new ArrayList<String>();
        ArrayList<String> attributes = ReflectUtils.getAttributeNames(object);

        String methodName = "";
        String columnName = null;
        Method method = null;

        for (String attribute : attributes) {
            columnName = SQLUtils.getColumnName(object, attribute);
            methodName = "get" + StringUtils.capitalize(attribute);
            method = object.getClass().getMethod(methodName);
            Object result = method.invoke(object);
            if (result != null && !ReflectUtils.isDefaultValue(result)) {
                String value = "AND " + columnName + " = " + SQLUtils.toQueryValue(result);
                temp.add(value);
            }
        }

        return ArrayUtils.join(temp, " ");
    }
}
