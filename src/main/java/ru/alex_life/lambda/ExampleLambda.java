package ru.alex_life.lambda;

/**
 * Видео-курс Черный пояс
 * Lambda выражения
 * Оператор "->" разделяет параметры метода и тело метода
 * В Лямбда-выражении справа от "->" находится тело метода, которое было бы у метода соответствующего класса,
 * имплементировавшего наш интерфейс с единственным методом.
 * Когда в методе интерфейса есть два (и больше) параметра, то левую часть лямбды надо брать в скобки
 *
 * @author Alex_life
 * @version 1.0
 * @since 27.10.2022
 */
public class ExampleLambda {
    static void def(I i) {
        System.out.println(i.abc("privet"));
    }

    public static void main(String[] args) {
        def((String str) -> {return str.length();} );
    }
}

interface I {
    int abc(String s);
}












