package ru.alex_life.io.programmer2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.7. Сериализация. Часть 1
 *
 * В пакете Программер2 создаем такой же класс SerializtionEx1
 * Но другой программист должен принять наш файл, прочитать его и вывести наших работников
 *
 * @author Alex_life
 * @version 1.0
 * @since 06.08.2022
 */
public class SerializtionEx1 {
    public static void main(String[] args) {
        List<String> employees; //создаем переменную в которую будем записывать прочитанных из входящего файла работников
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("employees1.bin"))) { //указываем путь к файлу который создал первый программист
            employees = (List<String>) inputStream.readObject(); //делаем кастинг входящего файла к листу стрингов из аррейлиста
            System.out.println(employees); //выводим в консоль список и убеждаемся что бинарный файл проситался верно

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
