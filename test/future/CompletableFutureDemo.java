/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/19/19 8:37 PM
 */

package future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行耗时操作...");
            timeConsumingOperation();
            return 100;
        });
        completableFuture.whenComplete((result, e) -> {
            System.out.println("结果：" + result);
        });
        System.out.println("主线程运算耗时:" + (System.currentTimeMillis() - l) + " ms");
        new CountDownLatch(1).await();
    }

    static void timeConsumingOperation() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}