package ru.alex_life.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Видео-курс Черный пояс
 * Predicate
 *
 * @author Alex_life
 * @version 1.0
 * @since 28.10.2022
 */
public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("privet");
        al.add("poka");
        al.add("ok");
        al.add("nope");

        //передаем в предикат условие. метод проверяет каждый элемент
        al.removeIf(elem -> elem.length() == 2);

        //можно вот так записать
        Predicate<String> p = elem -> elem.length() == 4;
        al.removeIf(p);
        System.out.println(al);
    }
}
