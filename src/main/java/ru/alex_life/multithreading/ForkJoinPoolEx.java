package ru.alex_life.multithreading;

import java.util.Date;

/**
 * ForkJoinPool
 *
 * Допустим, у нас есть некий массив большого размера, заполненный числами, и наша задача - найти сумму всех этих чисел
 *
 * Заполнить массив можно любыми числами (в данном случае это не важно). Скорее всего System.out.println(new Date()) –
 * не самый оптимальный способ измерить скорость выполнения кода, но весьма простой и для нашего примера сгодится.
 * Thread.sleep(1) добавлен для того, чтобы сымитировать задачу, которая при работе в одном потоке вызывает значительную
 * загрузку процессора. У меня на выполнение данного кода ушло 17 секунд. Таким образом, мы имеем некую большую задачу,
 * существенно замедляющую работу нашей программы. Очевидно, что запуск её в параллельном потоке проблемы не решит.
 * Что же делать? Конечно же, разбить эту задачу на подзадачи. Допустим, мы разделим наш массив пополам, суммирование
 * первой части массива запустим в одном потоке, суммирование второй части массива – в другом,
 * а потом сложим получившиеся результаты. Проблема в том, что если задача достаточно большая, то обе её половинки
 * также могут получиться достаточно большого размера, что не лучшим образом скажется на производительности.
 * Следовательно, возможно и их нужно будет поделить на части и продолжать данную операцию до достижения некоего
 * оптимального размера. Когда условие будет достигнуто, каждый из этих кусочков мы отдадим отдельному потоку,
 * а потом соберём получившиеся результаты воедино. Чувствуете? В воздухе отчётливо запахло рекурсией,
 * и мы всё ближе приближаемся к ForkJoinPool.
 *
 * https:\\habr.com/ru/post/565924/
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.10.2022
 */
public class ForkJoinPoolEx {
    public static void main(String[] args) throws InterruptedException {
        int[] array = getInitArray(10000);
        System.out.println(new Date());
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            Thread.sleep(1);
            sum += array[i];
        }
        System.out.println(sum);
        System.out.println(new Date());
    }

    public static int[] getInitArray(int capacity) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = 1;
        }
        return array;
    }

}
