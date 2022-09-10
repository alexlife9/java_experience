package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Варианты создания потоков
 *
 * Еще один пример запуска потоков
 * В данном примере три потока работают параллельно
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.09.2022
 */
public class Ex4 {
    public static void main(String[] args) { //запуск потока main
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("privet");
            }
        }).start(); //запуск созданного потока

        new Thread(() -> System.out.println("PRIVET")).start(); //запуск еще одного потока с помощью лямбды
    }
}
