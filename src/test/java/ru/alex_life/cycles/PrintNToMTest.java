package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.2. Вывести на консоль числа от N до M
 *
 * Выведите на консоль числа от N до M. M не входит. В этом упражнении используйте цикл for c index.
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

public class PrintNToMTest {

    @Test
    public void out2to4() {
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintNToM.out(2, 4);
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("2").add("3").toString();
        assertThat(out.toString(), is(expect));
    }

    @Test
    public void out1to3() {
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintNToM.out(1, 3);
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("1").add("2").toString();
        assertThat(out.toString(), is(expect));
    }
}
