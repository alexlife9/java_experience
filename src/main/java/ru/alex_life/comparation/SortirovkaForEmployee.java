package ru.alex_life.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 2.1. Интерфейс Comparable
 * 2.2. Интерфейс Comparator
 *
 * Создаем работников и сравниваем их
 * Изначальная модель - EmployeeWithComparable
 *
 * @author Alex_life
 * @version 1.0
 * @since 01.10.2021
 */
public class SortirovkaForEmployee {
    public static void main(String[] args) {
        List<EmployeeWithComparable> list = new ArrayList<>();
        EmployeeWithComparable e1 = new EmployeeWithComparable(2, "Alex", "Mit", 3000);
        EmployeeWithComparable e2 = new EmployeeWithComparable(1, "Maria", "Oza", 1000);
        EmployeeWithComparable e3 = new EmployeeWithComparable(3, "Petr", "Kurs", 2000);
        EmployeeWithComparable e4 = new EmployeeWithComparable(4, "Oleg", "Anhel", 5000);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        System.out.println("Вывод до сортировки: " + list);
        Collections.sort(list); //мы не можем так написать, без метода compareTo,
        // потому что компилятор не знает КАК сортировать объекты,
        //у которых много значений, поэтому надо использовать интерфейс Comparable - способный быть сравнивым.
        //Поэтому в начале класса надо сделать наследование от этого интерфейса с обязательным указанием дженерика
        //У интерфейса Comparable есть только ОДИН метод compareTo
        System.out.println("Вывод после сортировки: " + list);

        //сравнение с помощью Компаратора
        List<EmployeeWithComparator> list2 = new ArrayList<>();
        EmployeeWithComparator e5 = new EmployeeWithComparator(2, "Alex", "Mit", 3000);
        EmployeeWithComparator e6 = new EmployeeWithComparator(1, "Maria", "Oza", 1000);
        EmployeeWithComparator e7 = new EmployeeWithComparator(3, "Petr", "Kurs", 2000);
        list2.add(e5);
        list2.add(e6);
        list2.add(e7);
        //чтобы отсортировать ЛИСТ2 - передаем вторым параметром в метод sort наш Сортирователь по айди,
        //который сравнивает двух работников методом compare в классе IdComparator
        Collections.sort(list2, new IdComparator());
        System.out.println("Сортировка по айди с помощью Comparatora: " + list2);
        Collections.sort(list2, new NameComparator());
        System.out.println("Сортировка по имени с помощью Comparatora: " + list2);
    }
}
