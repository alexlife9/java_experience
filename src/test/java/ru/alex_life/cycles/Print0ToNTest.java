package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.1. Вывести на консоль числа от 0 до N
 *
 * Выведите на консоль числа от 0 до N. N не входит. В этом упражнении используйте цикл for c index.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Print0ToNTest {

    @Test
    public void out3() {
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Print0ToN.out(3);
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("0").add("1").add("2").toString();
        assertThat(out.toString(), is(expect));
    }

    @Test
    public void out2() {
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Print0ToN.out(2);
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("0").add("1").toString();
        assertThat(out.toString(), is(expect));
    }
}
