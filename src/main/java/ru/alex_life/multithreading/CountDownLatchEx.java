package ru.alex_life.multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Синхронизатор CountDownLatch
 * Это синхронизатор, позволяющий любому кол-ву потоков ждать пока не завершится определенное кол-во операций.
 * В конструктор CountDownLatch нужно передавать кол-во операций, которые должны завершиться, чтобы потоки
 * продолжили свою работу
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3); //задаем кол-во операций

    private static void marketStaffOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("первая операция: персонал маркета пришел на работу");
        countDownLatch.countDown(); //уменьшаем счетчик кол-ва операций
        System.out.println("счетчик операций сейчас: " + countDownLatch.getCount());
    }

    private static void everyReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("вторая операция: всё готово к открытию маркета");
        countDownLatch.countDown(); //уменьшаем счетчик кол-ва операций
        System.out.println("счетчик операций сейчас: " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("третья операция: открываем маркет");
        countDownLatch.countDown(); //уменьшаем счетчик кол-ва операций
        System.out.println("счетчик операций сейчас: " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {

        //добавили 5 потоков
        new Friend("name1", countDownLatch);
        new Friend("name2", countDownLatch);
        new Friend("name3", countDownLatch);
        new Friend("name4", countDownLatch);
        new Friend("name5", countDownLatch);

        //вызвали три метода
        marketStaffOnPlace();
        everyReady();
        openMarket();

        //после того как эти 3 операции будут завершены - одновременно запускаются и начинают выполняться 5 потоков
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await(); //если счетчик не равен 0, то поток будет заблокирован до тех пор пока не станет 0
            System.out.println(name + " этот человек приступил к покупкам");
            //если счетчик 0, то поток начнет выполнять свою работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
