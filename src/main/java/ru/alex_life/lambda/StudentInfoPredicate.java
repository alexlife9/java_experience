package ru.alex_life.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Видео-курс Черный пояс
 * Predicate
 *
 * @author Alex_life
 * @version 1.0
 * @since 28.10.2022
 */
public class StudentInfoPredicate {
    void testStudents2(ArrayList<Student> al, Predicate<Student> pr) {
        for (Student s : al) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Niko", 'm', 28, 2, 6.4);
        Student student3 = new Student("Elen", 'f', 19, 1, 8.9);
        Student student4 = new Student("Petr", 'm', 35, 4, 7);
        Student student5 = new Student("Mary", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        StudentInfoPredicate info = new StudentInfoPredicate();

        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
        Predicate<Student> p2 = student -> student.sex == 'm';

        info.testStudents2(students, p1);
        info.testStudents2(students, p2);

        //проверки двух условий можно объединять с помощью AND
        info.testStudents2(students, p1.and(p2));

        //проверку условий можно проводить с помощью OR
        info.testStudents2(students, p1.or(p2));

        //можно инвертировать результаты проверки отрицанием
        info.testStudents2(students, p1.negate()); //выведет все элементы НЕ удовлетворяющие условию
    }
}


