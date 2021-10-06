package ru.alex_life.generics;

import java.util.ArrayList;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.3. Parameterized method
 *
 * Параметрезированные методы нужны для написания и использования методов с очень широким выбором типов данных
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class ParametriziredMetod {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(10);
        arrayList1.add(20);
        arrayList1.add(5);
        int a = GeniricMetod.getSecondElement(arrayList1); //метод возвращает второй элемент
        System.out.println(a);

        //примЕним этот же метод для листа Стрингов
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("привет");
        arrayList2.add("пока");
        arrayList2.add("да");
        String b = GeniricMetod.getSecondElement(arrayList2); //метод возвращает второй элемент
        System.out.println(b);
    }
}
