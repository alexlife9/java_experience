package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Ключевое слово volatile
 *
 * Ключ.слово volatile используется для пометки переменной, чтобы она хранилась только в основной памяти "main memory"
 * Без этого ключевого слова переменная будет храниться в кэше процессора.
 *
 * Для синхронизации значений переменной между потоками, ключ.слово volatile используется тогда, когда только один поток
 * может изменять значение этой переменной, а остальные потоки могут его только читать.
 *
 * @author Alex_life
 * @version 1.0
 * @since 14.09.2022
 */
public class VolatileEx extends Thread {

    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished. Counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx thread = new VolatileEx();
        thread.start(); //запускаем метод run
        Thread.sleep(3000); //Вызвали слип для потока main, чтобы цикл в методе run поработал 3 секунды.
        System.out.println("After 3 seconds is time to wake up");
        thread.b = false;
        thread.join();
        System.out.println("End of programm");

    }
}
