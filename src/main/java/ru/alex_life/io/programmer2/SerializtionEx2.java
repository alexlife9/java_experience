package ru.alex_life.io.programmer2;

import ru.alex_life.io.programmer1.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.7. Сериализация. Часть 1
 *
 * В этом классе принимаем записанный файл содержащий информацию о работнике
 *
 * @author Alex_life
 * @version 1.0
 * @since 06.08.2022
 */
public class SerializtionEx2 {
    public static void main(String[] args) {
        Employee employee;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ivan.bin"))) {
            employee = (Employee) inputStream.readObject();
            System.out.println(employee);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
