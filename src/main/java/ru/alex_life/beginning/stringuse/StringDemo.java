package ru.alex_life.beginning.stringuse;

import java.util.Locale;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 16. Всё о классе String. Основные методы String
 *
 * String is Immutable - не может быть изменён. Если написали String s = "привет". То значение s не может быть изменено.
 * Это достигается благодаря тому, что:
 * 1. String хранит своё значение в privat массиве Char-ов и имеет фиксированную длину.
 * 2. String хранит своё значение в final массиве, поэтому его инициализация может происходить только один раз
 * 3. Ни один из методов класса String не изменяет индивидуальные элементы массива типа Char
 *
 * @author Alex_life
 * @version 1.0
 * @since 21.11.2021
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = new String("privetivpriDE1     ");

        int a = s1.length();   // length() -> int
        System.out.println(a); // возвращает длину String - по сути длину массива чаров

        char c1 = s1.charAt(2); // charAt(int index) -> char
        System.out.println(c1); // возвращет Char на нужном индексе
        //при этом если указать несуществующий индекс - вылетит Exception о выходе за пределы массива

        int i1 = s1.indexOf('p'); // indexOf(char c) -> int
        System.out.println(i1);   // возвращеает индекс искомого символа. 'p' на индексе 0

        int i2 = s1.indexOf("vet"); // indexOf(String s) -> int
        System.out.println(i2);     // возвращет искомую часть слова до первого совпадения. "vet" начинается на индексе 3

        int i3 = s1.indexOf('Z'); // если указать несуществующий символ или часть слова, то всегда будет -1
        System.out.println(i3);

        int i4 = s1.indexOf('i', 3); // indexOf(Char c, int fromIndex) -> int
        System.out.println(i4);                  // возвращает индекс указанного чара, начаиная с указанного места

        int i5 = s1.indexOf("iv", 4); // indexOf(String s, int fromIndex) -> int
        System.out.println(i5);                   // возвращает индекс указанной части слова, начаиная с указанного места

        boolean i6 = s1.startsWith("pri"); // startsWith(String prefix) -> boolean
        System.out.println(i6);            // возвращает тру если старт совпадает

        boolean i7 = s1.startsWith("pri", 8); // startsWith(String prefix, int from) -> boolean
        System.out.println(i7); // возвращает тру если старт совпадает с указанного индекса

        boolean i8 = s1.endsWith("ide"); //endsWith(String suffix) -> boolean
        System.out.println(i8);          // возвращает тру если концовка совпадает

        String s2 = s1.substring(2); // substring(int beginIndex) -> String
        System.out.println(s2);      //возвращает часть String с указанного индекса
        System.out.println(s1);      //при этом начальный String НЕ ИЗМЕНЯЕТСЯ

        String s3 = s1.substring(2, 6); // substring(int beginIndex, int endIndex) -> String
        System.out.println(s3); //возвращает часть String между указанными индексами, не включая последний указанный индекс

        String s4 = s1.trim();  // trim() -> String
        System.out.println(s4); // убирает все пробелы слева и справа String-а, при этом в центре не убирает

        String s5 = s1.replace('p', 'Z'); // replace(oldChar, newChar) -> String
        System.out.println(s5);                          // заменяет ВСЕ найденные указанные чары на новые
                                 //если указать на поиск для замены несуществующий символ то выведется начальный String

        String s6 = s1.replace("pri", "ZZZ"); // replace(target, replacement) -> String
        System.out.println(s1);
        System.out.println(s6); //меняет указанную последовательность чаров на другой кусок (можно любой длины)

        String s7 = s1.replaceAll("p.i", "ZZZ"); // replace(regex, replacement) -> String
        System.out.println(s7); //меняет регулярное выражение на другой кусок (можно любой длины)

        String s8 = "privet, ";
        String s9 = "drug";
        System.out.println(s8.concat(s9)); // но конечно проще написать (s8 + s9)

        String s10 = s1.toLowerCase(); // toLowerCase() -> String
        System.out.println(s10);       // меняет ВСЕ заглавные буквы во входящем String-е на прописные

        String s11 = s1.toUpperCase(); // toUpperCase() -> String
        System.out.println(s11);       //меняет ВСЕ прописные буквы входящем String-е на ЗАГЛАВНЫЕ

        boolean s12 = s1.contains("E1"); // contains("String s") -> boolean
        System.out.println(s12);         // проверяет содержится ли во входящем String-е искомое выражение

        String a1 = "привет";
        String a2 = "пока";
        String a3 = a1.concat(a2).trim().replace("п", "ккк").toUpperCase();
        System.out.println(a3); //При Method Chaining методы выполняются слева направо

        String a4 = "";
        System.out.println(a4.isEmpty()); // true

        String a5 = " "; //тут уже есть один знак - пробел
        System.out.println(a5.isEmpty()); //поэтому будет false

        StringBuilder sb1 = new StringBuilder("Hello");
        String s = new String(sb1); //в параметр конструктора String можно передавать объект StringBuilder-а
        System.out.println(s);

        char[] array = new char[] {'p', 'r', 'i', 'v', 'e', 't'};
        String str = new String(array); //в параметр конструктора передаем массив чаров
        System.out.println(str);
    }
}
