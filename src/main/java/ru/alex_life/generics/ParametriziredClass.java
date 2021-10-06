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
public class ParametriziredClass {
    public static void main(String[] args) {
        //тут уже вместо Т пишем конкретный параметр <String> что мы будем добавлять и значение value - привет
        InfoForParametriziredClass<String> info = new InfoForParametriziredClass<>("привет");
        String s = info.getValue();
        System.out.println(info);
        System.out.println("вывод value через геттер - " + s);

        InfoForParametriziredClass<Integer> info2 = new InfoForParametriziredClass<>(555);
        Integer i = info2.getValue();
        System.out.println(info2);
        System.out.println("вывод value через геттер - " + i);
    }
}
