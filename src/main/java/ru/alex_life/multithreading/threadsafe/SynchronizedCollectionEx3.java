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
public class SynchronizedCollectionEx3 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        List<Integer> syncList = Collections.synchronizedList(arrayList); //создаем синхронизированный аррэйлист
        //создаем одну задачу
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = syncList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        };
        Runnable runnable2 = () -> {
            syncList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(syncList); //выводим в консоль синхронизированный лист
        //в консоли видим что раз на раз не приходится. иногда все равно выскакивает ConcurrentModificationException
        // это происходит потому что итераторы подвержены сбоям при работе с коллекциями
        // и чтобы обезопасить от эксепшена, необходимо целиком блокировать лист на время его перебора
        // при этом метод remove сам ставит Лок на время удаления. Но при итерации никакой Лок сам не ставится. Его
        // необходимо прописать вручную, чтобы не выбрасывался ConcurrentModificationException.
        // это делается с помощью ключевого слова synchronized. Смотри SynchronizedCollectionEx4
    }
}
