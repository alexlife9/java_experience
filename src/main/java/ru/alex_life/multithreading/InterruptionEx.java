package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Прерывание потоков
 *
 * С помощью метода interrupt() можно послать сигнал потоку о том, что мы хотим его прервать
 * Также с помощью метода isInterrupted() в самом потоке можно проверить, хотят ли его прервать. И решение о том, что
 * делать если хотят прервать поток, должен принимать сам программист.
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class InterruptionEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main-thread starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        //thread.stop(); // этот метод грубого прерывания потока не используется из-за непонятного состояния потока после прерывания
        thread.interrupt(); //поэтому используется interrupt который говорит потоку о том что его ХОТЯТ прервать
        //если поток видит что его хотят прервать, то он может реагировать на это совершенно по разному

        thread.join();
        System.out.println("main-thread ends");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;
    @Override
    public void run() {
       for (int i = 0; i < 1_000_000_000; i++) {
           if (isInterrupted()) { //метод возвращает true если видит что поток ХОТЯТ прервать с помощью thread.interrupt()
               System.out.println("поток хотят прервать");
               System.out.println("убедились что состояние всех объектов нормально и приняли решение прервать поток");
               System.out.println(sqrtSum);
               return;
               // мы сами решаем что делать получив сигнал о желании прервать поток
           }
           sqrtSum += Math.sqrt(i); //находим сумму корней чисел от 1 до лярда.
           try {
               sleep(100);
           } catch (InterruptedException e) {
               System.out.println("поток хотят прервать во время сна, надо выкинуть эксепшен");
               System.out.println(sqrtSum);
               return;
           }
       }
        System.out.println(sqrtSum);
    }
}
