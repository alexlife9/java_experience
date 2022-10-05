package ru.alex_life.multithreading.threadsafe;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * ArrayBlockingQueue
 *
 * Самые распространенные Concurrent-коллекции - ConcurrentHashMap, CopyOnWriteArrayList и ArrayBlockingQueue
 * ArrayBlockingQueue - потокобезопасная очередь с ограниченным размером (надо сразу указывать capacity)
 * Обычно один или несколько потоков добавляют элементы в конец очереди, а другие потоки забирают элементы из начала очереди
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class ArrayBlockingQueueEx1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4); //очередь из 4 элементов
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        queue.offer(5); //если добавлять с помощью add, то будет эксепшен. если с offer, то просто не добавится
        System.out.println(queue);
    }
}