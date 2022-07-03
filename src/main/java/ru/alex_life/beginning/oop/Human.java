package ru.alex_life.beginning.oop;

/**
 *  Видео-курс UDEMY Java для начинающих
 *  22. Инкапсуляция
 *
 *  Это защита данных от внешних нежелательных изменений
 *  Инкапсуляция характеризуется privat переменными и public методами которые нередко проверяют какие-либо условия
 *  Если возвращаемый тип геттера - изменяемый (например стрингбилдер), то лучше возвращать его копию
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.07.2022
 */
public class Human {
    final String gender; //пол человека будем задавать в конструкторе
    public Human(String gender) {
        this.gender = gender;
    }
    private String name; //без модификаторов доступа значения можно писать любые, поэтому устанавливаем private
    private int age; //чтобы данные были видны только в самом классе Human
    private int weight; //и после этого нужно создать паблик методы, чтобы наши переменные были доступны вне класса Human
                        // эти методы называются геттеры и сеттеры

    public String getName() { //метод геттер нужен чтобы показать это имя вне класса Human
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }

    public void setName(String s) { //метод сеттер нужен чтобы изменить это имя вне класса Human
        name = s;
    }

    public void setAge(int i) {
        if (i > 0 && i < 100) {
            age = i;
        }
    }

    public void setWeight(int w) {
        if (w > 0) {
            weight = w;
        }
    }
}

class HumanTest {
    public static void main(String[] args) {
        Human a = new Human("мужчина");
        //a.name = "Alex";
        //a.age = 40; инкапсуляция нужна, чтобы в данном примере нельзя было написать возраст 2000лет или вес -300кг
        //a.weight = 84;
        a.setName("Alex");
        a.setAge(41);
        a.setWeight(84);
        System.out.println(a.getName() + a.getAge() + a.getWeight());


    }
}
