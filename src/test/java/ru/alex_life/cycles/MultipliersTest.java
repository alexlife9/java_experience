package ru.alex_life.cycles;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.8. Вывести делители числа
 *
 * Дано целое число n (> 0). Нужно вывести делители числа. Делитель это число на которое делится заданное число.
 * Например:
 * Для 1, это 1
 * Для 2, это 1 и 2
 * Для 6, это 1, 2, 3, 6
 * Для 7, это 1, 7
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class MultipliersTest {

    @Test
    public void when1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Multipliers.out(1);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "1" + ln
        ));
    }

    @Test
    public void when2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Multipliers.out(2);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "1" + ln +
                        "2" + ln
        ));
    }

    @Test
    public void when6() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Multipliers.out(6);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "1" + ln +
                        "2" + ln +
                        "3" + ln +
                        "6" + ln
        ));
    }
}