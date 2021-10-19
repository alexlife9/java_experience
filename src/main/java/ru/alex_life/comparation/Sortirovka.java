package ru.alex_life.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 2.1. Интерфейс Comparable
 *
 * Наглядная демонстарция как проходит сортировка String с помощью Collections.sort
 *
 * @author Alex_life
 * @version 1.0
 * @since 01.10.2021
 */
public class Sortirovka {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Maria");
        list.add("Alex");
        list.add("Petr");
        System.out.println("Вывод до сортировки: " + list);
        Collections.sort(list);
        System.out.println("Вывод после сортировки: " + list); //Natural order - по алфавиту
                                                               // либо Integer от наименьшего к наибольшему
    }
}
