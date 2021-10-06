package ru.alex_life.generics.game;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.4. Пример на generics
 *
 * В этом классе создаем Школьника который наследуется от общего класса Участники
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Schoolar extends Participant {
    public Schoolar(String name, int age) {
        super(name, age);
    }
}
