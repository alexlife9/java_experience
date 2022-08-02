package ru.alex_life.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.15. Интерфейс Path и класс Files. Часть 2
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.08.2022
 */
public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
//        Path filePath = Paths.get("test10.txt");
//        Path directotyPath = Paths.get("C:\\Projects\\java_experience\\test\\R");
//        Files.copy(filePath, directotyPath.resolve(filePath)); //передаем в параметры метода ЧТО копируем и КУДА копируем
//                                          //и с помощью метода resolve объединяем пути

        //Path filePath2 = Paths.get("C:\\Projects\\java_experience\\test\\R\\test10.txt");
        //System.out.println(Files.exists(filePath2)); //проверяем скопировался ли файл в указанную папку
        //копирование файла происходит с начальными атрибутами без их изменения, даже с тем же именем

        Path filePath3 = Paths.get("test.txt");
        Path directotyPath2 = Paths.get("C:\\Projects\\java_experience\\test\\R");
        //Path directotyPath3 = Paths.get("C:\\Projects\\java_experience\\test\\X");
        //Files.copy(filePath3, directotyPath2.resolve("test50.txt"), StandardCopyOption.REPLACE_EXISTING); //можно указать новое имя, тогда файл запишется с новым именем, но тоже с прежними атрибутами
        //если в директории уже есть файл с таким же именем, то его можно заменить, передав в третий параметр метода resolve - StandardCopyOption.REPLACE_EXISTING

        //Files.copy(directotyPath3, directotyPath2.resolve("X"), StandardCopyOption.REPLACE_EXISTING); //ЧТО копируем, КУДА копируем. с помощью resolve указываем что копируемая папка будет называеться X
        //при этом если папка не пустая, то скопируется только сама папка без ее содержимого

        //Files.move(filePath3, directotyPath2.resolve("test.txt")); //метод move вырезает указанный файл и помещает его в указанную папку с указанным именем
        //Files.move(Paths.get("test77.txt"), Paths.get("test7_7.txt")); //с помощью метода move можно переименовывать файлы и папки. в данном примере получаем существующий файл
                       //по указанному относительноу пути и меняем у него имя на указанное новое во втором параметре метода.
        //!!!!!!!
        // ВСЕ ДЕЙСТВИЯ ЗАКОМЕНТИЛ ПОТОМУ ЧТО ФАЙЛЫ ПЕРЕМЕЩАЮТСЯ / УДАЛЯЮТСЯ ПОСЛЕ ИСПОЛЬЗОВАНИЯ МЕТОДА И ПОВТОРНЫЙ ВЫЗОВ МЕТОДА ВЫБРАСЫВАЕТ ОШИБКУ о том что файл уже не существует
        //!!!!!!!

        //Files.delete(Paths.get("test15.txt")); //метод удаляет существующий указанный файл
        Files.delete(Paths.get("C:\\Projects\\java_experience\\test\\A")); // если папка НЕ пустая то удалить ее на получится. Чтобы удалить непустую папку надо сначала удалить из нее все файлы



    }
}
