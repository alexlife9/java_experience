package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.3. Проверить является ли двумерный массив квадратным
 *
 * имя_массива.length - размер массива;
 * имя_массива[номер_ряда].length - количество элементов в его ряду.
 * Необходимо проверить является ли входящий двумерный массив квадратным (т.е. количество элементов в каждом ряду,
 * должно совпадать с количеством рядов).
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class CheckSquareArray {
    public static boolean checkArray(int[][] array) {
        for (int[] i : array) {
            if (i.length != array.length) {
                return false;
            }
        }
        return true;
    }
}
