package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.5. Вывести стоимость конфет за килограмм
 *
 * Дано целое число price — цена 1 кг конфет. Вывести стоимость 1, 2, . . . , 5 кг конфет.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class SweetPrice {
    public static void out(int price) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(price * i);
        }
    }
}
