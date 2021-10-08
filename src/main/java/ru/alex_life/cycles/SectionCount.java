package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.2. Найти количество отрезков, используя цикл
 *
 * Даны два целых положительных числа length, section. length это расстояние.
 * Нужно не используя операцию деления найти сколько раз отрезок длиной section помещает в length.
 * Нужно использовать цикл while.
 * Например,
 * Для length = 2, section = 1 => 2
 * Для length = 3, section = 2 => 1
 *
 * @author Alex_life
 * @version 1.0
 * @since 08.10.2021
 */
public class SectionCount {
    public static int count(int length, int section) {
        int x = 0;
        while (section <= length) {
           length -= section;
           x++;
        }
        return x;
    }
}
