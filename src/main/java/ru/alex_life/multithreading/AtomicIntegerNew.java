package ru.alex_life.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Класс AtomicInteger
 *
 * При использовании класса AtomicInteger невозможно состояние гонки потоков Date Race
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.09.2022
 */
public class AtomicIntegerNew {
    // static int counter = 0;

    static AtomicInteger counter = new AtomicInteger(0); //дефолтное значение 0
    public static void increment() {
            //counter++;
        counter.incrementAndGet(); //метод "увеличь и отдай"
        counter.addAndGet(5); //метод увеличивает сразу на указанное число
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl19());
        Thread thread2 = new Thread(new MyRunnableImpl19());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}

class MyRunnableImpl19 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerNew.increment();
        }
    }
}
