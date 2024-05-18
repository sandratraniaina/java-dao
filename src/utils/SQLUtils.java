package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;

import annotation.AnnotationAttribute;

public class SQLUtils {
    String url, driver, user, password, engineType;

    //Class method
    public static String getColumnName(Object object, String attributeName) throws NoSuchFieldException, SecurityException {
        String result = null;
        Field field = object.getClass().getDeclaredField(attributeName);
        AnnotationAttribute annotation = field.getAnnotation(AnnotationAttribute.class);
        if (annotation != null) {
            result = annotation.value();
        }
        return result;
    }


    public static ArrayList<String> getColumnNames(Object object) throws NoSuchFieldException, SecurityException {
        ArrayList<String> attributes = ReflectUtils.getAttributeNames(object);
        ArrayList<String> result = new ArrayList<String>();
        for (String attribute : attributes) {
            Field field = object.getClass().getDeclaredField(attribute);
            AnnotationAttribute annotation = field.getAnnotation(AnnotationAttribute.class);
            if (annotation != null) {
                result.add(annotation.value());
            }
        }
        return result;
    }

    //Contstructors
    public SQLUtils() {
    }

    public SQLUtils(String url, String driver, String user, String password, String engineType) {
        setUrl(url);
        setDriver(driver);
        setUser(user);
        setPassword(password);
        setEngineType(engineType);
    }

    // Getter and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
