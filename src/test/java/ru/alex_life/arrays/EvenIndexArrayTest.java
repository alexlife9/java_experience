package ru.alex_life.arrays;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.6. Массивы
 * 1.6. Элементы с четными индексами
 *
 * Для получения всех элементов в массиве нужно использовать цикл for().
 * С помощью индекса, который управляет циклом for будем получать элементы из массива.
 * Нужно напечатать элементы массива, которые имеют четные ИНДЕКСЫ. Для определения четности индекса надо проверить,
 * что индекс делится на 2 без остатка(используется оператор % 2).
 *
 * @author Alex_life
 * @version 1.0
 * @since 20.10.2021
 */
public class EvenIndexArrayTest {
    @Test
    public void main() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        EvenIndexArray.main(null);
        String ln = System.lineSeparator();
        String expected = "1" + ln + "3" + ln + "5" + ln + "7" + ln + "9" + ln;
        assertThat(out.toString(), is(expected));
    }
}