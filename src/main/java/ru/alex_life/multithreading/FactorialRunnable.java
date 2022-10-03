package ru.alex_life.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Callable и Future
 *
 * Callable, так же как и Runnable, представляет собой определенное задание, которое выполняется потоком.
 * Callable умеет возвращать значение метода и может выбрасывать Exception
 *
 * метод submit() передает задание в тред-пул для выполнения его одним из потоков, и возвращает тип Future,
 * в котором и хранится результат выполнения задания.
 *
 * метод get позволяет получить результат выполнения задания из объекта Future
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class FactorialRunnable {
    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialR factorial = new FactorialR(5);
        executorService.execute(factorial);
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(factorialResult);

    }
}


class FactorialR implements Runnable {
    int f;

    public FactorialR(int f) {
        this.f = f;
    }

    @Override
    public void run() {
        if (f <= 0) {
            System.out.println("вы ввели неверное число");
            return;
        }
        int rsl = 1;
        for (int i = 1; i <= f; i++) {
            rsl *= i;
        }
        FactorialRunnable.factorialResult = rsl;

    }
}