/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Project: algorithm
 * @Time: 8/19/19 7:05 PM
 */

package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 试验 Java 的 Future 用法
 */
public class FutureTest2 {

    /*
     * step 3:
     * callable实现的有返回值的并发编程
     * 用future获取返回值
     */
    public static class Task implements Callable<String> {
        @Override
        public String call() throws Exception {
            String tid = String.valueOf(Thread.currentThread().getId());
//            System.out.println("Thread :" + tid);
            return tid;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            results.add(es.submit(new Task()));

        for (Future<String> res : results)
            System.out.println(res.get());
    }
}