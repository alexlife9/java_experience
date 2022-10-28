package ru.alex_life.lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Видео-курс Черный пояс
 * Supplier
 * Это поставщик. В данном примере поставляет объекты
 * @author Alex_life
 * @version 1.0
 * @since 28.10.2022
 */
public class ExampleSupplier {
    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            al.add(carSupplier.get()); //вернется 3 одинаковых объекта Car
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("nis", "red", 1.6));
        System.out.println("Our cars: " + ourCars);
    }
}

class Car {
    String model;
    String color;
    double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}