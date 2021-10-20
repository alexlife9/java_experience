package ru.alex_life.generics;

import java.util.Set;
import java.util.TreeSet;

/**
 * Упражнения
 *
 * В TreeSet добавили инт, лонг и дабл.
 * Какой размер получится у сета?
 *
 * Ответ: будет ClassCastException. Потому что TreeSet работает на основании компаратора, поэтому у одного объекта
 * вызывается compareTo и передается в сравнение другой объект - интежер сразу сравнивается с лонгом.
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class DemoOutputNumber {
    public static void main(String[] args) {
        Set<Number> set = new TreeSet<>();
        set.add(1);
        set.add(2L);
        set.add(3.5);
        System.out.println(set.size());
    }
}
