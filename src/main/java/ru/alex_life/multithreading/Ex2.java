package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Варианты создания потоков:
 * 1. extends Thread
 * 2. implements Runnable
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.09.2022
 */
public class Ex2 {
    public static void main(String[] args) {   //первый поток main
        MyTHread1 myTHread1 = new MyTHread1(); //второй поток создали
        MyTHread2 myTHread2 = new MyTHread2(); //третий поток создали
        myTHread1.start();
        myTHread2.start();
        //в консоли видим что потоки не синхронизированы, более того - вывод всегда разный при запуске
    }
}

class MyTHread1 extends Thread {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyTHread2 extends Thread {
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
