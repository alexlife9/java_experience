package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Варианты создания потоков
 *
 * Упрощенная запись Ex2
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.09.2022
 */
public class Ex2EasierRecording extends Thread {
    /* тут создаем поток */
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Ex2EasierRecording thr1 = new Ex2EasierRecording();
        thr1.start(); //запускаем созданный поток

        for (int i = 1000; i > 0; i--) { //и запускаем код в потоке main
            System.out.println(i);
        }
    }
}
