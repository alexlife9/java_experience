package ru.alex_life.multithreading;

import java.util.concurrent.*;

/**
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class FactorialCallable2 {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialC2 factorialC = new FactorialC2(5);
        Future<Integer> future = executorService.submit(factorialC);
        try {
            System.out.println(future.isDone()); // работа еще не выполнена - false
            System.out.println("хотим получить результат");
            factorialResult = future.get();
            System.out.println("получили результат");
            System.out.println(future.isDone()); // работа выполнена - true
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class FactorialC2 implements Callable<Integer> {
    int f;

    public FactorialC2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("вы ввели неверное число");
        }
        int rsl = 1;
        for (int i = 1; i <= f; i++) {
            rsl *= i;
            Thread.sleep(1000);
        }
        return rsl;
    }
}
