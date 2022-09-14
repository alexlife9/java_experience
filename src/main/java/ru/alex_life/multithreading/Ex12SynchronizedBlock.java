package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Понятие "монитор". Synchronized blocks
 *
 * Монитор - это сущность/механизм, благодаря которому достигается корректная работа при синхронизации.
 * У каждого класса и объекта есть привязанный к нему монитор
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 */
public class Ex12SynchronizedBlock {
    public static void main(String[] args) {
        MyRunnable12 runnable = new MyRunnable12();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter12 {
    volatile static int count = 0;
}

class MyRunnable12 implements Runnable {

    private void doWork123() {
        System.out.println("privet");
    }
    private void doWork12() {
        doWork123(); /* вызов этого метода будет не синхронизирован, если в методе doWork12 нет кл.слова synchronized*/
        synchronized (this) { /* если метод не статичный, то синхронизация будет всегда  на объекте this */
 /* public synchronized void doWork12() - можно не писать this в случае с синхронизированными методами */
            Counter12.count++;
            System.out.println(Counter12.count);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork12();
        }

    }
}
