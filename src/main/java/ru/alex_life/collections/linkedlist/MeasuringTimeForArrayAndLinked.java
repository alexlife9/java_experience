package ru.alex_life.collections.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Измерение скорости добавления, считывания элементов в ArrayList и LinkedList
 * До 100.000 элементов разницы практически нет в скорости добавления в начало или в конец списка
 * Чем больше элементов, тем нагляднее видно что у ArrayList выше скорость добавления в КОНЕЦ списка, а также скорость считывания
 * При этом у LinkedList выше скорость добавления в НАЧАЛО и СЕРЕДИНУ списков.
 * ArrayList тратит много времени на копирование, а LinkedList — на создание обёрток и соединение ссылок.
 * Если заранее указать в конструкторе кол-во элементов, то без лишнего копирования и переносов разница в скорости
 * становится существенной — список заполняется на 20-80% быстрее!
 *
 * Также у LinkedList быстрее происходит УДАЛЕНИЕ элементов, особенно из НАЧАЛА и СЕРЕДИНЫ списка
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.04.2022
 */
public class MeasuringTimeForArrayAndLinked {
    public static void main(String[] args) {
        List<Integer> linkedlist = new LinkedList<>();
        List<Integer> arraylist = new ArrayList<>();

        //1. измеряем скорость добавления в конец листа
        measuringTimeAdd(linkedlist);
        measuringTimeAdd(arraylist); //!наглядно видно что добавление в Конец в 2 раза быстрее в Аррае

        //2. измеряем скорость считывания уже добавленных элементов
        measuringTimeGet(linkedlist);
        measuringTimeGet(arraylist); //!наглядно видно что в Аррее считывание быстрее в тысячу раз

        //3. измеряем скорость добавления в начало листа
        measuringTimeFirstAdd(linkedlist); //!наглядно видно что в Ликед добавление в Начало быстрее в несколько раз
        measuringTimeFirstAdd(arraylist);

        //4. измеряем скорость добавления в середину листа
        measuringTimeMiddleAdd(linkedlist); //!наглядно видно что в Линкед добавление в СЕРЕДИНУ быстрее в 10 раз
        measuringTimeMiddleAdd(arraylist);

        //измеряем скорость удаления элемента из середины листа
        measuringTimeMiddleRemove(linkedlist); //!наглядно видно что в Линкед УДАЛЕНИЕ из СЕРЕДИНы гораздо быстрее
        measuringTimeMiddleRemove(arraylist);
    }

    public static void measuringTimeAdd(List<Integer> timeAdd) { //добавление элементов в конец списка
        long start = System.currentTimeMillis(); //задаем старт измерения времени
        for (int i = 0; i < 500_000; i++) { //создаем элементы
            timeAdd.add(i); //добавляем каждый следующий созданный элемент в КОНЕЦ Листа
        }                   // [] -> [0] -> [0][1] -> [0][1][2] и тд
        long end = System.currentTimeMillis(); //задаем конец измерения времени

        System.out.println(end - start); //выводим время между окончанием создания списка и началом
    }

    public static void measuringTimeGet(List<Integer> timeGet) { //1. измеряем скорость пересчета элементов
        for (int i = 0; i < 50_000; i++) { //создаем элементы
            timeGet.add(i); //добавляем их в Лист
        }
        long start = System.currentTimeMillis(); //задаем старт измерения
        for (int i = 0; i < 50_000; i++) {
            timeGet.get(i); //теперь между измерениями считаем эти добавленные элементы
        }
        long end = System.currentTimeMillis(); //задаем конец измерения

        System.out.println(end - start);
    }

    public static void measuringTimeFirstAdd(List<Integer> timeFAdd) { //добавление элементов в начало списка
        long start = System.currentTimeMillis(); //задаем старт измерения времени
        for (int i = 0; i < 500_000; i++) { //создаем элементы
            timeFAdd.add(i); //добавляем каждый следующий созданный элемент в НАЧАЛО Листа
        }                   // [] -> [0] -> [1][0] -> [2][1][0] и тд
        long end = System.currentTimeMillis(); //задаем конец измерения времени

        System.out.println(end - start); //выводим время между окончанием создания списка и началом
    }

    public static void measuringTimeMiddleAdd(List<Integer> timeMAdd) { //добавление элементов в середину списка
        for (int i = 0; i < 10_000; i++) { //создаем элементы
            timeMAdd.add(i);                //добавляем их в лист
        }
        long start = System.currentTimeMillis(); //задаем старт измерения времени
        for (int i = 0; i < 10_000; i++) {      //добавляем с середину списка ОДИН элемент
            timeMAdd.add(5_000, 1);
        }
        long end = System.currentTimeMillis(); //задаем конец измерения времени
        System.out.println(end - start); //выводим время между окончанием создания списка и началом
    }

    public static void measuringTimeMiddleRemove(List<Integer> timeRAdd) { //удаление элементов из середины списка
        for (int i = 0; i < 10_000; i++) { //создаем элементы
            timeRAdd.add(i);                //добавляем их в лист
        }
        long start = System.currentTimeMillis(); //задаем старт измерения времени
        for (int i = 0; i < 10_000; i++) {
            timeRAdd.remove(5_000); //удаляем из середины списка ОДИН элемент
        }
        long end = System.currentTimeMillis(); //задаем конец измерения времени
        System.out.println(end - start); //выводим время между окончанием создания списка и началом
    }

}
