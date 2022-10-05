package ru.alex_life.multithreading.threadsafe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Синхронизированные коллекции
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class SynchronizedCollectionEx2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        //создаем одну задачу
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        };
        Runnable runnable2 = () -> {
            arrayList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(arrayList);
        // выбрасывается ConcurrentModificationException, потому что с аррэйлистом одновременно работают 2 потока -
        // итератор пытается вывести в консоль элементы и в тоже время второй поток удаляет один из элементов.
        // поэтому помещаем аррэйлист в класс-обертку - смотри SynchronizedCollectionEx3
    }
}
