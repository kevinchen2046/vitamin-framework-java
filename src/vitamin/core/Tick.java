package vitamin.core;

import java.util.Timer;

public class Tick {
    private static Timer timer = new Timer();
    public static TickTask loop(int time, Runnable callback, int times, Runnable complete) {
        TickTask task = new TickTask(callback, times, complete);
        if(timer==null) timer=new Timer();
        timer.schedule(task, 0, time);
        return task;
    }

    public static TickTask loop(int time, Runnable callback, int times) {
        return loop(time, callback, times, null);
    }

    public static TickTask loop(int time, Runnable callback) {
        return loop(time, callback, 0, null);
    }

    public static TickTask delay(int time, Runnable callback) {
        TickTask task = new TickTask(() -> {
            // timer.cancel();
            // timer.purge();
            callback.run();
        });
        if(timer==null) timer=new Timer();
        timer.schedule(task, time);
        return task;
    }

    public static void stopTimer() {
        timer.cancel();
        timer.purge();
        timer = null;
    }
}
