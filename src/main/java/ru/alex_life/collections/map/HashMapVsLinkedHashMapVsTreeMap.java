package ru.alex_life.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Видеокурс Продвинутая Java
 * 007 LinkedHashMap и TreeMap
 *
 * @author Alex_life
 * @version 1.0
 * @since 12.07.2022
 */
public class HashMapVsLinkedHashMapVsTreeMap {
    public static void main(String[] args) {


        Map<Integer, String> hashmap = new HashMap<>(); //внутри не гарантируется никакого порядка
        Map<Integer, String> linkedhashmap = new LinkedHashMap<>(); //возвращается тот порядок в котором были добавлены пары
        Map<Integer, String> treemap = new TreeMap<>(); //пары (ключ, значение) сортируются по ключу

        testMap(hashmap);
        testMap(linkedhashmap);
        testMap(treemap);
    }

    public static void testMap(Map<Integer, String> map) { //создадим метод в параметры которого передадим объекты с реализацией интерфейса Map
        map.put(99, "Алексей"); //добавим значения
        map.put(15, "Дима");
        map.put(27, "Олеся");
        map.put(84, "Олег");
        map.put(62, "Дима");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
