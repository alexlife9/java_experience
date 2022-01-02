package ru.alex_life.arrays;

/**
 * Видео-курс UDEMY Java для начинающих
 * 19. Цикл foreach
 *
 * Вывести все элементы двумерного неравномерного массива
 * Элементами двумерного массива являются элементы обычного массива
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.01.2022
 */
public class AllElemBiArray {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 5}, {60, 80}, {120, 254, 584, 947, 475}}; //создаем двумерный массив
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }

        System.out.println(); //тоже самое с помощью форича
        for (int[] i : array) { //проходим по внешнему массиву
            for (int j : i) { //проходим по значениям вложенных масивов
                System.out.print(j + " ");
            }
        }
    }
}

