package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.3. Вывести на консоль числа от N до 0
 *
 * Выведите на консоль числа от N до 0. N не входит. В этом упражнении используйте цикл for c index
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

public class PrintNTo0Test {

    @Test
    public void out3() {
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintNTo0.out(3);
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("2").add("1").add("0").toString();
        assertThat(out.toString(), is(expect));
    }

    @Test
    public void out2() {
        var out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintNTo0.out(2);
        var expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("1").add("0").toString();
        assertThat(out.toString(), is(expect));
    }
}
