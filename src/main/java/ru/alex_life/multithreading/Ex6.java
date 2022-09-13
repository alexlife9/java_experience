package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс.
 * Thread name и Thread priority
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class Ex6 implements Runnable {
    @Override
    public void run() {
        System.out.println("Method run. Thread name = "
        + Thread.currentThread().getName()); /* узнаем имя текущего потока */
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Ex6());
        thread.start();
        System.out.println("Method main. Thread name = "
                + Thread.currentThread().getName()); /* дефолтное имя метода main как ни странно - main */
    }
}
