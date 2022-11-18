package ru.alex_life.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Видео-курс Черный пояс
 * Function
 * Этот интерфейс применяется когда надо на вход принимать один тип параметра, а возвращать другой тип.
 *
 * @author Alex_life
 * @version 1.0
 * @since 29.10.2022
 */
public class StudentInfoFunction {
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

        double result = avgAnyElem(students, stud -> stud.avgGrade);
        System.out.println(result);

        double result2 = avgAnyElem(students, stud -> (double) stud.course);
        System.out.println(result2);

        double result3 = avgAnyElem(students, stud -> (double) stud.age);
        System.out.println(result3);
    }
    private static double avgAnyElem(List<Student> list, Function<Student, Double> f) {
        double rsl = 0;
        for (Student st : list) {
            rsl += f.apply(st);
        }
        rsl = rsl / list.size();
        return rsl;
    }

}
