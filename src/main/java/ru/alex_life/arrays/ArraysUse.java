package ru.alex_life.arrays;

import java.util.Arrays;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 18. Понятие «массив». Базовые методы
 *
 * @author Alex_life
 * @version 1.0
 * @since 28.11.2021
 */
public class ArraysUse {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 8, 5, -7};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        Arrays.sort(array); // метод сортирует массив во возрастанию
        for (int j : array) {
            System.out.print(j + " ");
        }

        System.out.println();
        int i = Arrays.binarySearch(array, 6); //поиск значения по массиву. возвращает индекс найденного элемента
        System.out.println(i); //корректно работает ТОЛЬКО на отсортированном массиве
                               //если указать несуществующее значение, то будет выдаваться вычисляемый отрицательный индекс

        System.out.println();
        int[] array1 = new int[]{1, 5, 8, 5, -7};
        int[] array2 = new int[]{1, 5, 8, 5, -7};
        System.out.println(array1 == array2); //будет фолс, потому что массивы ссылаются на разные объекты, даже несмотря на то,
                                              //что содержимое массивов одинаковое
        int[] array3 = array2;
        System.out.println(array3 == array2); //будет тру, потому что теперь аррэй4 ссылается на тот же объект что и аррэй2
        System.out.println(array3.equals(array2)); //, будет тру, потому что иквелс для массивов работает так же как ==
    }

}
