package ru.alex_life.arrays;

/**
 * Видео-курс UDEMY Java для начинающих
 * 19. Цикл foreach
 *
 * С помощью foreach:
 * 1. невозможно изменить значения элементов масиива примитивных типов данных
 * 2. возможно изменить значения объектов массива ссылочного типа данных, но ЗАМЕНИТЬ элемент невозможно
 * 3. невозможно проводить динамическую инициализацию массива
 * 4. невозможно в одном цикле одновременно работать более чем с одним массивом
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.01.2022
 */
public class NoChangeValueElemWithForeach {
    public static void main(String[] args) {
        int[] array = {2, 6, 7, 0, 10};
        for (int i = 0; i < array.length; i++) {
            array[i] = 4; //меняем все значения элементов на 4, при проходе через каждый индекс
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        // при этом форич так не сработает! Внимание! Потому что тут значения самих элементов при проходе не меняются
        int[] array2 = {2, 6, 7, 0, 10};
        for (int i : array2) {
            i = 4; //пытаемся поменять все значения элементов на 4 (но мы проходим не через индекс, а через переменную)
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }

    }
}
