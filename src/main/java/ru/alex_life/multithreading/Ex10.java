package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Concurrency и parallelism
 *
 * Concurrency - согласованность
 * Concurrent - параллельный
 *
 * Разницу между Concurrency и parallelism можно объяснить на следующем примере:
 * Есть задания:
 * 1. петь песню и кушать - это будет Concurrency, согласованное переключение между действиями.
 * 2. готовить еду и говорить по телефону - это будет тоже Concurrency, но достигается с помощью параллелизма.
 * Concurrency - это согласованное выполнение сразу нескольких задач - НЕ ОБЯЗАТЕЛЬНО ОДНОВРЕМЕННО!
 * Parallelism - это ОДНОВРЕМЕННОЕ (параллельное) выполнение сразу нескольких задач. Это частный случай Concurrency.
 *
 *
 * Synchronous и asynchronous
 * В синхронном программировании все операции выполняются последовательно друг за другом
 * В асинхронном программировании каждая следующая задача НЕ ждет окончания
 * выполнения предыдущей - можно делать операции одновременно. Это позволяет достичь Concurrency.
 *
 * Допустим надо написать два письма: пишем первое письмо, потом пишем второе письмо. Это Synchronous.
 * Допустим надо сделать бутерброд и постирать белье. Можно кинуть в стиралку вещи и не дожидаясь конца стирки начать
 * намазывать хлеб маслом. Это Asynchronous.
 *
 * Если использовать асинхронное программирование на компьютере с многоядерным процессором, то можно достичь параллельности
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class Ex10 {
    public static void main(String[] args) throws InterruptedException {
        /* пример синхронной работы: */
        System.out.println("privet");  // 1 действие
        for (int i = 0; i < 10; i++) { // 2 действие
            System.out.println(i);     // 2 действие
        }
        System.out.println("poka");    // 3 действие

        /* *************************************** */

        /* пример синхронной работы: */
        /* вывод последовательности потоков при каждом запуске будет разный - у них нет порядка выполнения */
        /* также такое поведение потоков называется недетерминированное */
        Thread thread1 = new Thread(new MyRunneble2());
        Ex8 thread2 = new Ex8();
        thread1.start(); //запускаем оба созданных потока, которые выводят числа от 1 до 10
        thread2.start(); //и перед этим пишут названия потока в котором они это сделали

        thread1.join(); // join означает что поток main будет ждать завершения потоков thread1 и thread2
        thread2.join(); //и только после этого продолжит свою работу. а в продолжении у нас записано - выводи "Финиш".
        System.out.println("Финиш"); // этот оутпут выведется первым, потому что метод main не усыпляли.
        // поэтому можно добавить join, чтобы поток main ждал завершение первых двух потоков
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyRunneble2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
