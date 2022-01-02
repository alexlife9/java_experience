package ru.alex_life.arrays;

/**
 * Видео-курс UDEMY Java для начинающих
 * 18. Понятие «массив». Задание
 *
 * Создать и продемонстрировать метод сортировки элементов одномерного массива по возрастанию
 *
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.12.2021
 */
public class SortedUp {
    public static int[] sortirovka(int[] array) { //передаем в параметр метода одномерный массив
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            if (i != index) {
                a = array[i];
                array[i] = min;
                array[index] = a;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {8, 0, 5, -3, 7, 2, 1, 6};
        sortirovka(array);
        for (int z : array) {
            System.out.println(z);
        }
    }
}
