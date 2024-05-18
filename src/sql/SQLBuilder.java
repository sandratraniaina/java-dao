package sql;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import dao.exception.DaoException;
import utils.ArrayUtils;
import utils.ReflectUtils;
import utils.SQLUtils;
import utils.StringUtils;

public class SQLBuilder {

    //Class methods
    public static String getInsertingQuery(Object object) throws DaoException, NoSuchFieldException, Exception {
        String tableName = SQLUtils.getTableName(object);
        ArrayList<String> columnNames = SQLUtils.getColumnNames(object);
        String joinedAttributes = ArrayUtils.join(columnNames, ", ");
        String queryHeader = "INSERT INTO " + tableName + "(" + joinedAttributes + ") VALUES \n";
        String queryBody = "(" + ArrayUtils.join(SQLUtils.getColumnValues(object), ", ") + ")";
        String query = queryHeader + queryBody;
        return query;
    }

    public String getReadingQuery(Object object, boolean criteria)
            throws DaoException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        String tableName = SQLUtils.getTableName(object);
        String query = "SELECT * FROM " + tableName + " WHERE 1 = 1 ";
        if (criteria) {
            query += getCriteriaQuery(object);
        }
        return query;
    }

    //Private methods
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
