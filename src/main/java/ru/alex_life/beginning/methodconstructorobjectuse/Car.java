package ru.alex_life.beginning.methodconstructorobjectuse;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 5. Создание объектов. Понятие «конструктор». Объявление и вызов методов.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Car {
    Car() {
        //это так выглядит конструктор по-умолчанию, но если его прям так явно напечатать,
        //он уже перестанет быть дефолтным конструктором
    }
    //заполняем поля класса Car
    String color; //цвет машины
    String engine; //тип двигателя
    int speed; //скорость

    //создаем 3 метода
    //первый метод gas увеличивает скорость
    int gas(int skorost) { //int skorost - на какое количество увеличиваем скорость
        speed += skorost; //тело метода - прибавляем skorost к speed
        return speed; // в конце метода обязательно указываем что он возвращает если он не void
    }

    //второй метод tormoz уменьшает скорость
    int tormoz(int skorost) {
        speed -= skorost;
        return speed;
    }

    //третий метод выводит информацию о машине - цвет, тип двигателя и скорость
    void showInfo() { //обращаясь к данному методу, выводим в консоль нужную инфу
        System.out.println("цвет: " + color + ", мотор: " + engine + ", скорость: " + speed); //
    }
}

class CarUse {
    public static void main(String[] args) {
        Car lada = new Car(); //создали новый объект класса Car с именем lada
        //при помощи конструктора. Имя конструктора всегда совпадает с именем класса
        lada.color = "белый"; //присваиваем значения переменным для созданного объекта
        lada.engine = "V4";
        lada.speed = 60;

        lada.showInfo(); //вызываем метод showInfo из класса Car
        lada.gas(20); //вызываем метод увеличения скорости
        lada.tormoz(80); //вызываем метод уменьшения скорости
        lada.showInfo(); //смотрим новые значения машины
    }
}
