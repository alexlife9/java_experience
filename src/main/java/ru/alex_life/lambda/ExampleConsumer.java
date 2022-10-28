package ru.alex_life.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Видео-курс Черный пояс
 * Consumer
 * Это потребитель. Ничего не возвращает. Только принимает в параметре какой-то объект.
 *
 * @author Alex_life
 * @version 1.0
 * @since 29.10.2022
 */
public class ExampleConsumer {
    public static ArrayList<Car2> createThreeCars(Supplier<Car2> carSupplier) {
        ArrayList<Car2> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            al.add(carSupplier.get()); //вернется 3 одинаковых объекта Car
        }
        return al;
    }

    public static void changeCar(Car2 car2, Consumer<Car2> carConsumer) {
        carConsumer.accept(car2);
    }

    public static void main(String[] args) {
        ArrayList<Car2> ourCars = createThreeCars(() -> new Car2("nis", "red", 1.6));
        System.out.println("Our cars: " + ourCars);

        changeCar(ourCars.get(0),
                car2 -> {
                    car2.color = "black";
                    car2.engine = 2.4;
                    System.out.println("uppgrade car: " + car2);
                });
        System.out.println("Our cars: " + ourCars);
    }
}

class Car2 {
    String model;
    String color;
    double engine;

    public Car2(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car2 {" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
