package ru.alex_life.nestedclasses.anonymousNC;

import org.junit.Before;

/**
 * Anonymous Class
 * Анонимные классы не имею имени
 * Анонимные классы это "объявление" класса и одновременное создание объекта в одном выражении
 * В анонимных классах невозможно написать конструктор
 * Анонимный класс может обращаться даже к private элементам внешнего класса
 * Лямбда - это краткая форма для написания анонимных классов
 *
 * @author Alex_life
 * @version 1.0
 * @since 25.10.2022
 */
public class AnonymousClass {
    private int x = 5;
    private static int z = 10;
    public static void main(String[] args) {
        Math math = new Math() { /* создали анонимный класс, но у него нет имени, поэтому он и называется анонимный */
            /* этот анонимный класс с объектом math имплементировал интерфейс Math и переопределил его методы */
            /* все тело анонимного класса пишется в фигурных скобках после создания объекта new Math() {тело} */
            @Override
            public int doOperation(int a, int b) {
                return a + b; /* метод будет складывать параметры */
            }
        }; /* ставим точку с запаятой после объявления объекта new Math()*/

        Math math2 = new Math() { /* создаем еще один анонимный класс */
            @Override
            public int doOperation(int a, int b) {
                AnonymousClass ac = new AnonymousClass(); /* но сначала надо создать объект внешнего класса,
                 либо использовать статик переменную*/
                return a * b + ac.x - z; /* метод будет умножать параметры
                и прибавлять private элемент внешнего класса
                и вычитать статик элемент внешнего класса */
            }
        };

        System.out.println(math.doOperation(5, 6));
        System.out.println(math2.doOperation(6, 3));
    }
}

interface Math {
    int doOperation(int a, int b); /* просто некий метод что-то делающий с параметрами а и б */
}
