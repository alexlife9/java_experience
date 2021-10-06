package ru.alex_life.generics;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.2. Parameterized class
 *
 * Изучаем для чего в классе нужны дженерики с параметрами
 *
 * @author Alex_life
 * @version 1.0
 * @since 04.10.2021
 */
public class ParametriziredClassForPair {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("привет", 22);
        // при выводе обращаемся к геттерам класса Pair
        System.out.println(pair1.getValue1() + pair1.getValue2());
    }
}
