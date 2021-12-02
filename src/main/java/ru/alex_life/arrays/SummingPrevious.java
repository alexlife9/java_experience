package ru.alex_life.arrays;

import java.util.Arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.9. Суммирования предыдущих значений
 *
 * Даны целые числа n (> 2), a и b. Сформировать и вывести (без первых двух элементов) целочисленный массив размера n,
 * первый элемент которого равен a, второй равен b, а каждый последующий элемент равен сумме всех предыдущих.
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.12.2021
 */
public class SummingPrevious {
    public static int[] calculate(int a, int b, int n) {
        int[] rsl = new int[n];
        rsl[0] = a;
        rsl[1] = b;
        int x = a + b;
        for (int i = 2; i < n; i++) {
            rsl[i] = x;
            x *= 2;
            System.out.println(Arrays.toString(new int[]{rsl[i]}));
        }
        return rsl;
    }

    public static void main(String[] args) {
        calculate(1, 2, 5);
    }
}
