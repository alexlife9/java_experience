package ru.alex_life.beginning.stringuse;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 17. Всё о классе StringBuilder
 *
 * Задание. Создать класс с методом ravenstvo. Входящие параметры метода - два объекта класса StringBuilder.
 * Метод должен иметь boolean return type, возращать true если значения объектов совпадают и false, если нет
 *
 * @author Alex_life
 * @version 1.0
 * @since 28.11.2021
 */
public class StringDZRavenstvo {

    public static boolean ravenstvo(StringBuilder s1, StringBuilder s2) {
        boolean rsl = true;
        if (s1.length() == s2.length()) { // проверяем равна ли длина у объектов
            for (int i = 1; i < s1.length(); i++) { // если равна, то проходим циклом по всей длине объекта
                if (s1.charAt(i) != s2.charAt(i)) { // если символы под одинаковыми индексами у двух объектов не равны,
                    rsl = false;                    // то завершаем цикл
                    break;
                }
            }
        } else {
            rsl = false;
        }
        return rsl;
    }

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("123");
        StringBuilder sb2 = new StringBuilder("124");
        boolean a = ravenstvo(sb1, sb2); // передаем в метод созданные выше два объекта на сравнение
        System.out.println(a);
        System.out.println(ravenstvo(new StringBuilder("zz"), new StringBuilder("zz")));
    }
}
