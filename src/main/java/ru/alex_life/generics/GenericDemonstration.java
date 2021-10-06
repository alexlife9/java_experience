package ru.alex_life.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.1. Введение в generics
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2021
 */
public class GenericDemonstration {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //Если после List не использовать дженерик (будет сырой тип) и написать List list,
        // то в него можно добавить всё что угодно:
//        list.add(555);
//        list.add("привет");
//        list.add(new StringBuilder("Изменяемая строка"));
//        list.add(new Car());
        //так можно делать потому что в основе ArrayList лежит класс Object

        list.add("привет");
        list.add("пока");
        list.add("длинная хрень на 45 символов включая проблелы");
        for (String o : list) { //без дженерика тут будет Object o : list
            System.out.println(o + " - ДЛИНА ЭТОЙ СТРОКИ: " + o.length()); //без дженерика надо писать
                                                    // ((String)o).length() чтобы компилятор понимал что от него хотят
                                                    //запись ((String)o) это down casting
        }
        //в таком виде всё будет работать, но не всегда мы видим источник того что к нам приходит,
        //на вход легко может быть подано всё что угодно и при выводе в консоль - будет ClassCastException!
        //Именно поэтому нужны дженерики, которые сразу указывают компилятору что именно можно подавать на вход.
        //Ошибки на уровне компиляции гораздо лучше видеть чем во время исполнения программы.
        //
        //Это важнейшая особенность дженериков - Type Save - безопасность типов
        //И вторая важная вещь - reUsable Code - можно не создавать дублирующий код, а использовать дженерики
        //запись будет например List<String>
    }
}
