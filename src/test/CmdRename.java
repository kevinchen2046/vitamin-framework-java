package test;
import vitamin.core.annotation.CmdRoute;
import vitamin.base.CmdBase;
import vitamin.utils.Logger;

@CmdRoute("user.rename")
public class CmdRename extends CmdBase{
    public void exec(Object ...args){
        Logger.debug("CmdRename->","new name:"+args[0]);
    }
}