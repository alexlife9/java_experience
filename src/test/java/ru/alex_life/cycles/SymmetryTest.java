package ru.alex_life.cycles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.7. Симметричное число
 *
 * Метод принимает целочисленное значение. Необходимо проверить является ли оно симметричным или нет.
 * Симметричным считается число которое в котором числа идущие по порядку в прямом и обратном порядке равны друг другу.
 * Для решения можете преобразовать число в строку. Проходите по полученной строке в цикле до середины
 * и сравниваете символ который стоит на первой позиции с символом на последней,
 * второй позиции с символом на предпоследней и т.д.
 * Для извлечения символов используйте метод charAt().
 * Метод должен вернуть true, если число симметричное.
 *
 * @author Alex_life
 * @version 1.0
 * @since 11.10.2021
 */
public class SymmetryTest {
    @Test
    public void checkTrue() {
        boolean check = Symmetry.check(1112111);
        assertThat(check, is(true));
    }

    @Test
    public void checkTrueOdd() {
        boolean check = Symmetry.check(11122111);
        assertThat(check, is(true));
    }

    @Test
    public void checkFalse() {
        boolean check = Symmetry.check(123456321);
        assertThat(check, is(false));
    }
}
