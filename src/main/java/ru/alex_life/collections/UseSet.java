package ru.alex_life.collections;

import java.util.*;

/**
 * Наглядная демонстрация добавления и вывода элементов в различных реализациях Set
 * !Удаляются дубликаты!
 *
 * @author Alex_life
 * @version 1.0
 * @since 29.09.2021
 */
public class UseSet {
    public static void main(String[] args) {
        System.out.println("HashSet: хаотичный порядок элементов");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("яблоко");
        hashSet.add("ананас");
        hashSet.add("банан");
        hashSet.add("яблоко");
        System.out.println(hashSet);
        System.out.println();

        System.out.println("LinkedHashSet: в порядке добавления");
        Set<String>  linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("яблоко");
        linkedHashSet.add("яблоко");
        linkedHashSet.add("ананас");
        linkedHashSet.add("банан");
        System.out.println(linkedHashSet);
        System.out.println();

        System.out.println("TreeSet: красно-черное дереве, сортировка по алфавиту");
        Set<String>  treeSet = new TreeSet<>();
        treeSet.add("яблоко");
        treeSet.add("яблоко");
        treeSet.add("ананас");
        treeSet.add("банан");
        System.out.println(treeSet);
        System.out.println();

    }
}
