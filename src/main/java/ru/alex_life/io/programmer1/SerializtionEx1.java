package ru.alex_life.io.programmer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.7. Сериализация. Часть 1
 *
 * В пакете Программер1 создаем класс SerializtionEx1 и записываем в аррэйлист работников
 *
 * @author Alex_life
 * @version 1.0
 * @since 06.08.2022
 */
public class SerializtionEx1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>(); //создаем лист работников
        employees.add("Alex"); //добавляем работников в лист
        employees.add("Olesya");
        employees.add("Roma");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("employees1.bin"))) { //открываем поток с выходным файлом employees1.bin
            outputStream.writeObject(employees); //и записываем в этот файл наш лист работников
            System.out.println("Done!"); //запускаем и убеждаемся что файл физически создался и в него записались все наши работники

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
