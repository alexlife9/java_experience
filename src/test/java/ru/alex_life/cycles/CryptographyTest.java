package ru.alex_life.cycles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.6. Шифр строки
 *
 * Если посмотреть в чек после оплаты банковской картой, то там никогда не отражается номер карты полностью -
 * отражаются только последние четыре символа, все остальные зашифрованы.
 * Необходимо реализовать метод, который принимает строку, которую необходимо зашифровать таким образом,
 * чтобы на выходе отражались только 4 последних элемента, все остальные были заменены на #. При этом соблюсти условия:
 * 1. Если входная строка пустая - необходимо вернуть строку "empty";
 * 2. Если входная строка содержит больше 0 и не более 4 символов - метод должен вернуть исходную строку.
 * Для решения используйте StringBuilder и его метод setCharAt().
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.10.2021
 */
public class CryptographyTest {
    @Test
    public void codeLengthGreat4() {
        String code = Cryptography.code("4556364607935616");
        assertThat(code, is("############5616"));
    }

    @Test
    public void codeLengthLess4() {
        String code = Cryptography.code("123");
        assertThat(code, is("123"));
    }

    @Test
    public void codeEmptyString() {
        String code = Cryptography.code("");
        assertThat(code, is("empty"));
    }
}
