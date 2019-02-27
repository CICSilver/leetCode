import java.util.ArrayList;
import java.util.concurrent.*;

public class threadTest {
    public static int counts=0;
    public static void main(String[] args) {
        threadTest threadTest=new threadTest();
        ScheduledExecutorService pool=Executors.newScheduledThreadPool(3);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("线程执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counts++;
            System.out.println("线程执行完成"+counts);
        }, 0, 3, TimeUnit.SECONDS);
    }
}