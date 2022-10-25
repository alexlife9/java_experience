package ru.alex_life.nestedclasses.staticNC;

/**
 * Static Nested классы можно использовать как обычные внешние классы, предварительно явно указавав на него,
 * например - Car.Engine. Модифактор при этом у класса Engine должен быть public.
 * Static Nested класс может содержать static и non-static элементы. Также он может обращаться к private элементам
 * внешнего класса, но только к static.
 *
 * @author Alex_life
 * @version 1.0
 * @since 25.10.2022
 */
public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    /* создали статичный нестед класс Engine внутри внешнего класса Car */
    public static class Engine {
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
        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);

        Car car = new Car("red", 2, engine);
        System.out.println(car);


    }
}
