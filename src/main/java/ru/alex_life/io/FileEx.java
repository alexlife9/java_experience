package ru.alex_life.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.10. Класс File
 *
 * @author Alex_life
 * @version 1.0
 * @since 01.08.2022
 */
public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt"); //относительный путь к файлу
        File folder = new File("C:\\Projects\\java_experience\\test\\A"); //абсолютный путь к папке
        System.out.println("file.getAbsolutePath() : " + file.getAbsolutePath()); //получаем абсолютный путь к файлу
        System.out.println("----------------");

        System.out.println("file.isAbsolute() : " + file.isAbsolute()); //проверяет указан абсолютный путь к файлу или нет
        System.out.println("folder.isAbsolute() : " + folder.isAbsolute()); //проверяет указан абсолютный путь к папке или нет
        System.out.println("----------------");

        System.out.println("file.isDirectory() : " + file.isDirectory()); //проверяет является ли файл директорией (папка это или нет?)
        System.out.println("folder.isDirectory() : " + folder.isDirectory()); //проверяет является ли папка директорией
        System.out.println("----------------");

        File file2 = new File("test99.txt"); //указываем путь к несуществующему файлу
        File folder2 = new File("C:\\Projects\\java_experience\\test\\S"); //и к несуществующей папке
        System.out.println("file.isDirectory() : " + file.exists()); //проверяет существет ли указанный файл
        System.out.println("folder.isDirectory() : " + folder.isDirectory()); //проверяет существет ли указанная папка
        System.out.println("указываем несуществующую : " + file2.exists()); //проверяет существет ли указанный файл
        System.out.println("указываем несуществующую : " + folder2.isDirectory()); //проверяет существет ли указанная папка
        System.out.println("----------------");

        File file3 = new File("test77.txt"); //указываем путь к файлу которого еще нет, но с помощью метода createNewFile будет создан
        File folder3 = new File("C:\\Projects\\java_experience\\test\\W"); //указываем путь к папке которой еще нет, но с помощью метода mkdir будет создана
        System.out.println("file.createNewFile() : " + file3.createNewFile()); //создает новый файл test77.txt и возвращает true/false
        System.out.println("folder.mkdir() : " + folder3.mkdir()); //создает новую папку W и возвращает true/false
                                                                        //false будет в случае если файл/папка уже созданы с заданными именами
        System.out.println("----------------");

        System.out.println("file3.length() : " + file3.length()); //узнаем размер файла в байтах
        System.out.println("folder.length() : " + folder.length()); //узнаем размер папки в байтах. Размер папки тут будет всегда 0.
        System.out.println("----------------");

        File file4 = new File("test55.txt"); //указываем путь к файлу которого еще нет, но с помощью метода createNewFile будет создан
        File folder4 = new File("C:\\Projects\\java_experience\\test\\Z"); //указываем путь к папке которой еще нет, но с помощью метода mkdir будет создана
        System.out.println("file4.createNewFile() : " + file4.createNewFile()); //создали новый файл true/false
        System.out.println("file4.delete() : " + file4.delete()); //и сразу удалили его true/false
        System.out.println("folder4.mkdir() : " + folder4.mkdir()); //создали новую папку true/false
        System.out.println("folder4.delete() : " + folder4.delete()); //и сразу удалили ее и вывели true/false. УДАЛИТЬ МОЖНО ТОЛЬКО ПУСТУЮ ПАПКУ!
        System.out.println("----------------");

        File[] content = folder3.listFiles(); //выводим содержимое папки. метод listFiles возвращает массив элементов типа File.
        System.out.println("метод listFiles : " + Arrays.toString(content)); //выводим содержание записанного массива
        System.out.println("----------------");

        System.out.println("file3.isHidden() : " + file3.isHidden()); //скрытый файл или нет
        System.out.println("file3.canRead() : " + file3.canRead()); //атрибут на чтение стоит или нет
        System.out.println("file3.canWrite() : " + file3.canWrite()); //атрибут на запись стоит или нет
        System.out.println("file3.canExecute() : " + file3.canExecute()); //атрибут на выполнение (запуск) стоит или нет
        System.out.println("----------------");
    }
}
