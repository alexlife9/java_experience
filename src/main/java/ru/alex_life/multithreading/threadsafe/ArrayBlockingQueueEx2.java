package ru.alex_life.multithreading.threadsafe;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * ArrayBlockingQueue
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class ArrayBlockingQueueEx2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        //Producer - добавляет элементы в очередь с помощью put
        new Thread(() -> {
            int i = 0;
            while (true) { //работаем бесконечно
                try {
                    queue.put(++i); //продуцируем бесконечную очередь элементов
                    System.out.println("Producer добавил элемент: " + i + " " + queue);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //Consumer - получает из очереди элементы
        new Thread(() -> {
            while (true) { //работаем бесконечно
                try {
                    Integer j = queue.take();
                    System.out.println("Consumer забрал элемент: " + j + " " + queue);
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
