package ru.alex_life.nestedclasses.innerNC;

/**
 * Inner Nested классы
 * Каждый объект Inner класса всегда ассоциируется с объектом внешнего класса
 * Создавая объект Inner класса нужно перед этим создать объект его внешнего класса
 * Inner класс может содержать только non-static элементы, но может иметть static final элементы
 * Inner класс может обращаться даже к private элементам внешнего класса
 * Внешний класс может обращаться даже к private элементам Inner класса, прежде создав его объект
 *
 * @author Alex_life
 * @version 1.0
 * @since 25.10.2022
 */
public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, int horsePower) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(horsePower); /* вот так создается объект Inner Nested класса */
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    /* создали inner нестед класс Engine внутри внешнего класса Car */
    public class Engine {
        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My Engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Car car = new Car("red", 2, 400);
        System.out.println(car);
    }
}

