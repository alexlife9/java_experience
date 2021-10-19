package ru.alex_life.comparation;

/**
 * Видео-курс Черный пояс.
 * 2.1. Интерфейс Comparable
 * Сортировка с помощью интерфейса Comparable
 *
 * @author Alex_life
 * @version 1.0
 * @since 01.10.2021
 */
public class EmployeeWithComparable implements Comparable<EmployeeWithComparable> {
    int id;
    String name;
    String surname;
    int salary;

    public EmployeeWithComparable(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", salary=" + salary
                + '}';
    }

    @Override
    public int compareTo(EmployeeWithComparable anotherEmployeeWithComparable) {
        //способ сравнения в лоб:
//        if (this.id == anotherEmployee.id) {
//            return 0;
//        } else if (this.id < anotherEmployee.id) {
//            return -1;
//        } else {
//            return 1;
//        }

        //но лучше так писать:
//        return this.id - anotherEmployee.id;
        //т.е. если результат положительный, то первое больше второго
             //если отрицательный, то наоборот
             //если 0, то они равны.

        //еще можно написать используя функциональность Integer:
//        return this.id.compareTo(anotherEmployee.id); // но в этом случае надо поменять поле int id на Integer id
        //при этом! в случае сравнения полей String их менять не надо! и можно сразу написать:
        return this.name.compareTo(anotherEmployeeWithComparable.name);
    }
}

