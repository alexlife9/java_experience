package ru.alex_life.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  Видео-курс UDEMY Java для начинающих
 *  20. Всё о классе ArrayList. Задание
 *
 *  Создание метода в котором в ArrayList будут выводиться неповторяющиеся элементы типа String, взятые из параметра метода
 *
 * @author Alex_life
 * @version 1.0
 * @since 18.04.2022
 */
public class NoDuplicateInArrayList {
    public ArrayList<String> abc(String...strings) { //создаем метод в параметры которого принимаем String
        ArrayList<String> arrayList = new ArrayList<>(); //создаем объект ArrayList с типом String
        for (String s : strings) {
            if (!arrayList.contains(s)) { //проверяем находятся ли уже в ArrayList дубликаты
                arrayList.add(s); //добавляем в ArrayList параметры (String...strings), но не все, а только не которых еще нет
            }
        }
        Collections.sort(arrayList); //сортируем
        System.out.println(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {
        NoDuplicateInArrayList exsam = new NoDuplicateInArrayList(); //создаем объект нашего класса
        exsam.abc("ras", "dva", "dva", "tri"); //и применяем к нему наш метод созданный выше
    }
}
