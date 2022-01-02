package ru.alex_life.arrays;

/**
 * Видео-курс UDEMY Java для начинающих
 * 19. Цикл foreach
 *
 * Вывести всех студентов, сдающие все экзамены
 *
 * @author Alex_life
 * @version 1.0
 * @since 02.01.2022
 */
public class StudentsExam {
    public static void main(String[] args) {
        String[] stud = {"Ivan", "Petr", "Alex"};
        String[] exam = {"mat", "lang", "botan"};
        for (String a : stud) {
            for (String b : exam) {
                System.out.println(a + " " + b);
            }
        }
    }
}
