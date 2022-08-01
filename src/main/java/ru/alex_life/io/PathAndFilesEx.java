package ru.alex_life.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.14. Интерфейс Path и класс Files. Часть 1
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.08.2022
 */
public class PathAndFilesEx {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directotyPath = Paths.get("C:\\Projects\\java_experience\\test\\R");
        System.out.println(filePath.getFileName());
        System.out.println(directotyPath.getFileName());
        System.out.println("--------------");

        System.out.println("filePath.getParent() : " + filePath.getParent()); //показавает родителя в абсолютном пути. В относительном будет null
        System.out.println("directotyPath.getParent() : " + directotyPath.getParent()); //показавает родителя в абсолютном пути
        System.out.println("--------------");

        System.out.println("filePath.getRoot() : " + filePath.getRoot()); //показавает корневую папку в абсолютном пути. В относительном будет null
        System.out.println("directotyPath.getRoot() : " + directotyPath.getRoot()); //показавает корневую папку в абсолютном пути
        System.out.println("--------------");

        System.out.println("filePath.isAbsolute() : " + filePath.isAbsolute()); //показавает абсолютный или нет путь у файла
        System.out.println("filePath.toAbsolutePath() : " + filePath.toAbsolutePath()); //показавает абсолютный путь к файлу у которого изначльно он не задан
        System.out.println("directotyPath.isAbsolute() : " + directotyPath.isAbsolute()); //показавает абсолютный или нет путь у папки
        System.out.println("--------------");

        System.out.println("filePath.toAbsolutePath().getParent() : " + filePath.toAbsolutePath().getParent()); //показываем сначала абсолютный путь у файла и сразу узнаем его родительскую папку
        System.out.println("filePath.toAbsolutePath().getRoot() : " + filePath.toAbsolutePath().getRoot()); //аналогично можем узнать корневую папку
        System.out.println("--------------");

        System.out.println("directotyPath.resolve(filePath) : " + directotyPath.resolve(filePath)); //объединяет два пути в один. ТОЛЬКО ПУТИ! сам файл filePath не перемещается в папку directotyPath
        System.out.println("--------------");

        Path directotyPath2 = Paths.get("C:\\Projects\\java_experience\\test\\R\\Other\\test20.txt");
        System.out.println(directotyPath.relativize(directotyPath2)); //узнаем относительный путь файла по отношению к указанной папке
        System.out.println("--------------");

        if (!Files.exists(filePath)) { //проверяем, если по указанному пути файл не существует,
            Files.createFile(filePath); //то создаем его
        }
        if (!Files.exists(directotyPath)) { //проверяем, если по указанному пути папка не существует,
            Files.createDirectory(directotyPath); //то создаем ее
        }

        //проверяем атрибуты файла
        System.out.println(Files.isReadable(filePath)); //на чтение
        System.out.println(Files.isWritable(filePath)); //на запись
        System.out.println(Files.isExecutable(filePath)); //на исполнение
        System.out.println(Files.isHidden(filePath)); //скрытый или нет. true если скрытый
        System.out.println("--------------");

        Path filePath2 = Paths.get("C:\\Projects\\java_experience\\test\\W\\test.txt");
        System.out.println("Files.isSameFile(filePath, filePath2) : " + Files.isSameFile(filePath, filePath2)); //ссылаются ли оба пути на один и тот же файл
        System.out.println("--------------");

        System.out.println("Files.size(filePath2) : " + Files.size(filePath2)); //узнаем размер указанного файла в байтах
        System.out.println("--------------");

        System.out.println("Files.getAttribute(filePath2, \"creationTime\") : " + Files.getAttribute(filePath2, "creationTime")); //можно узнать конкретный атрибут указанного файла, например когда был создан файл
        System.out.println("--------------");

        Map<String, Object> getAtr = Files.readAttributes(filePath2, "*"); //знак * позволяет узнать о всех атрибутах файла. метод возвращает Map девяти основных атрибутов
        for (Map.Entry<String, Object> entry : getAtr.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
