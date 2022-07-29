package ru.alex_life.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.1. Введение в Стримы. FileWriter
 *
 * @author Alex_life
 * @version 1.0
 * @since 29.07.2022
 */
public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n"
                + "Непонятного нет для меня под Луной.\n"
                + "Мне известно, что мне ничего не известно!\n"
                + "Вот последняя правда, открытая мной.\n";
        FileWriter writer = null;
        try {
            //writer = new FileWriter("C:\\Projects\\java_experience\\test\\rubai.txt");
            writer = new FileWriter("./test/rubai2.txt");
            //writer.write(rubai); //можно сразу стринг записать в файл
            //а можно посимвольно пройти и что-то потом с этими символами сделать
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
