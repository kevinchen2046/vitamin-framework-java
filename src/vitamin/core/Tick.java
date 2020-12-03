package vitamin.core;
import java.util.Timer;
import java.util.TimerTask;
class TickTask extends TimerTask{
    Runnable callback;
    Runnable complete;
    int times;
    public TickTask(Runnable callback,int times,Runnable complete) {
        this.callback=callback;
        this.complete=complete;
        this.times=times==0?-1:times;
    }
    public TickTask(Runnable callback,int times) {
        this.callback=callback;
        this.times=times==0?-1:times;
    }
    public TickTask(Runnable callback) {
        this.callback=callback;
        this.times=-1;
    }
    public void run() {
        callback.run();
        if(this.times!=-1){
            this.times--;
            if(this.times==0){
                this.cancel();
                if(this.complete!=null){
                    this.complete.run();
                }
                //this.purge();
            }
        }
    }
}

public class Tick {
    private Timer timer;
    public Tick loop(int time,Runnable callback,int times,Runnable complete){
        timer = new Timer();
        timer.schedule(new TickTask(callback,times,complete), 0, time); 
        return this;
    }
    public Tick loop(int time,Runnable callback,int times){
        return loop(time,callback,times,null);
    }
    public Tick loop(int time,Runnable callback){
        return loop(time,callback,0,null);
    }
    public Tick delay(int time,Runnable callback){
        timer = new Timer();
        timer.schedule(new TickTask(()->{
            timer.cancel();
            timer.purge();
            callback.run();
        }), time); 
        return this;
    }

    public void stop(){
        timer.cancel();
        timer.purge();
    }
}
