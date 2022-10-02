package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * DeadLock
 *
 * DeadLock это ситуация, когда 2 или более потоков золочены навсегда, ожидают друг друга и ничего не делают.
 * Это возникает когда несколько потоков используют синхронизацию на нескольких объектах и используют ее не в одинаковом порядке
 *
 * Например, когда у нас выполняются два потока(Thread10, Thread20) и наш первый поток(Thread10) заблокировал метод a()
 * и второй поток(Thread20) заблокировал метод b() и в то же время поток Thread10 пытается получить доступ к методу b(),
 * а поток Thread20 пытается получить доступ к методу а().
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.10.2022
 */
public class DeadLockEx {
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        Thread1A thread1 = new Thread1A();
        Thread2B thread2 = new Thread2B();
        thread1.start();
        thread2.start();

        /* возможна такая ситуация когда когда оба потока успевают захватить по одному разному объекту
        * и после этого оба потока будут ждать вечно когда освободится один из мониторов у захваченных объектов
        * чтобы исправить эту ситуацию нужно изменить порядок запуска потоков - см. DeadLockExNot*/
    }

    static class Thread1A extends Thread {
        public void run() {
            System.out.println("Thread1A: попытка захватить монитор объекта LOCK1. ожидание...");
            synchronized (DeadLockEx.LOCK1) {
                System.out.println("Thread1A: монитор объекта LOCK1 захвачен");

                System.out.println("Thread1A: попытка захватить монитор объекта LOCK2. ожидание...");
                synchronized (DeadLockEx.LOCK2) {
                    System.out.println("Thread1A: мониторы объектов LOCK1 и LOCK2 захвачены");
                }

            }

        }
    }

    static class Thread2B extends Thread {
        public void run() {
            System.out.println("Thread2B: попытка захватить монитор объекта LOCK2. ожидание...");
            synchronized (DeadLockEx.LOCK2) {
                System.out.println("Thread2B: монитор объекта LOCK2 захвачен");

                System.out.println("Thread2B: попытка захватить монитор объекта LOCK1. ожидание...");
                synchronized (DeadLockEx.LOCK1) {
                    System.out.println("Thread2B: мониторы объектов LOCK1 и LOCK2 захвачены");

                }

            }

        }
    }
}
