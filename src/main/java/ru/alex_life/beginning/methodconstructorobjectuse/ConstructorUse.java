package ru.alex_life.beginning.methodconstructorobjectuse;

/**
 *  Видео-курс UDEMY Java для начинающих
 *  21. garbage collection, повторение и нюансы
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.04.2022
 */
public class ConstructorUse {
    ConstructorUse() {
        System.out.println("это конструктор");
    }
    void constructorUse() { //это конструктор класса ConstructorUse
        System.out.println("создали объект");
    }
    //если добавить ретерн тайп, то конструктор будет выводиться уже дефолтный
    //void constructorUse() - это уже будет метод.
}

class A {
    public static void main(String[] args) {
        ConstructorUse obj = new ConstructorUse(); //создаем объект класса ConstructorUse
        //запускаем программу и видим что сработал конструктор
    }
}
