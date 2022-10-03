package ru.alex_life.multithreading;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinPool
 *
 * https:\\habr.com/ru/post/565924/
 *
 * Сначала мы будем рекурсивно делить наш массив на всё более мелкие части, пока не получим массивы,
 * состоящие всего из 2 элементов. Почему именно из 2? Потому что наш условный «слабенький» процессор может условно
 * «быстро» выполнить именно такую условно «маленькую» задачу. Почему рекурсивно? Просто потому, что применение рекурсии
 * в данном случае действительно удобно. Это позволяет сначала выполнить некую работу по подготовке,
 * а потом получить результат. Если вам не нравится рекурсия, то, наверное, можно попробовать найти
 * какой-то другой способ, её применение, судя по всему, не является обязательным.
 *
 * После того, как мы получим «100500» маленьких массивов, состоящих всего из 2 элементов,
 * мы запустим «100500» маленьких задач на выполнение и суммируем их результаты.
 * И для этого нам не придётся создавать 100500 отдельных нитей выполнения.
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
class ValueSumCounter extends RecursiveTask<Integer> {

    private int[] array;

    public ValueSumCounter(int[] array) {
        this.array = array;
    }

    /**
     * При создании экземпляра класса ValueSumCounter мы передаём в него массив.
     * В методе compute() сначала проверяется длина массива, и если он «слишком большой», то разбивается пополам на 2 части,
     * на основе каждой из которых в свою очередь создаётся своя задача и отправляется на выполнение путём вызова метода fork().
     * Когда разбивка будет закончена, наступает время «собирать камни», метод join() запускает каждую задачу
     * на выполнение и возвращает полученный результат.
     * Выполнение данной задачи с помощью ForkJoinPool заняло у меня на компьютере 3 секунды.
     * Напомню, что эта же задача, выполненная с помощью цикла в одном потоке, ранее (см ForkJoinPoolEx) заняла 17 секунд.
     */
    @Override
    protected Integer compute() {
        if (array.length <= 2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.stream(array).sum();
        }
        ValueSumCounter firstHalfArrayValueSumCounter =
                new ValueSumCounter(Arrays.copyOfRange(array, 0, array.length / 2));
        ValueSumCounter secondHalfArrayValueSumCounter =
                new ValueSumCounter(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}

class Main {
    public static void main(String[] args) {
        int[] array = getInitArray(10000);
        ValueSumCounter counter = new ValueSumCounter(array);
        System.out.println(new Date());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(counter));
        System.out.println(new Date());
    }

    public static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = 3;
        }
        return array;
    }
}
