package ru.alex_life.comparation;

import java.util.Comparator;

/**
 * Видео-курс Черный пояс.
 * 2.2. Интерфейс Comparator
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2021
 */
public class NameComparator implements Comparator<EmployeeWithComparator> {
    //вместо о1 и о2 можно писать любые удобные названия переменной
    //compareTo - в данном случае можно использовать только для сравнения String
    @Override
    public int compare(EmployeeWithComparator o1, EmployeeWithComparator o2) {
        return o1.name.compareTo(o2.name);
    }
}
