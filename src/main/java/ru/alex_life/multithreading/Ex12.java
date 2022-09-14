package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Понятие "монитор". Synchronized blocks
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 */
public class Ex12 {

    synchronized void mobileCall() {
        System.out.println(this);
        System.out.println("mobile call starts");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mobile call ends");
    }

    synchronized void skypeCall() {
        System.out.println(this);
        System.out.println("skype call starts");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("skype call ends");
    }

    synchronized void whatsappCall() {
        System.out.println(this);
        System.out.println("whatsapp call starts");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("whatsapp call ends");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableMobbile());
        Thread thread2 = new Thread(new RunnableSkype());
        Thread thread3 = new Thread(new RunnableWhatsapp());

        thread1.start();
        thread2.start();
        thread3.start();

        /**
         * после запуска метода main видим следующую картину:
         * ru.alex_life.multithreading.Ex12@146427dc
         * ru.alex_life.multithreading.Ex12@7eca7e8a
         * ru.alex_life.multithreading.Ex12@6ec42616
         * whatsapp call starts
         * mobile call starts
         * skype call starts
         * mobile call ends
         * skype call ends
         * whatsapp call ends
         *
         * методы хоть и синхронизированы, но обращаются к разным объектам, поэтому методы работают одновременно
         * исправим это - см. Ex12Edits
         */
    }

}

class RunnableMobbile implements Runnable {
    @Override
    public void run() {
        new Ex12().mobileCall();
    }
}

class RunnableSkype implements Runnable {
    @Override
    public void run() {
        new Ex12().skypeCall();
    }
}

class RunnableWhatsapp implements Runnable {
    @Override
    public void run() {
        new Ex12().whatsappCall();
    }
}