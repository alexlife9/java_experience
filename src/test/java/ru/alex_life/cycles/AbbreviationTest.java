package ru.alex_life.cycles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.8. Аббревиатуры
 *
 * Метод принимает строку, которая состоит из нескольких слов каждое из которых начинается с прописной буквы.
 * Необходимо из полученной строки сформировать аббревиатуру.
 * Для формирования новой строки используйте StringBuilder и его метод append().
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class AbbreviationTest {
    @Test
    public void collect() {
        String s = "North Atlantic Treaty Organization";
        String rsl = Abbreviation.collect(s);
        assertThat(rsl, is("NATO"));
    }

    @Test
    public void collect1() {
        String s = "ChiefExecutiveOfficer";
        String rsl = Abbreviation.collect(s);
        assertThat(rsl, is("CEO"));
    }

    @Test
    public void collect2() {
        String s = "United Nations Organization";
        String rsl = Abbreviation.collect(s);
        assertThat(rsl, is("UNO"));
    }
}
