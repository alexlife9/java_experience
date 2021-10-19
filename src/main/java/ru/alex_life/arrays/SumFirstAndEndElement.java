package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.6. Сумма элементов массива
 *
 * Доступ к элементам массива осуществляется по индексам.
 * Первый элемент имеет индекс 0, последний - имя_массива.length - 1.
 * Необходимо реализовать метод, который принимает массив целочисленных значений
 * и возвращает сумму первого и последнего элемента в этом массиве.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class SumFirstAndEndElement {
    public static int getSum(int[] array) {
        return array[0] + array.length;
    }
}
