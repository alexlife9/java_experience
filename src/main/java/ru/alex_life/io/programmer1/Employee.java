package ru.alex_life.io.programmer1;

import java.io.Serializable;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.7. Сериализация. Часть 1
 *
 * В этом классе создаем работника, запишем его данные в классе SerializtionEx2 и передадим второму программисту на чтение
 * @author Alex_life
 * @version 1.0
 * @since 06.08.2022
 */
public class Employee implements Serializable { //обязательно имплементим интерфейс чтобы была возможность запаковоть данного работника и передать куда-нибудь еще
    String name;
    String departament;
    int age;
    double salary;

    public Employee(String name, String departament, int age, double salary) {
        this.name = name;
        this.departament = departament;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", departament='" + departament + '\''
                + ", age=" + age
                + ", salary=" + salary
                + '}';
    }
}
