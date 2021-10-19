package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.1. Проверить сортировку массива
 *
 * Задан числовой массив. Необходимо написать программу, которая проверит, что массив отсортирован по возрастанию.
 * Сортировать массив не нужно!
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class Sorted {
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
