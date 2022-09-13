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
public class Ex8 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyRunneble1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunneble1());
        Ex8 thread2 = new Ex8();
        thread1.start(); //запускаем оба созданных потока, которые выводят числа от 1 до 10
        thread2.start(); //и перед этим пишут названия потока в котором они это сделали

        thread1.join(); // join означает что поток main будет ждать завершения потоков thread1 и thread2
        thread2.join(); //и только после этого продолжит свою работу. а в продолжении у нас записано - выводи "Финиш".
        System.out.println("Финиш"); // этот оутпут выведется первым, потому что метод main не усыпляли.
        // поэтому можно добавить join, чтобы поток main ждал завершение первых двух потоков
    }
}
