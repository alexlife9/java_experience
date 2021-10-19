package ru.alex_life.comparation;

/**
 * Видео-курс Черный пояс.
 * 2.2. Интерфейс Comparator
 *
 * Сортировка с помощью интерфейса Comparator
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.10.2021
 */
public class EmployeeWithComparator {
    int id;
    String name;
    String surname;
    int salary;

    public EmployeeWithComparator(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeWithComparator{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", salary=" + salary
                + '}';
    }
}
