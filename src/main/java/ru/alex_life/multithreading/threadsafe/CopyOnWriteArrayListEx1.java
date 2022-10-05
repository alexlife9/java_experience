package ru.alex_life.multithreading.threadsafe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * CopyOnWriteArrayList
 *
 * Самые распространенные Concurrent-коллекции - ConcurrentHashMap, CopyOnWriteArrayList и ArrayBlockingQueue
 *
 * CopyOnWriteArrayList имплементирует интерфейс List
 * CopyOnWriteArrayList следует использовать тогда, когда вам нужно добиться потокобезопасности, при небольшом кол-ве
 * операций по изменению элементов и большое кол-во по их чтению.
 * Условие небольшого кол-ва по изменению элементов не просто так - для изменения нужно полностью скопировать Лист,
 * а это весьма трудозатратно.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class CopyOnWriteArrayListEx1 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        list.add("name1");
        list.add("name2");
        list.add("name3");
        list.add("name4");
        list.add("name5");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
            list.add("name6");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2); //этот поток после синхронизации будет ждать окончания работы thread1
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
        //в консоли видим ConcurrentModificationException
        //поэтому создаем потокобезопасный CopyOnWriteArrayList. смотри CopyOnWriteArrayListEx2
    }
}
