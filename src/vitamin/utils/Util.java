package vitamin.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Util {

    public static Object createInstance(Class clazz) {
        Object object = null;
        try {
            Constructor constructor = null;
            try {
                constructor = clazz.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (constructor != null) {
                object = constructor.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
