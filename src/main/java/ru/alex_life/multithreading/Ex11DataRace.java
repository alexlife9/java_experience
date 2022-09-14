package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Data Race
 *
 * Data Race - это "гонка данных". Разные потомки с разной скоростью выполняют свою работу стремясь ее завершить.
 * Data Race - это проблема которая может возникнуть когда два и более потоков обращаются к одной и той же переменной
 * и как минимум 1 поток изменяет эту переменную.
 *
 * Чтобы избежать этой проблемы - в методе объявляется ключевое слово synchronized.
 * Это блокирует метод только для работы с одним потоком.
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 */
public class Ex11DataRace {
    volatile static int counter = 0;
    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
        /* вывод в консоль числа отличного от ожидаемых 2000 - наглядно демонстрирует гонку данных,
        потому что работа потоков не синхронизирована. Потоки работают параллельно независимо друг от друга,
        не обращая внимание на то что они могут мешать друг другу */
    }
}

class R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Ex11DataRace.increment();
        }
    }
}
