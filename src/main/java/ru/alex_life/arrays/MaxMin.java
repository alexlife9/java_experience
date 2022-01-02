package ru.alex_life.arrays;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * Задание. Найти минмиальное и максимальное значение элемента массива
 *
 * @author Alex_life
 * @version 1.0
 * @since 29.11.2021
 */
public class MaxMin {
    public static void maxMin(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.println("минимальное: " + min);
        System.out.println("максимальное: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, -5, 7, 10, -2};
        maxMin(arr);                       //передаем в параметры метода созданный выше массив
        maxMin(new int[]{5, 9, 8, 4, -7}); //либо сразу в параметре создаем новый объект
    }
}
