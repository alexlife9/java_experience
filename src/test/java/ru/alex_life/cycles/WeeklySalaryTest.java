package ru.alex_life.cycles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.9. Еженедельная зарплата
 *
 * Метод принимает массив целочисленных значений, при этом каждый элемент массива означает количество часов,
 * которые работник отработал в каждый день недели. Работник может работать и в выходные.
 * При этом оплачивается труд следующим образом:
 * 1. В течение первых 8 часов каждый рабочий день за каждый час зарплата составляет 10 долларов.
 * 2. За каждый отработанный час сверх нормы (8 часов) работник зарабатывает 15 долларов.
 * 3. В выходные дни работодатель платит в два раза больше, как за каждый час по норме(первые 8 часов), так и сверхурочные.
 * Необходимо реализовать метод, который посчитает общую сумму заработка за отработанную неделю.
 *
 * @author Alex_life
 * @version 1.0
 * @since 09.10.2021
 */
public class WeeklySalaryTest {
    @Test
    public void calculateIs400() {
        int[] hours = {8, 8, 8, 8, 8, 0, 0};
        int rsl = WeeklySalary.calculate(hours);
        assertThat(rsl, is(400));
    }

    @Test
    public void calculateIs410() {
        int[] hours = {10, 10, 10, 0, 8, 0, 0};
        int rsl = WeeklySalary.calculate(hours);
        assertThat(rsl, is(410));
    }

    @Test
    public void calculateIs690() {
        int[] hours = {10, 0, 12, 0, 8, 12, 4};
        int rsl = WeeklySalary.calculate(hours);
        assertThat(rsl, is(690));
    }
}
