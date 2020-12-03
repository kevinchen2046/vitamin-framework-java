
import test.ModelUser;
import test.ViewMain;
import test.CmdRename;

import vitamin.utils.Logger;
import vitamin.utils.AnnotationUtil;

import vitamin.Vitamin;
import vitamin.core.annotation.Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Logger.log("Hello World",123);
        // Logger.error("Hello World",123);
        // Logger.warn("Hello World",123);
        // Logger.debug("Hello World",123);
        // Logger.info("Hello World",123);
        // Logger.mark("Hello World",123);
        // Logger.record("Hello World",123);

        //由于没有全局反射 这里只能手动注入
        //注入模型
        Vitamin.injectModel(ModelUser.class);
        //注入Command
        Vitamin.injectCmd(CmdRename.class);
        
        //取出一个视图
        ViewMain viewmain=(ViewMain)Vitamin.getView(ViewMain.class);

        Logger.colour("------------------ Vitamin Start ------------------");

        //打开视图
        viewmain.enter();
    }
}