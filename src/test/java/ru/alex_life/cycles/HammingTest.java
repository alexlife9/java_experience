package ru.alex_life.cycles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.5. Расстояние Хэмминга
 *
 * Расстояние Хэмминга - это число позиций в которых соответствующие символы двух слов одинаковой длины различны.
 * Например, сравнивая "101010111" и "111010100" мы должны получить - 3,
 * поскольку не равны символы (выделены точками) - "1.0.10101.11." и "1.1.10101.00."
 *
 * Метод принимает 2 строки, всегда одинаковой длины.
 * Необходимо определить для строки расстояние Хэмминга.
 * Для этого в цикле последовательно необходимо сравнивать символы в строке.
 * Для извлечения символа из строки используйте метод charAt(int index) класса String.
 *
 * @author Alex_life
 * @version 1.0
 * @since 08.10.2021
 */
public class HammingTest {
    @Test
    public void checkStringsIs2() {
        int rsl = Hamming.checkStrings("12345", "02346");
        assertThat(rsl, is(2));
    }

    @Test
    public void checkStringsIs3() {
        int rsl = Hamming.checkStrings("2173896", "2233796");
        assertThat(rsl, is(3));
    }

    @Test
    public void checkStringsIs5() {
        int rsl = Hamming.checkStrings("abcde", "bcdef");
        assertThat(rsl, is(5));
    }

    @Test
    public void checkStringsIs0() {
        int rsl = Hamming.checkStrings("abcde", "abcde");
        assertThat(rsl, is(0));
    }
}
