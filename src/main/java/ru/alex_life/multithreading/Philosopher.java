package ru.alex_life.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Задача об обедающих философах
 *
 * У нас есть 5 философов, которым нужно пообедать.
 * При этом у нас есть один стол, и одновременно находиться за ним могут не более двух человек.
 * Наша задача — накормить всех философов. Никто из них не должен остаться голодным,
 * и при этом они не должны «заблокировать» друг друга при попытке сесть за стол (мы должны избежать deadlock).
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2022
 */
class Philosopher extends Thread {

    private final Semaphore sem;

    // поел ли философ
    private boolean full = false;

    private final String name;

    Philosopher(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
        this.start(); //запускаем поток после создания объекта
    }

    /**
     * Методы acquire() и release() класса Semaphore управляют его счетчиком разрешений.
     * Метод acquire() запрашивает разрешение на доступ к ресурсу у семафора.
     * Если счетчик > 0, разрешение предоставляется, а счетчик уменьшается на 1.
     * Метод release() «освобождает» выданное ранее разрешение
     * и возвращает его в счетчик (увеличивает счетчик разрешений семафора на 1).
     */
    public void run() {
        try {
            // если философ еще не ел
            if (!full) {
                // Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println(name + " садится за стол");

                // философ ест
                sleep(300);
                full = true;

                System.out.println(name + " поел! Он выходит из-за стола");
                sem.release();

                // философ ушел, освободив место другим
                sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    public static void main(String[] args) {
        //создали семафор со счетчиком 2, чтобы соответствовать условию: одновременно есть могут только два философа.
        // То есть, одновременно работать могут только два потока.
        Semaphore sem = new Semaphore(2);
        new Philosopher(sem, "Сократ");
        new Philosopher(sem, "Платон");
        new Philosopher(sem, "Аристотель");
        new Philosopher(sem, "Фалес");
        new Philosopher(sem, "Пифагор");
    }
}
