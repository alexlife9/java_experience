package ru.alex_life.beginning.stringuse;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 17. Всё о классе StringBuilder. Основные методы
 *
 * StringBuilder нужен когда необходимо изменить начальный String не создавая новый объект. Это позволяет экономить память,
 * так как при создании новых объектов на них выделяется память.
 * Capacity StringBuilder может увеличиваться до бесконечности, в отличии от String в котором длина задана изнально и не изменяется
 * Значение StringBuilder в массиве символов
 *
 * @author Alex_life
 * @version 1.0
 * @since 28.11.2021
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder(); //создали объект без какого-либо определенного значения,
        StringBuilder sb2 = new StringBuilder("Good Day!"); //создали объект со значением "Good Day" с capacity = 25(16+8) Знаки не учитываются
        StringBuilder sb3 = new StringBuilder(50); //создали пустой объект с capacity = 50
        StringBuilder sb4 = new StringBuilder(sb2); //в параметре конструктора можно использовать другой StringBuilder

        int a1 = sb2.length();   // length() -> int
        int a2 = sb3.length();   // возвращает длину значения объекта
        System.out.println(a1); // Good Day! - 9 символов
        System.out.println(a2); // capacity = 50, но значение объекта ничем не заполнено, поэтому length = 0

        char c1 = sb2.charAt(5); // charAt(int index) -> char
        System.out.println(c1); // возвращет Char на нужном индексе

        int i2 = sb2.indexOf("D"); // indexOf(String s) -> int
        System.out.println(i2);    // возвращет индекс искомой части слова до первого совпадения. "D" начинается на индексе 5

        int i3 = sb2.indexOf("d", 2); // indexOf(String s, int fromIndex) -> int
        System.out.println(i3);                   // возвращает индекс указанной части слова, начаиная с указанного места

        String s = sb2.substring(5); // substring(int beginIndex) -> String
        System.out.println(s);            // возвращает часть String с указанного индекса
        System.out.println(sb2);          // при этом начальный StringBuilder НЕ ИЗМЕНЯЕТСЯ

        String s2 = sb2.substring(4, 7); // substring(int beginIndex, int endIndex) -> String
        System.out.println(s2); // возвращает часть String между указанными индексами, не включая последний указанный индекс

        sb2.append(" Maybe :)"); // append(DataType dt) -> StringBuilder
        System.out.println(sb2); // метод меняет первоначальный объект
        sb2.append(true);        // в параметр метода append можно добавлять любой примитивный тип данных. null нельзя
        System.out.println(sb2); // в итоге всё добавляется к первоначальному значению объекта sb2
        System.out.println(sb4); // НО! в sb4 мы передали первоначальный sb2 и как бы заморозили его состояние

        sb4.insert(0, "NO "); // insert(int toIndex, DataType dt) -> StringBuilder
        System.out.println(sb4); // вставляем любой примитивный тип данных в указанное место по индексу

        sb4.delete(2, 3);         // delete(int start, int end) -> StringBuilder
        System.out.println(sb4);  // удаляет часть значения объекта начиная с указанного индекса, не включая конечный индекс

        sb4.deleteCharAt(6);      // deleteCharAt(int index) -> StringBuilder
        System.out.println(sb4);  // удаляет символ по указанному индесу

        sb4.reverse();             // reverse() -> StringBuilder
        System.out.println(sb4);   // переворачивает всю входящую строку.

        sb4.replace(3, 5, "ZZZZ"); // replace(int start, int end, String s) -> StringBuilder
        System.out.println(sb4);                // меняет часть значения между индексами на указанный в параметре String

        int i4 = sb4.capacity(); // capacity() -> int
        System.out.println(i4);  // возвращает количество мест в массиве, не обращая внимания на фактическую заполненность
        System.out.println(sb1.capacity()); // по умолчанию capacity пустого объекта StringBuilder = 16
    }
}
