package utils;

import java.util.ArrayList;

public class ArrayUtils {
    public static String join(ArrayList<String> list, String separator) {
        if (list == null) {
            return "";
        }
        if (separator == null || "".equals(separator)) {
            throw new IllegalArgumentException("Separator cannot be null");
        }
        String result = "";
        int index = 0;
        for (Object object : list) {
            result += object.toString();
            if (index != list.size() - 1) {
                result += separator;
            }
            index++;
        }
        return result;
    }
}
