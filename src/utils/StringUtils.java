package utils;

public class StringUtils {

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String enclose(String str, String enclosure) {
        return enclosure + str + enclosure;
    }
    
}
