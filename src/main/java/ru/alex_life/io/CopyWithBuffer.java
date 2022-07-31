package ru.alex_life.io;

import java.io.*;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.4. BufferedWriter и BufferedReader
 *
 * Буфер нужен чтобы как можно меньше обращаться к ресурсу, потому что такая задача довольно трудоемкая.
 * Нужер для бОльшей производительности и бОльшего удобства.
 * метод read считывает посимвольно
 * метод readLine считывает целые строки
 *
 * @author Alex_life
 * @version 1.0
 * @since 31.07.2022
 */
public class CopyWithBuffer {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader("./test/rubai2.txt")); //из этого файла читаем
             BufferedWriter out = new BufferedWriter(new FileWriter("./test/test.txt"))) { //этот файл сам создастся
            int character;
            while ((character = in.read()) != -1) {
                out.write(character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader("./test/rubai2.txt")); //из этого файла читаем
             BufferedWriter out = new BufferedWriter(new FileWriter("./test/test2.txt"))) { //этот файл сам создастся
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.write('\n'); //добавили переход на новую строчку
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
