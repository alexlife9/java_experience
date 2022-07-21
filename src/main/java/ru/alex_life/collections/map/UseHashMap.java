package ru.alex_life.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Видеокурс Продвинутая Java
 * 006 HashMap - Введение
 *
 * Смысловой перевод Map - "карта", "отображение", "словарь"
 * HashMap не гарантирует порядка вывода
 *
 * @author Alex_life
 * @version 1.0
 * @since 12.07.2022
 */
public class UseHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); //в качестве ключа будем использовать Integer, в качестве значения - String
        map.put(1, "Один"); //добавляем элементы в нашу карту
        map.put(2, "Два"); //(2, "Два") - это объект класса Entry - пара "ключ,значение"
        map.put(3, "Три");
        System.out.println(map);

        System.out.println();
        map.put(3, "Перезатерли значение ключ-пара 'Три'"); //если вставить новую пару, у которой будет совпадать ключ с тем что уже имеется
        System.out.println(map); //в Map невозможно существование двух одинаковых ключей, допускаются только уникальные ключи

        System.out.println();
        System.out.println(map.get(1)); //с помощью метода get получаем по ключу значение пары
        System.out.println(map.get(10)); //если запросить значение несуществующего ключа, то вернется null

        System.out.println();
        for (Map.Entry<Integer, String> entry : map.entrySet()) { //каждая пара "ключ-значение" - Entry
                                                   //метод entrySet возвращает набор всех пар в нашей Мапе
            System.out.println(entry.getKey() + ":" + entry.getValue()); //getKey получает ключ пары, getValue получает значение пары
        }
    }
}
