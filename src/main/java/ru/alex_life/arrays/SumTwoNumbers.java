package ru.alex_life.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача "найти в массиве значения пары элементов с заданной суммой"
 * Элементы не отсортированы и могут содержать дубликаты
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class SumTwoNumbers {
    public static void main(String[] args) {
        int trigger = 6;
        int[] input = {2, 5, 0, 4, 1, 3, 1, 3, 7};
        Set<Integer> set = new HashSet<>();
        for (Integer value : input) {
            if (set.contains(trigger - value)) {
                System.out.println(value + " и " + (trigger - value));
            }
            set.add(value);
        }
    }
}