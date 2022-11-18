package ru.alex_life.lambda;

import java.util.List;
import java.util.function.Function;

/**
 * Видео-курс Черный пояс
 * Consumer
 *
 * @author Alex_life
 * @version 1.0
 * @since 29.10.2022
 */
public class ForEach {
    public static void main(String[] args) {
        List<String> list = List.of("privet", "poka", "ok");
        for (String s : list) {
            System.out.println(s);
        }
        //метод forEach принимает Consumer, которому передаем условие ЧТО нужно сделать для каждого элемента,
        // потому что Consumer это потребитель - мы передаем элемент и указываем как его нужно употребить и
        // как мы должны его использовать.
        list.forEach(str -> System.out.println(str)); // эту запись можно укоротить с помощью оператора ::
        list.forEach(System.out::println);

        //еще один пример использования Ссылки на методы
        Function<String, Integer> converter1 = (fromThis) -> Integer.valueOf(fromThis);//это можно сократить:
        Function<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.apply("123");
        System.out.println(converted);
    }
}
