package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.3. Объединить два отсортированных массива
 *
 * Даны два отсортированных по возрастанию массива. Как без сортировки их объединить в третий массив?
 *
 * @author Alex_life
 * @version 2.0 - с помощью цикла While
 * @since 19.10.2021
 */
public class MergeWhile {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];

        int indexRsl = 0;   //индекс в массиве rsl
        int indexLeft = 0;  //индекс в массиве left
        int indexRight = 0; //индекс в массиве right

        //формирование основной части
        while (indexLeft < left.length && indexRight < right.length) {
            rsl[indexRsl++] = left[indexLeft] < right[indexRight] ? left[indexLeft++] : right[indexRight++];
        }

        //формирование остатка
        while (indexLeft < left.length) {
            rsl[indexRsl++] = left[indexLeft++];
        }

        while (indexRight < right.length) {
            rsl[indexRsl++] = right[indexRight++];
        }

        return rsl;
    }
}

