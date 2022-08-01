package ru.alex_life.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.5. FileInputStream и FileOutputStream
 * Используются для работы с бинарными файлами ("нечитабельны" для человека)
 * Не получится использовать стримы предназначеные для работы с текстовыми файлами при работе с бинарными файломи
 *
 * Класс CopyWithFileStreams выполняет копирование бинарного файла - в частности картинки
 *
 * @author Alex_life
 * @version 1.0
 * @since 01.08.2022
 */
public class CopyWithFileStreams {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("C:\\Projects\\java_experience\\test\\test_jpg.jpg");
             FileOutputStream out = new FileOutputStream("test_jpg.jpg")) { //копируем в корень проекта с таким же названием
            int i;
            while ((i = in.read()) != -1) { //пока есть что читать из файла
                out.write(i);               //сразу записываем прочитанное в новый файл
            }
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
