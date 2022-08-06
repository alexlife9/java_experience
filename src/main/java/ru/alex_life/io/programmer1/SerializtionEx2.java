package ru.alex_life.io.programmer1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.7. Сериализация. Часть 2
 *
 * @author Alex_life
 * @version 2.0
 * @since 06.08.2022
 */
public class SerializtionEx2 {
    public static void main(String[] args) {
        Employee employee = new Employee("Ivan",
                "Ivanov",
                "IT",
                //33,
                200);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ivan.bin"))) {
            outputStream.writeObject(employee);
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
