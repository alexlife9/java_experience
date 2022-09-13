package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * States Thread
 *
 * Поток имеет 3 основных состояния: New, Runnable, Terminated
 * Runnable при этом имеет два режима: Ready и Running
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class Ex8StatesThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("начинаем работу потока main");
        Thread thread = new Thread(new Worker2());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
        System.out.println("метод main закончил работу");
    }
}

class Worker2 implements Runnable {
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
