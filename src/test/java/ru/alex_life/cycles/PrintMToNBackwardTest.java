package ru.alex_life.cycles;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.4. Вывести на консоль числа от M до N.
 *
 * Нужно вывести числа от M до N. N не включено. M > N.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class PrintMToNBackwardTest {
    @Test
    public void test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        PrintMToNBackward.out(5, 1);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "5" + ln +
                        "4" + ln +
                        "3" + ln +
                        "2" + ln
        ));
    }

}
