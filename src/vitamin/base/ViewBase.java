package vitamin.base;
import vitamin.utils.Logger;
import vitamin.Vitamin;
public class ViewBase {

    public void enter(){
        
    }
    public void exit(){

    }
    protected void exec(String name,Object ...args){
        Vitamin.execCmd(name,args);
    }
}