package test;

import vitamin.utils.Logger;
import vitamin.base.ViewBase;
import vitamin.core.annotation.Model;

public class ViewMain extends ViewBase {

    @Model
    public ModelUser user;
    
    public void enter(){
        super.enter();
        Logger.debug("ViewMain->",user.uid);
        this.exec("user.rename","kevin.chen");
    }
}