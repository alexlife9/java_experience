package ru.alex_life.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

/**
 * Видео-курс Черный пояс.
 * 9. Работа с файлами IO и NIO
 * 9.16. Введение в метод walkFileTree
 *
 * Метод Files.walkFileTree(Path start, FileVisitor visitor) используется для обхода дерева файлов
 * Метод принимает в параметры Путь откуда начнется обход и логику обхода
 * Логика обхода заключается в классе имплементирующем интерфейс FileVisitor
 * Она содержит 4 метода:
 * 1.preVisitDirectory - срабатывает ПЕРЕД обращением к элементам папки
 * 2.visitFile - срабатывает при обращении к файлу
 * 3.visitFileFailed - срабатывает когда файла по каким-то причинам недоступен
 * 4.postVisitDirectory - срабатывает ПОСЛЕ обращеня ко всем элементам папки
 *
 * Чтобы не переопределять все 4 метода, когда нам допустим нужен только 1 метод, существует класс SimpleFileVisitor,
 * который имплементирует FileVisitor.
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.08.2022
 */
public class FileTree {

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("C:\\Projects\\java_experience\\test2"); //указываем папку для обхода
        Files.walkFileTree(filePath, new MyFileVisitor()); //запускаем прогулку - в старт нашу папку,
        // в логику - новый объект класса MyFileVisitor с нашими реализованными методами
    }
}

class MyFileVisitor implements FileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("осуществляем вход в эту папку :" + dir); //после захода в этот метод и выполнения его кода,
        // есть 4 варианта что делать дальше:
        //1.CONTINUE - продолжаем обход по файлам
        //2.TERMINATE - немедленно прекращаем обход по файлам
        //3.SKIP_SUBTREE - в данную директорию заходить не надо
        //4.SKIP_SIBLINGS - в данной директории продолжать обход по файлам не нужно
        return CONTINUE; // продолжаем работу дальше
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("найденный файл называется: " + file.getFileName()); //выводим инфу в консоль
        return CONTINUE; //и продолжаем работу дальше
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("ошибка с данным файлом: " + file.getFileName());
        return TERMINATE; //если нашли ошибку с файлом, то заканчиваем гулять по дереву
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("выходим после обхода из директории: " + dir); //выводим инфу в консоль
        return CONTINUE; //и продолжаем работу
    }
}
