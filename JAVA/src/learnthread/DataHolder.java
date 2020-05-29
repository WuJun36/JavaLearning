package learnthread;

public class DataHolder {
    private Object lockObj = new Object();

    private long number = 0;
    private static long numberStatic = 0;

    public synchronized void change(long delta){
        number += delta;
    }

    public void changeSyncBlock(long delta){
        int abc = 99;
        synchronized (lockObj){
            number += delta;
        }
        int cde = 987;
    }

    public synchronized static void changeStatic(long delta){
        numberStatic += delta;
    }


    public void print(){
        System.out.println("Number = " + number);
    }

    public static void printStatic() {
        System.out.println("static Number=" + numberStatic);
    }
}
