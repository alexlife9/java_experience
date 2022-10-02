package ru.alex_life.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Lock и ReentrantLock
 *
 * Lock – это интерфейс, который имплементируется классом ReentrantLock.
 * Также как ключевое слово synchronized, Lock нужен для достижения синхронизации между потоками.
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.10.2022
 */
public class LockEx {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.skypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.waCall();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

    }

    static class Call {
        private Lock lockEx = new ReentrantLock();

        void mobileCall() {
            lockEx.lock();
            try {
                System.out.println("Звонок начался");
                Thread.sleep(3000);
                System.out.println("Звонок завершен");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockEx.unlock();
            }
        }

        void skypeCall() {
            lockEx.lock();
            try {
                System.out.println("Звонок skype начался");
                Thread.sleep(5000);
                System.out.println("Звонок skype завершен");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockEx.unlock();
            }
        }

        void waCall() {
            lockEx.lock();
            try {
                System.out.println("Звонок whatsapp начался");
                Thread.sleep(7000);
                System.out.println("Звонок whatsapp завершен");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockEx.unlock();
            }
        }
    }
}
