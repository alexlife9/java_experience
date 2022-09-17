package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Методы wait и notify
 *
 * Если оба потока в ожидании, то любой поток может захватить монитор. Даже тот поток который только что освободил его.
 * Методы wait и notify вызываются только из синхронизированного блока
 * wait - освобождает монитор
 * notify - захватывает монитор
 *
 * @author Alex_life
 * @version 1.0
 * @since 17.09.2022
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        //потоки будут синхронизированы по одному объекту - по market, поэтому одновременно они не могут работать.
        //точнее одновременно не могут работать методы getBread и putBread
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }
}

class Market {
    private int breadCount = 0; //кол-во хлеба в магазине

    private int count = 0; //счетчик захвата монитора
    /**
     * метод покупки хлеба
     */
    public synchronized void getBread() {
        while (breadCount < 1) {
            try {
                wait(); //если на витрине нет хлеба, поток должен ждать. Пока ждем - освобождаем монитор
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        breadCount--; //уменьшаем кол-во хлеба на 1.
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Кол-во хлеба в магазине = " + breadCount);
        System.out.println("Монитор захватили: " + count + " раз");
        System.out.println();
        notify(); //сообщаем потоку производителя о том что можно добавлять хлеб в маркет
    }

    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait(); //на витрине не может быть больше 5, поэтому будем ждать пока хлеб купят
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        breadCount++; //добавляем 1 хлеб
        System.out.println("Производитель добавил в магазин 1 хлеб");
        System.out.println("Кол-во хлеба в магазине = " + breadCount);
        System.out.println("Монитор захватили: " + count + " раз");
        System.out.println();
        notify(); //сообщаем потоку потребителя о том что появился новый хлеб
    }
}

/**
 * класс производителя хлеба. он может добавлять не более 10 хлеба
 */
class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            market.putBread();
        }
    }
}

/**
 * класс потребителя
 */
class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            market.getBread();
        }
    }
}