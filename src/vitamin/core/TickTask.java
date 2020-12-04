package vitamin.core;


import java.util.TimerTask;

public class TickTask extends TimerTask {
    Runnable callback;
    Runnable complete;
    int times;

    public TickTask(Runnable callback, int times, Runnable complete) {
        this.callback = callback;
        this.complete = complete;
        this.times = times == 0 ? -1 : times;
    }

    public TickTask(Runnable callback, int times) {
        this.callback = callback;
        this.times = times == 0 ? -1 : times;
    }

    public TickTask(Runnable callback) {
        this.callback = callback;
        this.times = -1;
    }

    public void run() {
        callback.run();
        if (this.times != -1) {
            this.times--;
            if (this.times == 0) {
                this.cancel();
                if (this.complete != null) {
                    this.complete.run();
                }
                // this.purge();
            }
        }
    }
}