package ru.alex_life.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.3.1. Коллекция List, ArrayList
 * 0.1. Проверить список и получить первый элемент
 *
 * Начнем знакомиться с методами, которые определены в интерфейсе List, как они работают и для чего предназначены.
 * Рассмотрим такие методы:
 * boolean isEmpty() - метод позволяет проверить содержатся ли элементы в коллекции.
 *              true - коллекция пуста, false - коллекция содержит элементы.
 * E get(int index) - возвращает объект типа E из списка по индексу index. Если элементов нет -
 *              генерируется исключение IndexOutOfBoundsException - значит нужно быть аккуратным при использовании этого метода.
 * Также стоит упомянуть, что нумерация индексов в коллекции, как и в массивах, начинается с 0,
 * поэтому первый элемент в списке имеет индекс 0, а не 1.
 * Задание: необходимо реализовать метод, который будет возвращать первую строку из коллекции строк,
 * но прежде чем получить результат - необходимо проверить содержатся ли элементы в списке.
 * Если их нет - возвращаем пустую строку, иначе - первый элемент в коллекции.
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class CheckerAhdGetterTest {
    @Test
    public void whenGetNull() {
        List<String> list = new ArrayList<>();
        String result = CheckerAhdGetter.getElement(list);
        String expected = "";
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetFirstElement() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        String result = CheckerAhdGetter.getElement(list);
        String expected = "first";
        assertThat(result, is(expected));
    }
}
