package ru.alex_life.collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Видео-курс UDEMY Java для начинающих
 * 20. Всё о классе ArrayList. Итераторы
 *
 * @author Alex_life
 * @version 1.0
 * @since 10.04.2022
 */
public class ArrayListIterator {
    public static void main(String[] args) {
        String s1 = "A";
        String s2 = "B";
        String s3 = "C";
        String s4 = "D";
        ArrayList<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) { //пока есть следующий элемент, будем входить в тело Листа
            System.out.print(it.next()); // и выводить этот элемент
        }
        System.out.println();

        //Итератор позволяет пробегать все элементы, но в отличии от форича, может еще удалять элемент
        //Итератор используется в коллекциях, базах данных, чтении файлов.
        //Метод hasNext проверяет, есть ли следующий элемент.
        //Метод next возвращает первый элемент ячейки. Второй вызов метода next вернет второй элемент и так далее.
        //Метод next сдвигает указатель итератора. Указатель - это ссылка на элемент, который нужно вернуть.

        while (it.hasNext()) { //пока есть следующий элемент, будем входить в тело Листа
            it.next();
            it.remove();
            System.out.println(it.next());
        }

    }
}
