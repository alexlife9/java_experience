package ru.alex_life.arrays;

/**
 * Видео-курс UDEMY Java для начинающих
 * 19. Цикл foreach
 *
 * С помощью цикла сложить все значения элементов массива
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.01.2022
 */
public class SumWithForeach {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 10}; //создаем массив
        int sum = 0; //изначально сумма равна 0
        for (int a : array) { //проходим форичем весь массив и
            sum += a; //прибавляем каждое значение элемента в sum
        }
        System.out.println(sum); //после завершение цикла, выводим получившееся значение sum
    }
}
