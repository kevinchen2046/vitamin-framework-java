package test;

import vitamin.utils.Logger;

import java.util.Timer;

import vitamin.base.ViewBase;
import vitamin.core.TickTask;
import vitamin.core.annotation.Model;
import vitamin.Vitamin;
public class ViewMain extends ViewBase {

    @Model
    public ModelUser user;
    
    private TickTask looptick;
    private TickTask wordtick;
    public void enter(){
        super.enter();
        Logger.debug("ViewMain->",user.uid);
        this.exec("user.rename","kevin.chen");

        looptick=Vitamin.loop(1000,this::loophandler,user.words.length,()->System.exit(0));
        //Vitamin.dealy(2000, ()->Logger.log("Delay!!!"));
    }

    public void exit(){
        super.exit();
        looptick.cancel();
        if(wordtick) wordtick.cancel();
    }

    private int index=0;
    private int color;
    private String text;
    private int i;
    private void loophandler(){
        color=((index%6)+1);
        color=(int)Math.floor(Math.random()*6+1);
        text=user.words[index];
        i=0;

        System.out.print("\033[3"+color+"m");
        wordtick=Vitamin.loop(100,this::update,text.length());
        //System.out.print(user.words[index]); 
        //Logger.info(user.words[index]);
    }

    private void update(){
        System.out.print(text.charAt(i));
        i++; 
        if(i>=text.length()){
            if(index%4==0) System.out.println("\033[0m");
            index++;
        }
    }
}
