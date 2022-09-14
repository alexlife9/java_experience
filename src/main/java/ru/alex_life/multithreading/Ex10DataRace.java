package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Data Race
 *
 * Data Race - это "гонка данных". Разные потомки с разной скоростью выполняют свою работу стремясь ее завершить.
 * Data Race - это проблема которая может возникнуть когда два и более потоков обращаются к одной и той же переменной
 * и как минимум 1 поток изменяет эту переменную.
 *
 * Чтобы избежать этой проблемы - в методе объявляется ключевое слово synchronized.
 * Это блокирует метод только для работы с одним потоком.
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 */
public class Ex10DataRace {
    public static void main(String[] args) {
        MyRunnable3 runnable3 = new MyRunnable3();
        Thread thread1 = new Thread(runnable3);
        Thread thread2 = new Thread(runnable3);
        Thread thread3 = new Thread(runnable3);
        thread1.start();
        thread2.start();
        thread3.start();
        /* в консоль будут выводится цифры в произвольной последовательности каждый раз*/
    }
}

class Counter {
    volatile static int count = 0;
}

class MyRunnable3 implements Runnable {
    public synchronized void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }

    }
}
