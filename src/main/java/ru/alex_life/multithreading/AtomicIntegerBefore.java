package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Класс AtomicInteger
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.09.2022
 */
public class AtomicIntegerBefore {
    static int counter = 0;

    //если тут не указать synchronized, то вывод будет непредсказуемым
    //но synchronized довольно тяжелая операция, каждый раз при обращении потока идет lock/unlock монитора
    //операция не атомарная (не неделимая) - сначала читается значение, потом увеличивается на 1, потом запись в память
    //поэтому для таких случаев надо пользоваться специальным классом - AtomicInteger, в котором все операции атомарны и
    //не нужно будет указывать synchronized. Для этого изменим код - см продолжение в AtomicIntegerNew
    public static synchronized void increment() {
            counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl18());
        Thread thread2 = new Thread(new MyRunnableImpl18());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}

class MyRunnableImpl18 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerBefore.increment();
        }
    }
}
