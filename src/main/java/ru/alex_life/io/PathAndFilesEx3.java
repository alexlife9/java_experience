package ru.alex_life.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.15. Интерфейс Path и класс Files. Часть 2
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.08.2022
 */
public class PathAndFilesEx3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test10.txt"); //взяли файл по указанному пути
//        Files.createFile(filePath); //создали указанный файл с указанным именем
//
//        String dialog = "Привет\n-Привет\nКак дела\nНормально"; //создали стринг с неким содержанием
//        Files.write(filePath, dialog.getBytes()); //записали наш стринг в файл
        //закоментировали выше чтобы не выбрасывался эксепшн, потому что файл уже создан и заполнен

        List<String> list = Files.readAllLines(filePath); //читаем все строчки в нашем файле. метод readAllLines читает в List стрингов
        for (String s : list) {
            System.out.println(s);
        }
    }

}
