package learnthread;

public class CreateThreadAppMain {

    private static final String TEXT = "无所不能威神V,钱锟，李永钦，董思成，黄旭熙，肖俊，黄冠亨，刘扬扬";
    public static void main(String[] args) {
        //TODO 代码是被线程执行的，任何代码都可以通过Thread.currentThread()获取当前执行这段代码的线程
        System.out.println("程序开始，执行的线程名字叫做" + Thread.currentThread().getName());

        for (int i = 1; i <= 2; i++) {
            // TODO runable里的run是线程执行的方法，执行完了，线程也就结束了
            // TODO 理解代码是在线程里执行的，同样的代码可以被多个线程执行
            Thread thread = new Thread(new PrintStoryRunnable(TEXT,200),"我的线程-" + i);
            // TODO 创建好线程之后，如果要启动线程，必须调用start方法，注意不是run方法
            thread.start();
        }
        System.out.println("启动线程结束：" + Thread.currentThread().getName());
    }

    static class PrintStoryRunnable implements Runnable {
        private String text;
        private long interval;

        public PrintStoryRunnable(String text, long interval) {
            this.text = text;
            this.interval = interval;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行这段代码的名字叫做：" + Thread.currentThread().getName());
                printSlowly(text,interval);
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void printSlowly(String text, long interval) throws InterruptedException {
        for (char ch : text.toCharArray()) {
            Thread.sleep(interval);
            System.out.print(ch);
        }

        System.out.println();
    }
}
