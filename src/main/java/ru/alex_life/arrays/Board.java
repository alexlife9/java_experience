package ru.alex_life.arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 0.9. Размер двумерного массива
 *
 * Двумерный массив - это массив одномерных массивов. Создается следующим образом:
 * new тип_переменной[количество_рядов][количество_элементов_в ряду]
 * Размер всего массива, как и в случае с одномерным массивом, определяется следующим образом:
 * имя_массива.length;
 * А что если надо узнать количество элементов в любом из интересующих нас ряду? Тогда надо обратиться
 * к этому ряду по индексу и вызвать у него поле length:
 * имя_массива[номер_ряда].length;
 *
 * В задании необходимо реализовать 2 метода - первый возвращает размер массива,
 * второй - количество элементов в ряду, номер которого мы передаем в метод.
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class Board {
    public static int getCountRow(int[][] array) {
        return array.length;
    }

    public static int getCountCellInRow(int[][] array, int row) {
        return array[row].length;
    }
}