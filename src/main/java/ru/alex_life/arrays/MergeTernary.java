package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.3. Объединить два отсортированных массива
 *
 * Даны два отсортированных по возрастанию массива. Как без сортировки их объединить в третий массив?
 *
 * @author Alex_life
 * @version 3.0 - с помощью тернарника
 * @since 19.10.2021
 */
public class MergeTernary {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0; //создаем начальные индексы двух начальных массивов
        for (int i = 0; i < rsl.length; i++) {
            if (leftIndex < left.length && (rightIndex >= right.length || left[leftIndex] < right[rightIndex])) {
                rsl[i] = left[leftIndex];
                leftIndex++;
            } else {
                rsl[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return rsl;
    }
}
