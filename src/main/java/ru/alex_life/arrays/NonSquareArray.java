package ru.alex_life.arrays;

import java.util.Arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.2. Создание неоднородного двумерного массива
 *
 * Массив в котором количество элементов в каждом ряду отличается от общего количества рядов в массиве
 * называется неоднородным и создается следующим образом (например заполним массив целочисленными значениями):
 * int[][] array = new int[][]{{0, 1}, {10, 20, 30}, {5}, {1, 2, 3, 4, 5}};
 * Для определения количества элементов в ряду, необходимо указать индекс ряда и вызвать поле length.
 *
 * Задача зполнить массив значениями от 1 до 6, при этом:
 * 1. Разбить значения на 3 массива.
 * 2. В первом должен быть 1 элемент, втором - 2 элемента, третьем - 3 элемента.
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class NonSquareArray {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1}, {2, 3}, {4, 5, 6}};
        System.out.println("значения второго вложенного массива: " + Arrays.toString(array[1]));
        System.out.println("длина второго вложенного массива: " + array[1].length);
        System.out.println("все элементы двухмерного массива: ");
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j);
            }
        }
    }
}
