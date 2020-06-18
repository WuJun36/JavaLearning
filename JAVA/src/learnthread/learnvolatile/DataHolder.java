package learnthread.learnvolatile;

public class DataHolder {
    int a, b, c, d, f, g;
    volatile long e;

    public void operateData() {
        a += 1;
        b += 1;
        c += 1;
        d += 1;
        e += 1;
        f += 1;
        g += 1;
    }

    int counter;

    public void check() {
        if (g > e) {
            System.out.println("got it" + counter++);
        }
    }
}
