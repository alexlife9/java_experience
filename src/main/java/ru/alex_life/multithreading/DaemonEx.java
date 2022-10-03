package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Daemon потоки
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class DaemonEx {
    public static void main(String[] args) {
        System.out.println("main-thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("user_thread");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemon_thread");
        daemonThread.setDaemon(true); /* назначили этот поток Демоном */
        userThread.start();
        daemonThread.start(); /* сначала нужно установить поток Демоном и лишь потом запускать */
        System.out.println("main-thread ends");

        /* в консоли увидим что программа завершит свою работу после вывода букв с A до J, несмотря на то что числа
        * второго потока (который обозначили как Демон) вывелись еще не все */
    }

}

class UserThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " это демон поток" + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " это демон поток" + isDaemon());
        for (int i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}