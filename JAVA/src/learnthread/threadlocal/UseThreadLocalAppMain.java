package learnthread.threadlocal;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class UseThreadLocalAppMain {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread workingThread = new Thread(() -> {
                System.out.println("开始处理......");
                PerformanceTracker.reset();

                InputHandler inputHandler = new InputHandler();
                String content = inputHandler.getInput();

                DBQuery query = new DBQuery();
                query.query();

                ConentProcess conentProcess = new ConentProcess();
                conentProcess.process(content);

                PerformanceTracker.finish();
                System.out.println("处理结束");
            }, "Worker-" + i);

            workingThread.start();
        }
    }
}
