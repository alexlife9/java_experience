package ru.alex_life.cycles;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 0.5. Вывести стоимость конфет за килограмм
 *
 * Дано целое число price — цена 1 кг конфет. Вывести стоимость 1, 2, . . . , 5 кг конфет.
 *
 * @author Alex_life
 * @version 1.0
 * @since 07.10.2021
 */
public class SweetPriceTest {

    @Test
    public void test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        SweetPrice.out(10);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "10" + ln +
                        "20" + ln +
                        "30" + ln +
                        "40" + ln +
                        "50" + ln
        ));
    }
}
