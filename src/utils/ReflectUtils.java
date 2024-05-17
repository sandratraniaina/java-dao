package utils;

public class ReflectUtils {
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
