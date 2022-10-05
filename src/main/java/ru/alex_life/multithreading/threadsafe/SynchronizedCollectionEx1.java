package ru.alex_life.multithreading.threadsafe;

import java.util.ArrayList;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Синхронизированные коллекции
 *
 * Synchronized-коллекции получаются из традиционных несинхронизированных коллекций
 * благодаря специальным классам оберткам с помощью Lock-ов. Collections.synchronizedSet – например.
 * Concurrent-коллекции изначально созданы для работы с многопоточностью.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class SynchronizedCollectionEx1 {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            source.add(i);
        }
        ArrayList<Integer> target = new ArrayList<>();
        Runnable runnable = () -> {
            target.addAll(source);
        };

        //хотим двумя потоками добавлять все элементы из source в target
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(target);
        //если несколько раз запустить данный пример, то в консоли видим разный результат,
        // который невозможно предугадать и протестировать. это и есть потоко-НЕбезопасность несинхронизированных коллекций
    }
}
