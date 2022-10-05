package ru.alex_life.multithreading.threadsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Синхронизированные коллекции
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class SynchronizedCollectionEx4 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        List<Integer> syncList = Collections.synchronizedList(arrayList); //создаем синхронизированный аррэйлист
        //создаем одну задачу
        Runnable runnable1 = () -> {
            synchronized (syncList) { // ставим Лок на критическую секцию итератора
                Iterator<Integer> iterator = syncList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };
        //теперь до тех пор пока выше не будет полностью выполнена итерация, метод remove не будет вызван.
        Runnable runnable2 = () -> {
            syncList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2); //этот поток после синхронизации будет ждать окончания работы thread1
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(syncList); //выводим в консоль синхронизированный лист

    }
}
