package ru.alex_life.cycles;

/**
 * Упражнения курса job4j
 * 1.1.5. Циклы
 * 1.8. Аббревиатуры
 *
 * Метод принимает строку, которая состоит из нескольких слов каждое из которых начинается с прописной буквы.
 * Необходимо из полученной строки сформировать аббревиатуру.
 * Для формирования новой строки надо использовать StringBuilder и его метод append().
 *
 * @author Alex_life
 * @version 1.0
 * @since 19.10.2021
 */
public class Abbreviation {
    public static String collect(String s) {
        StringBuilder builder = new StringBuilder(s); //создаем новый объект, чтобы можно было применять методы
        StringBuilder abbrString = new StringBuilder(); //создаем итоговую строку-аббревиатуру
        for (int i = 0; i < builder.length(); i++) { //проходим по всей строке включая пробелы
            char ch = s.charAt(i); // присваиваем каждому символу строки свой индекс
            if (Character.isUpperCase(ch)) { //если значение ячейчки с этим идексом - Заглавная буква,
                abbrString.append(ch); //то добавляем это значение в итоговую строку
            }
        }
        return abbrString.toString(); //возвращаем нашу итоговую строку в Стринг
    }

    public static void main(String[] args) {
        String s1 = Abbreviation.collect("North Atlantic Treaty Organization");
        System.out.println(s1);
    }
}
