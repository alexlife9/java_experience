package ru.alex_life.multithreading;

import java.util.concurrent.Semaphore;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Синхронизатор Semaphore
 *
 * Семафор — это средство для синхронизации доступа к какому-то ресурсу.
 * Его особенность заключается в том, что при создании механизма синхронизации он использует счетчик.
 * Счетчик указывает нам, сколько потоков одновременно могут получать доступ к общему ресурсу.
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2022
 */
public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2); /* два потока имеют доступ к одному ресурсу */

        new Person("name1", callBox);
        new Person("name2", callBox);
        new Person("name3", callBox);
        new Person("name4", callBox);
        new Person("name5", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore callbox;


    Person(String name, Semaphore callbox) {
        this.name = name;
        this.callbox = callbox;
        this.start();
    }

    public void run() {
        try {
            System.out.println(name + " ждет...");
            callbox.acquire(); /* предназначен для попытки получить разрешение от Семафора */
            System.out.println(name + "пользуется телефоном");
            sleep(2000);
            System.out.println(name + "звонок завершен");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            callbox.release(); /* освобождаем разрешение у семафора и увеличиваем счетчик на единицу */
        }
    }
}