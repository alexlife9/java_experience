package ru.alex_life.multithreading;

import java.util.concurrent.*;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Callable и Future
 *
 * Callable, так же как и Runnable, представляет собой определенное задание, которое выполняется потоком.
 * Callable умеет возвращать значение метода и может выбрасывать Exception
 * Callable можно использовать только с ExecutorService.
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
public class FactorialCallable {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialC factorialC = new FactorialC(5);
        Future<Integer> integerFuture = executorService.submit(factorialC);
        try {
            factorialResult = integerFuture.get();
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

class FactorialC implements Callable<Integer> {
    int f;

    public FactorialC(int f) {
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
        }
        return rsl;
    }
}