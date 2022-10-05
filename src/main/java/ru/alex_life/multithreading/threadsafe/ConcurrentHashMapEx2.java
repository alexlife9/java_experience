package ru.alex_life.multithreading.threadsafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * ConcurrentHashMap
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class ConcurrentHashMapEx2 {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(); //создали потокобезопасный ConcurrentHashMap
        map.put(1, "name1");
        map.put(2, "name2");
        map.put(3, "name3");
        map.put(4, "name4");
        map.put(5, "name5");
        System.out.println(map); //выводим все элементы в консоль

        //запускаем первый поток, который выводит все пары (ключ-значение) в консоль
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = map.keySet().iterator(); //у HashMap нет метода итерирования, но он есть у keySet
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        };

        //запускаем второй поток, в котором добавляем еще один элемент в мапу
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "name6");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2); //этот поток после синхронизации будет ждать окончания работы thread1
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map); //выводим в консоль синхронизированный лист

    }
}
