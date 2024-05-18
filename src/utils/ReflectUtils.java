package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ReflectUtils {

    public static boolean isDefaultValue(Object object) {
        HashMap<Class<?>, Object> keyValues = new HashMap<Class<?>, Object>();
        keyValues.put(Integer.TYPE, 0);
        keyValues.put(Double.TYPE, 0.0);
        keyValues.put(String.class, "");
        keyValues.put(Date.class, null);

        Object defaultValue = keyValues.get(object.getClass());
        if (defaultValue == null) {
            return object == null;
        }
        return defaultValue.equals(object);
    }

    public static Class<?> getObjectClass(Object object, String type) throws Exception {
        Class<?> objClass = type.equalsIgnoreCase("date") ? Date.class
                : type.equalsIgnoreCase("localdate") ? LocalDate.class
                        : type.equalsIgnoreCase("string") ? String.class
                                : type.equalsIgnoreCase("double") ? Double.TYPE : Integer.TYPE;
        return objClass;
    }

    public static String getClassName(Object object) {
        return object.getClass().getSimpleName();
    }

    public Object executeMethod(Object object, String methodName, Object... args) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = object.getClass().getMethod(methodName, getArgsClasses(args));
        return method.invoke(object, args);
    }

    public static ArrayList<String> getAttributeNames(Object object) {
        Field[] f = object.getClass().getDeclaredFields();
        ArrayList<String> attrList = new ArrayList<String>();

        for (int i = 0; i < f.length; i++) {
            attrList.add(f[i].getName());
        }

        return attrList;
    }

    public static Class<?>[] getArgsClasses(Object... args) {
        Class<?>[] classes = new Class[args.length];
        int i = 0;

        for (Object object : args) {
            classes[i] = object.getClass();
            i++;
        }

        return classes;
    }

}
