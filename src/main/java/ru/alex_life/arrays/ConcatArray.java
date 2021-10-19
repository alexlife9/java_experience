package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.4. Размер массива
 *
 * Даны 2 массива чисел. Необходимо определить общий размер массива при их объединении.
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class ConcatArray {
    public static int combineSize(int[] a, int[] b) {
        return a.length + b.length;
    }
}
