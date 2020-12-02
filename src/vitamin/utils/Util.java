package vitamin.utils;
public class Util{

    public static Object createInstance(Class clazz){
        Object object=null;
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
}
