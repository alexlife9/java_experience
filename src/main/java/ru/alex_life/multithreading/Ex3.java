package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Варианты создания потоков:
 * 1. extends Thread
 * 2. implements Runnable
 *
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.09.2022
 */
public class Ex3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyTHread3());
        Thread thread2 = new Thread(new MyTHread4());
        thread1.start();
        thread2.start();
    }
}

class MyTHread3 implements Runnable { //интерфейс Runnable имеет всего один метод run()
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyTHread4 implements Runnable {
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
