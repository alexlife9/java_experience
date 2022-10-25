package ru.alex_life.nestedclasses.localNC;

/**
 * @author Alex_life
 * @version 1.0
 * @since 25.10.2022
 */
public class LocalInner2 {
    public static void main(String[] args) {
        class Sum implements Math2 { /* Создаем Local класс Sum. Имплементим Math2 */
            @Override /* переопределяем методы класса Math2*/
            public int doOperation(int a, int b) {
                return a + b;
            }
        }
        Sum sum = new Sum(); /* создаем экземплярLocal класса */
        System.out.println(sum.doOperation(5, 3));
    }
}

interface Math2 {
    int doOperation(int a, int b);
}
