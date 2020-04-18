package concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSimplestDemo01 {

    public static void main(String[] args) throws InterruptedException {

        //创建异步执行任务
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureSimplestDemo01::fetchPrice);


        cf.thenAccept((result) -> {// 如果执行成功
            System.out.println("price: " + result);
        }).exceptionally(exception -> {// 如果执行异常
            exception.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }

}
