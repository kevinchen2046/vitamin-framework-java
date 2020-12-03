package vitamin.utils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.lang.annotation.Annotation;
public class AnnotationUtil{

    /**
     * 获取字段注解
     */
    public static ArrayList<Annotation> getAnnotationsInField(Class clazz,Class annotationClazz){
        ArrayList<Annotation> results =new ArrayList<Annotation>();
        Field[] fields=null;
        try {
            fields=clazz.getFields();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if(fields==null) return results;
        for(Field field : fields){
            Annotation annotation=null;
            try {
                annotation=field.getAnnotation(annotationClazz);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            results.add(annotation);
        }
        return results;
    }
    /**
     * 获取类注解
     */
    public static Annotation getClassAnnotation(Class clazz,Class annotationClazz){
        return clazz.getAnnotation(annotationClazz);
    }
    /**
     * 获取构造器注解
     */
    public static Annotation getConstructorAnnotation(Class clazz,Class annotationClazz){
        Constructor<Object> constructors=null;
        try {
            constructors = clazz.getConstructor(new Class[] {});// 先获得构造方法对象
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructors.getAnnotation(annotationClazz);// 拿到构造方法上面的注解实例
    }
    /**
     * 获取方法注解
     */
    public static ArrayList getMethodAnnotation(Class clazz,Class annotationClazz){
        ArrayList results =new ArrayList();
        Method[] methods = clazz.getMethods();// 获得方法对象
        for(Method method : methods){
            Annotation annotation=null;
            try {
                annotation=method.getAnnotation(annotationClazz);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            results.add(annotation);
        }
        return results;
    }
    
    /**
     * 打印注解
     */
    public static void log(Object ...annotations){
        for(Object annotation:annotations){
            Annotation object=(Annotation)annotation;
            System.out.println(object);
        }
    }
}