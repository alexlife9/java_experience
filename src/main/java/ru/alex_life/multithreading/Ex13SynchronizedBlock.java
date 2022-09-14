package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Понятие "монитор". Synchronized blocks
 *
 * Синхронизация идет всегда по монитору
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 */
public class Ex13SynchronizedBlock {
    volatile static int counter = 0;

    public static synchronized void increment() { /* в случае статичного метода используется монитор всего класса */
        counter++;
    }
    /* запись выше аналогична вот этой:
    *   public static void increment() {
    *      synchronized (Ex13SynchronizedBlock.class) {
    *          counter++;
    *      }
    *  }
    */

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R13());
        Thread thread2 = new Thread(new R13());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}

class R13 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Ex13SynchronizedBlock.increment();
        }
    }
}

