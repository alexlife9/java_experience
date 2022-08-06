package ru.alex_life.io.programmer1;

import java.io.Serializable;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.7. Сериализация. Часть 2
 *
 * В этом классе создаем работника, запишем его данные в классе SerializtionEx2 и передадим второму программисту на чтение
 * @author Alex_life
 * @version 2.0
 * проверяем transient
 * @since 06.08.2022
 */
public class Employee implements Serializable { //обязательно имплементим интерфейс чтобы была возможность запаковоть данного работника и передать куда-нибудь еще
    private static final long serialVersionUID = 2; //в сериализируемом классе необходимо использовоть идентификатор версий, чтобы при изменениях данных было понятно в чем проблема
    String name;
    String surname;
    String departament;
    //int age;
    transient double salary; //чтобы какие-то поля не попадали в файл на сериализацию надо использовать ключевое слово transient

    public Employee(String name,
                    String surname,
                    String departament,
                    //int age,
                    double salary) {
        this.name = name;
        this.surname = surname;
        this.departament = departament;
        //this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + "surname='" + surname + '\''
                + ", departament='" + departament + '\''
                //+ ", age=" + age
                + ", salary=" + salary
                + '}';
    }
}
