package ru.alex_life.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Демонстрация добавления и вывода элементов в различных реализациях Map
 * Дубликаты ключей (String) удаляются при выводе
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class UseMap {
    public static void main(String[] args) {
        System.out.println("HashMap: произвольный порядок");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("яблоко", 1);
        hashMap.put("яблоко", 2);
        hashMap.put("ананас", 3);
        hashMap.put("банан", 4);
        System.out.println(hashMap);
        System.out.println();

        System.out.println("LinkedHashMap: в порядке добавления");
        Map<String, Integer> linkedHashMap  = new LinkedHashMap<>();
        linkedHashMap.put("яблоко", 1);
        linkedHashMap.put("яблоко", 2);
        linkedHashMap.put("ананас", 3);
        linkedHashMap.put("банан", 4);
        System.out.println(linkedHashMap);
        System.out.println();

        System.out.println("TreeMap: красно-черное дерево, сортировка по алфавиту ключей");
        Map<String, Integer> treeMap  = new TreeMap<>();
        treeMap.put("яблоко", 1);
        treeMap.put("яблоко", 2);
        treeMap.put("ананас", 3);
        treeMap.put("банан", 4);
        System.out.println(treeMap);
        System.out.println();
    }
}
