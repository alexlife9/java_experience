package ru.alex_life.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.2. FileReader
 *
 * @author Alex_life
 * @version 1.0
 * @since 31.07.2022
 */
public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader("./test/rubai2.txt")) {
            int character;
            while ((character = reader.read()) != -1) { //метод read читает файл посимвольно. когда наступит конец файла, возвращаем -1
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
