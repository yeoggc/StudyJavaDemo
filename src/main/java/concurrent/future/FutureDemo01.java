package concurrent.future;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureDemo01 {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<String> future = es.submit(() -> {
            // to do some work
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "compute result";
        });

        // 1. 阻塞方式获取异步计算结果
        System.out.println(future.get());
        System.out.println("End...");

        //2. 轮询方式获取异步计算结果
        //while (future.isDone()){
        //    System.out.println(future.get());
        //    System.out.println("End...");
        //}

    }

    public void test2() throws ExecutionException, InterruptedException {


    }

}
