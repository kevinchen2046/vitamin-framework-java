package vitamin;

import vitamin.utils.Logger;
import vitamin.base.ModelBase;
import vitamin.base.ViewBase;
import vitamin.base.CmdBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import vitamin.core.annotation.Model;
import vitamin.core.annotation.CmdRoute;

import java.util.HashMap;
import java.util.ArrayList;

import vitamin.utils.AnnotationUtil;
import vitamin.utils.Util;

import java.lang.annotation.Annotation;

public class Vitamin {
    private static HashMap< String, ModelBase> modelmap = new HashMap< String, ModelBase>();
    private static HashMap< String, CmdBase> cmdmap = new HashMap< String, CmdBase>();
    private static HashMap< String, ViewBase> viewmap = new HashMap< String, ViewBase>();

    /**
     * 注入数据模型
     */
    public static ModelBase injectModel(Class modelclass) {
        ModelBase instance=(ModelBase)Util.createInstance(modelclass);
        String name=modelclass.getName();
        if(!modelmap.containsKey(name)){
            modelmap.put(name,instance);
        }
        Logger.info("Model [",name,"] 已注册.");
        return instance;
    }

    /**
     * 注入Command
     */
    public static CmdBase injectCmd(Class cmdclass) {
        CmdBase instance=(CmdBase)Util.createInstance(cmdclass);
        CmdRoute anotation=(CmdRoute)AnnotationUtil.getClassAnnotation(cmdclass,CmdRoute.class);
        String name=anotation.value();
        Logger.mark("Command [",cmdclass.getName(),"] 已注册到:",name);
        if(name==null){
            name=cmdclass.getName();
        }
        if(!cmdmap.containsKey(name)){
            cmdmap.put(name,instance);
        }
        return instance;
    }
    
    private static ModelBase getModelInst(Class modelclass){
        String name=modelclass.getName();
        return modelmap.get(name);
    }

    /**
     * 取View 
     * 通过此方法取出的view才具有注入属性
     */
    public static ViewBase getView(Class viewClass){
        String name=viewClass.getName();
        if(!viewmap.containsKey(name)){
            viewmap.put(name,(ViewBase)Util.createInstance(viewClass));
        }
        ViewBase view=viewmap.get(name);
        Field[] fields=viewClass.getFields();
        for(Field field : fields){
            Annotation annotation=field.getAnnotation(Model.class);
            if(annotation instanceof Model){
                //Logger.log(field.getType());
                try {
                    field.set(view,modelmap.get(field.getType().getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return viewmap.get(name);
    }

    /**
     * 执行Commnd
     */
    public static void execCmd(String name,Object ...args){
        if(cmdmap.containsKey(name)){
            cmdmap.get(name).exec(args);
        }
    }
}