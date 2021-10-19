package ru.alex_life.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.7. Wildcards
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class DemoWildCard {
    public static void main(String[] args) {
        //List<Number> list = new ArrayList<Integer>(); //вот так писать нельзя, потому что аррэйлист интежеров не является подтипом намберов
        //List<Object> list2 = new ArrayList<Integer>(); //и вот так писать нельзя
        List<?> list3 = new ArrayList<Integer>(); //а вот так можно! <?> означает - любой класс
        // List<?> в данном случае является супертипом любого аррэйлиста, можно написать вот так -
        List<?> list4 = new ArrayList<String>(); //вместо вопроса в дженерик может быть подставлен абсолютно любой класс
        //list4.add("так добавить не получится"); //нельзя добавить элемент типа Стринг в Лист, тип которого неизвестен

        List<Double> list5 = new ArrayList<>();
        list5.add(3.14);
        list5.add(3.15);
        list5.add(3.16);
        showInfoList(list5);

        List<String> list6 = new ArrayList<>();
        list6.add("Привет");
        list6.add("Пока");
        list6.add("Да");
        showInfoList(list6);
    }

    static void showInfoList(List<?> info) { //вызываем этот метод на листах Дабл и Стринг и всё ОК.
        System.out.println("мой лист содержит следующие элементы: " + info);
    }
}
