package ru.alex_life.comparation;

import java.util.Comparator;

/**
 * Видео-курс Черный пояс.
 * 2.2. Интерфейс Comparator
 *
 * Создаем класс "Сравнитель по Айди", который берет данные из нашегго класса <EmployeeWithComparator>
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2021
 */
public class IdComparator implements Comparator<EmployeeWithComparator> {

    //гененрируем compare и сравниваем двух работников
    @Override
    public int compare(EmployeeWithComparator eN1, EmployeeWithComparator eN2) {
        return eN1.id - eN2.id;
    }
}
