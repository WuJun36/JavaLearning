package learnthread;

public class ChangeData implements Runnable {
    private long delta;
    private int loopCount;
    private DataHolder dataHolder;

    public ChangeData(long delta, int loopCount, DataHolder dataHolder) {
        this.delta = delta;
        this.loopCount = loopCount;
        this.dataHolder = dataHolder;
    }


    @Override
    public void run() {
        for (int i = 0; i < loopCount; i++) {
            DataHolder.changeStatic(delta);
        }
        DataHolder.printStatic();
    }
}
