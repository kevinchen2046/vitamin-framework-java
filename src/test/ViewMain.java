package test;

import vitamin.utils.Logger;

import java.util.Timer;

import vitamin.base.ViewBase;
import vitamin.core.annotation.Model;
import vitamin.Vitamin;
public class ViewMain extends ViewBase {

    @Model
    public ModelUser user;
    
    
    public void enter(){
        super.enter();
        Logger.debug("ViewMain->",user.uid);
        this.exec("user.rename","kevin.chen");

        Vitamin.loop(500,this::loophandler,user.words.length,()->System.exit(0));
    }

    private int index=0;
    private void loophandler(){
        System.out.print("\033[3"+((index%6)+1)+"m");
        System.out.print(user.words[index]); 
        if(index%2!=0) System.out.println("\033[0m");
        //Logger.info(user.words[index]);
        index++;
    }
}
