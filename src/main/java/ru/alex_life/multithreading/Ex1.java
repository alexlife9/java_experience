package ru.alex_life.multithreading;

/**
 * Видео-курс Черный пояс
 * Введение в многопоточность
 *
 * У многопоточности две цели:
 * 1. Производительность
 * 2. Одновременное выполнение сразу нескольких задач - Concurrency (параллелизм)
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.09.2022
 */
public class Ex1 {
    /* в данном примере все выполняется последовательно - однопоточно.
    Тут работает один поток - main. И данный поток создается автоматически */
    public static void main(String[] args) {
        System.out.println("privet");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("poka");
    }
}
