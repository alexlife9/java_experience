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
public class Pair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}
