package ru.alex_life.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Lock и ReentrantLock
 *
 * метод tryLock - попытайся сделать Lock
 * может выполнять какую-то логику пока поток занят или делать Lock, если ресурс свободен.
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.10.2022
 */
class Bankomat {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee("alex", lock);
        new Employee("oleg", lock);
        new Employee("vas", lock);
        Thread.sleep(5000);
        new Employee("mary", lock);
        new Employee("petr", lock);
    }
}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start(); /* сразу запускаем потоки (при создании объекта с помощью конструктора) */
    }
    public void run() {
        if (lock.tryLock()) {
            try {
                //System.out.println(name + " ждет... ");
                //lock.lock();
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " - работа с банкоматом завершена");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди");
        }
    }

}
