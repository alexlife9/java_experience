package ru.alex_life.lambda;

import java.util.List;

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
        //метод forEach принимает Consumer, которому передаем условие ЧТО нужно сделать для каждого элемента, потому что
        // Consumer это потребитель - мы передаем элемент и указываем как его нужно употребить, как мы должны его использовать
        list.forEach(str -> System.out.println(str)); // эту запись можно укоротить с помощью оператора ::
        list.forEach(System.out::println);
    }
}
