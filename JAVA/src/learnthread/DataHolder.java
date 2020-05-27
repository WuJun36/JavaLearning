package learnthread;

public class DataHolder {
    private long number = 0;

    public synchronized void change(long delta){
        number += delta;
    }

    public void print(){
        System.out.println("Number = " + number);
    }
}
