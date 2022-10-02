package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * DeadLock
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.10.2022
 */
public class DeadLockExNot {
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();

    public static void main(String[] args) {
        DeadLockExNot.Thread1 thread1 = new DeadLockExNot.Thread1();
        DeadLockExNot.Thread2 thread2 = new DeadLockExNot.Thread2();
        thread1.start();
        thread2.start();

        /* синхронизируемся в одинаковом порядке для разных методов */
    }

    static class Thread1 extends Thread {
        public void run() {
            System.out.println("Thread10: попытка захватить монитор объекта LOCK1. ожидание...");
            synchronized (DeadLockExNot.LOCK1) { /* запускаем LOCK1 и потом LOCK2. аналогично делаем в Thread2*/
                System.out.println("Thread10: монитор объекта LOCK1 захвачен");

                System.out.println("Thread10: попытка захватить монитор объекта LOCK2. ожидание...");
                synchronized (DeadLockExNot.LOCK2) {
                    System.out.println("Thread10: мониторы объектов LOCK1 и LOCK2 захвачены");
                }

            }

        }
    }

    static class Thread2 extends Thread {
        public void run() {
            System.out.println("Thread20: попытка захватить монитор объекта LOCK2. ожидание...");
            synchronized (DeadLockExNot.LOCK1) { /* запускаем LOCK1 и потом LOCK2. аналогично делаем в Thread1 */
                System.out.println("Thread20: монитор объекта LOCK2 захвачен");

                System.out.println("Thread20: попытка захватить монитор объекта LOCK1. ожидание...");
                synchronized (DeadLockExNot.LOCK2) {
                    System.out.println("Thread20: мониторы объектов LOCK1 и LOCK2 захвачены");

                }

            }

        }
    }
}
