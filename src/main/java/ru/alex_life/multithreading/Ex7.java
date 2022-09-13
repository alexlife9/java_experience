package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Методы Sleep и Join
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class Ex7 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000); //1000 миллисекунд = 1 секунда
        }
        System.out.println("поехали!");
    }
}
