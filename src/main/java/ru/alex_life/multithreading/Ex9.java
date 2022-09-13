package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Методы Sleep и Join
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class Ex9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("начинаем работу потока main");
        Thread thread = new Thread(new Worker());
        thread.start();
        thread.join(1500); //если в параметры передать время ожидания, то что наступит первым то и сработает
        System.out.println("метод main закончил работу");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("начинаем работу потока Thread");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("работа потока Thread закончена");
    }
}