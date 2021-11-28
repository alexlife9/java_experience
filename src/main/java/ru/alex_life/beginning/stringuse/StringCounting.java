package ru.alex_life.beginning.stringuse;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 16. Всё о классе String
 *
 * @author Alex_life
 * @version 1.0
 * @since 18.11.2021
 */
public class StringCounting {
    public static void main(String[] args) {
        String s1 = new String("Privet"); //создаем новый объект со значением Privet
        String s2 = "Privet"; //создается новый объект в СтрингПуле
        System.out.println("Privet"); //проверяется - существует ли в СтрингПуле такой объект? True, потому что он создан на второй строчке
                                      // и выводим этот объект со второй строчки
        System.out.println("Poka"); //в СтрингПуле такого объекта нет, поэтому создаем его
        System.out.println("Privet" == "poka"); // Privet уже есть, poka с маленькой буквы, значит создаем новый объект "poka"
        String s3 = new String("Privet"); //создается новый уникальный объект, даже несмотря на то, что Privet уже был создан выше
        System.out.println(s1 == s3); // будет false потому что s1 и s3 ссылаются на разные объекты,
                                      // даже несмотря на то, что содержимое у этих объектов одинаковое
        System.out.println(s1.equals(s3)); // по дефолту == и equals это одно и тоже, но для класса String метод equals
        //уже перезаписан и поэтому при сравнении String-ов тут будет true,
        //потому что сравнивается длина и содержимое объектов, а не их ссылки.

        String a1 = "ok"; //создаем новый объект "ок" в стрингпуле
        String a2 = "ok"; //поскольку объект "ок" уже содержится в стрингпуле, то а2 тоже ссылаем на этот объект
        System.out.println(a1 == a1); //да, равно, будет true, потому что а1 и а2 ссылаются на один объект
        System.out.println(a1.equals(a2)); //тоже true, потому что содержимое объектов равно

        System.out.println(a1 != s3); // да, не равно, будет true

        String a3 = "no";
        String a4 = "No";
        System.out.println(a3.equals(a4)); // будет конечно же false, потому что хоть длина одинаковая, но отличается заглавная
        System.out.println(a3.equalsIgnoreCase(a4)); // будет true, потому что игнорируется регистр букв
    }
}