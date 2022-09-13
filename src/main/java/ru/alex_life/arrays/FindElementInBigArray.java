package ru.alex_life.arrays;

/**
 * Найти элемент в огромном одномерном массиве
 *
 * Задача:
 * Дан отсортированный массив. Необходимо написать метод, который проверяет, есть ли указанный элемент в массиве.
 * Массив может быть очень большим. Тип данных – int. Массив одномерный.
 *
 * @author Alex_life
 * @version 1.0
 * @since 13.09.2022
 */
public class FindElementInBigArray {
    /**
     * Самое простое решение, это конечно же линейный перебор с помощью простого цикла
     * Но данный метод очень плохо работает с большими массивами,
     * так как в наихудшем случае (отсутствия элемента) придется перебрать все элементы массива.
     * Сложность такого алгоритма составляет O(n) - т.е. для массива с 1_000_000 элементов потребуется 1_000_000 шагов.
     */
    public static int lineSearch(int[] array, int number) {
        int rsl = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                rsl = number;
                break;
            }
        }
        return rsl;
    }

    /**
     * Правильным подходом в этом случае является бинарный поиск,
     * который как раз предназначен для отсортированных массивов.
     * На каждой итерации происходит разделение массива на 2,
     * вследствие чего ненужная половина (старшая или младшая) просто отбрасывается,
     * что позволяет нам оптимизировать алгоритм до сложности O(log(n)) - т.е. для массива
     * с 1_000_000 элементов - в наихудшем случае потребуется 20 шагов!
     *
     */
    public static int binarySearch(int[] array, int number) {
        int rsl = -1;
        int start = 0;
        int finish = array.length - 1;
        while (start <= finish) {
            int midle = (start + finish) / 2;
            if (array[midle] == number) {
                rsl = number;
                break;
            }
            if (array[midle] > number) {
                finish = midle - 1;
            }
            if (array[midle] < number) {
                start = midle + 1;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        int[] arrays = new int[1_000_000]; /* создали массив на миллион ячеек */
        for (int i = 0; i < arrays.length; i++) { /* заполняем массив */
            arrays[i] = i;
        }
        int num = 500_000; /* элемент который надо найти */

        System.out.println(lineSearch(arrays, num));

        System.out.println(binarySearch(arrays, num));
    }
}
