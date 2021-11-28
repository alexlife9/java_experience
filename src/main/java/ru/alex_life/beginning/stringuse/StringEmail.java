package ru.alex_life.beginning.stringuse;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 16. Всё о классе String
 *
 * Задание. Создать класс с методом email. Метод должен принимать на вход один String параметр. Этот параметр должен
 * содержать в себе емейлы в следующем виде: ya@yahoo.com; on@mail.ru; ona@gmail.com;
 * После каждого мыла должна стоять ";".
 * Метод должен выводить информацию о том, какой почтой пользуются, исходя из параметра, в следующем виде: yahoo, mail, gmail
 *
 * @author Alex_life
 * @version 1.0
 * @since 21.11.2021
 */
public class StringEmail {
    public void email(String s) { //создали метод с одним параметром String
        int a = 0; //позиция символа @
        int b = 0; //позиция символа .
        int c = 0; //позиция символа ;
        while (c < s.length() - 1) {
            a = s.indexOf('@', c);
            b = s.indexOf('.', c);
            c = s.indexOf(';', c + 1);
            System.out.println(s.substring(a + 1, b));
        }
    }

    public static void main(String[] args) {
        StringEmail str = new StringEmail();
        str.email("ya@yahoo.com; on@mail.ru; ona@gmail.com;");
    }
}
