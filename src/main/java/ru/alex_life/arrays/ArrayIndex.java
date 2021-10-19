package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.5. Индексы в массивах
 *
 * Доступ к элементам в массивах осуществляется при помощи индексов, которые являются целочисленными значениями.
 * При этом индексация начинается с 0 и заканчивается значением имя_массива.length - 1.
 * В задании необходимо расставить значения индексов так, чтобы первый метод возвращал первый элемент массива,
 * а второй метод - последний элемент массива.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class ArrayIndex {

    public static int getFirstElement(int[] array) {
        return array[0];
    }

    public static int getLastElement(int[] array) {
        return array.length;
    }
}
