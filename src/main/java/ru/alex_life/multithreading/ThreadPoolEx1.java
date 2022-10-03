package ru.alex_life.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * ThreadPool и ExecutorService
 *
 * ThreadPool - это множество потоков, каждый из которых предназначен для выполнения той или иной задачи.
 * В Java c тред-пулами удобнее всего работать посредством ExecutorService.
 * factory методы - фабрика по производству объектов без конструктора.
 * ThreadPool удобнее всего создавать, использую factory методы класса Executors:
 * Executors.newFixedThreadPool(5); - создаст пул с 5-ю потоками
 * Executors.newSingleThreadExecutor(); - создаст пул с одним потоком
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5); //создали пул с помощью метода
        //в параметры метода можно передать Runtime.getRuntime().availableProcessors()
        // - устанавливает кол-во потоков равное кол-ву ядер процессора конкретного компьютера

        for (int i = 1; i < 10; i++) {
            executorService.execute(new RunnableImp100());
            //метод execute передает задание в тред-пул где оно выполняется одним из потоков
        }
        executorService.shutdown(); //обязательно нужно завершать работу пула
        //после выполнения метода shutdown ExecutorService понимает что новых заданий больше не будет и,
        // выполнив все поступившие ранее задания, прекращает работу

        executorService.awaitTermination(5, TimeUnit.SECONDS); //работает как join, заставляя ожидать поток в
        // котором он вызывается, в данном случае - main будет ждать завершения пяти созданных потоков RunnableImp100
        System.out.println("main ends");
    }
}

class RunnableImp100 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
