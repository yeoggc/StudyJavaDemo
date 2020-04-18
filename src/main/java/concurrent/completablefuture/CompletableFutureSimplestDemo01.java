package concurrent.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureSimplestDemo01 {

    public static void main(String[] args) throws InterruptedException {

        //创建异步执行任务
        CompletableFuture<Double> cf =
                //fetchPrice()静态方法的签名符合Supplier接口的定义，使用Java8 方法引用特性 进行简化。
                CompletableFuture.supplyAsync(CompletableFutureSimplestDemo01::fetchFund);


        cf.thenAccept((result) -> {// 如果执行成功
            System.out.println("price: " + result);
        }).exceptionally(exception -> {// 如果执行异常
            exception.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        TimeUnit.SECONDS.sleep(2);
    }

    static Double fetchFund() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 2 + Math.random() * 22;
    }

}
