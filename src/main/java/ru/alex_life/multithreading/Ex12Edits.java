package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Понятие "монитор". Synchronized blocks
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 *
 * добиваемся синхронизации методов по одному объекту
 */
public class Ex12Edits {
    static final Object LOCK = new Object(); /* создадим рандомный объект и будем использовать его для синхронизации */

    void mobileCall1() {
        synchronized (LOCK) {
            System.out.println("mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("mobile call ends");
        }
    }

    synchronized void skypeCall1() {
        synchronized (LOCK) {
            System.out.println("skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("skype call ends");
        }
    }

    synchronized void whatsappCall1() {
        synchronized (LOCK) {
            System.out.println("whatsapp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("whatsapp call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableMobbile1());
        Thread thread2 = new Thread(new RunnableSkype1());
        Thread thread3 = new Thread(new RunnableWhatsapp1());

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class RunnableMobbile1 implements Runnable {
    @Override
    public void run() {
        new Ex12Edits().mobileCall1();
    }
}

class RunnableSkype1 implements Runnable {
    @Override
    public void run() {
        new Ex12Edits().skypeCall1();
    }
}

class RunnableWhatsapp1 implements Runnable {
    @Override
    public void run() {
        new Ex12Edits().whatsappCall1();
    }
}