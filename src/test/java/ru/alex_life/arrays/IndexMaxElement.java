package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.8. Индекс максимального значения элемента массива
 *
 * Метод должен вернуть ИНДЕКС элемента, который является максимальным из двух: первый элемент или последний элемент.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class IndexMaxElement {
    public static int getIndexMax(int[] array) {
        return array[0] > array.length - 1 ? 0 : array.length - 1;
    }
}
