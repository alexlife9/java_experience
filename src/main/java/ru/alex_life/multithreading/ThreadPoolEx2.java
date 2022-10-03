package ru.alex_life.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * ThreadPool и ExecutorService
 *
 * ThreadPool - это множество потоков, каждый из которых предназначен для выполнения той или иной задачи.
 * В Java c тред-пулами удобнее всего работать посредством ExecutorService.
 * factory методы - фабрика по производству объектов без конструктора.
 *
 * ThreadPool удобнее всего создавать, использую factory методы класса Executors:
 * Executors.newFixedThreadPool(5); - создаст пул с 5-ю потоками
 * Executors.newSingleThreadExecutor(); - создаст пул с одним потоком
 * newCachedThreadPool - создает кешированный пул, который создает в себе потоки по надобности
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(1);
        scheduledExecutorService1.schedule(
                new RunnableImp200(), 3, TimeUnit.SECONDS); //выполни задание RunnableImp200 ЧЕРЕЗ 3 секунды
        scheduledExecutorService1.shutdown(); //завершаем программу после выполнения задания

        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(1);
        scheduledExecutorService2.scheduleAtFixedRate(
                new RunnableImp200(), 3, 1, TimeUnit.SECONDS); //планируем задание на выполнение через
        //3 секунды и потом повторяем через 1 секунду. Повторяем через 1 секунду даже если время на задание будет потрачено 7 секунд.
        //потому что тут период 1 секунда это время между началом первого задания и началом второго задания.
        Thread.sleep(10000); //10 секунд поток будет ждать перед тем как вызвать метод shutdown
        scheduledExecutorService2.shutdown(); //завершаем программу после периодического выполнения задания

        ScheduledExecutorService scheduledExecutorService3 = Executors.newScheduledThreadPool(1);
        scheduledExecutorService3.scheduleWithFixedDelay(
                new RunnableImp100(), 3, 5, TimeUnit.SECONDS); //отличие в том что тут будем ждать 5 секунд
        //между ОКОНЧАНИЕМ первого задания и НАЧАЛОМ второго задания
        Thread.sleep(10000); //10 секунд поток будет ждать перед тем как вызвать метод shutdown
        scheduledExecutorService3.shutdown(); //завершаем программу после периодического выполнения задания

        ExecutorService scheduledExecutorService4 = Executors.newCachedThreadPool(); //удаляет поток который не используется 60 секунд
    }
}

class RunnableImp200 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " задание начало выполняться");
        try {
            Thread.sleep(3000); //сколько спать между заданиями
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " задание выполнено");
    }
}