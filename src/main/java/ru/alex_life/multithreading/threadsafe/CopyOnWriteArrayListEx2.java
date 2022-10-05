package ru.alex_life.multithreading.threadsafe;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * CopyOnWriteArrayList
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class CopyOnWriteArrayListEx2 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("name1");
        list.add("name2");
        list.add("name3");
        list.add("name4");
        list.add("name5");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> iterator = list.iterator(); //на момент запуска итератора создается копия Листа
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
            list.remove(4); //тут создается еще одна копия
            list.add("name6"); //и тут снова еще одна копия
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
        //в консоли видим ConcurrentModificationException
        //поэтому создаем потокобезопасный CopyOnWriteArrayList. смотри CopyOnWriteArrayListEx2
    }
}
