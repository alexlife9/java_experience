package ru.alex_life.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Callable и Future
 *
 * Считаем сумму чисел от 1 до миллиарда с помощью 10 потоков
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class SumNumbers {
    private static final long VALUE = 1_000_000_000;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futuresRsl = new ArrayList<>();
        long valueDivideBy10 = VALUE / 10; //разбиваем подсчет на 10 потоков
        for (int i = 0; i < 10; i++) {
            long from = valueDivideBy10 * i + 1; //первый поток будет считать от 0 до 100_000_000
            long to = valueDivideBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum = executorService.submit(task);
            futuresRsl.add(futurePartSum);
        }
        for (Future<Long> result : futuresRsl) {
            sum += result.get();
        }
        executorService.shutdown();
        System.out.println("итоговый результат: " + sum);

    }
}

class PartialSum implements Callable<Long> {
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for (long i = from; i <= to; i++) {
            localSum += i;
        }
        System.out.println("сумма от " + from + " до " + to + " = " + localSum);
        return localSum;
    }
}
