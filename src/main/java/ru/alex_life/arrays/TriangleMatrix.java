package ru.alex_life.arrays;

import java.util.Arrays;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.7. Заполнить треугольную матрицу
 *
 * Треугольная матрица, это матрица вида:
 * 1
 * 2 3
 * 4 5 6
 *
 * Дано количество строк в результирующей матрице. Нужно заполнить ее.
 * Например, для 1 строки:
 * {{1}}
 *
 * Для 2 строк:
 * {1}
 * {2, 3}
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class TriangleMatrix {
    public static int[][] rows(int count) {
        int[][] triangle = new int[count][];
        int element = 1; //переменная-счетчик значений элементов для заполнения матрицы
        for (int i = 0; i < triangle.length; i++) { //идем по всей длине всего массива
            triangle[i] = new int[i + 1]; //создаем вложенный массив
            for (int j = 0; j < triangle[i].length; j++) { //
                triangle[i][j] = element; //во внутреннем цикле заполняем массив элементами
                element++; //увеличиваем счетчик на один элемент

            }
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rows(4)));
    }
}
