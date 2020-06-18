package learnthread.learntime;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class LearnTimerAppMain {
    public static void main(String[] args){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FindABCTask(),0, TimeUnit.SECONDS.toMillis(10));
    }
}
