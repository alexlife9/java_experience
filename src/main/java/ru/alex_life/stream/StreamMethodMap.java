package ru.alex_life.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Видео-курс Черный пояс
 * Streams
 * Метод map
 *
 * @author Alex_life
 * @version 1.0
 * @since 18.11.2022
 */
public class StreamMethodMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela");
        list.add("ok");
        list.add("poka");

        //выведем длину слов
        for (int i = 0; i < list.size(); i++) {
            list.set(i, String.valueOf(list.get(i).length()));
        }
        System.out.println(list);

        //сделаем тоже самое но с помощью потока для коллекции
        List<String> list2 = new ArrayList<>();
        list2.add("privet");
        list2.add("kak dela");
        list2.add("ok");
        list2.add("poka");
        List<Integer> list3 = list2.stream()
                .map(element -> element.length())
                .collect(Collectors.toList()); //преобразовываем поток в коллекцию
        System.out.println(list2); //выводим начальные значения стрингов
        System.out.println(list3); //выводим длины добавленных стрингов

        //для массива
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array)
                .map(element -> { //в параметре метода map в скобках задаем преобразование массива
                    if (element % 3 == 0) { //задаем условие преобразования
                        element = element / 3; //должно получится 5,3,1,8,1
                    }
                    return element;
                })
                .toArray(); //преобразовываем поток в массив
        System.out.println(Arrays.toString(array)); //выводим изменившийся массив чисел
    }
}
