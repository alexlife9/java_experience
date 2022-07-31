package ru.alex_life.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.3. Try with resources
 * Позволяет сократить код и автоматически закрывать открытые потоки на ввод и на вывод
 * при объявлении метода запись throws IOException позволяет убрать блок catch (IOException e)
 *
 * @author Alex_life
 * @version 2.0
 * @since 29.07.2022
 */
public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n"
                + "Непонятного нет для меня под Луной.\n"
                + "Мне известно, что мне ничего не известно!\n"
                + "Вот последняя правда, открытая мной.\n";
        try (FileWriter writer = new FileWriter("./test/rubai4.txt")) { //в круглые скобки записываем ресурсы на чтение файла
            //и если надо на запись через точку с запятой.
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            System.out.println("Done!");
        }
    }
}
