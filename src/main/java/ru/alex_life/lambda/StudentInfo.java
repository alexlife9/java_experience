package ru.alex_life.lambda;

import java.util.ArrayList;

/**
 * Видео-курс Черный пояс
 * Lambda выражения
 *
 * @author Alex_life
 * @version 1.0
 * @since 25.10.2022
 */

class StudentInfoTest {
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

        StudentInfo info = new StudentInfo();
        info.printStudentOverGrade(students, 8);
        System.out.println("=====");
        info.printStudentUnderAge(students, 30);
        System.out.println("=====");
        info.printStudentMixCondition(students, 20, 9.5, 'f');
        System.out.println("=====");

        /* проверяем с помощью класса CheckStudentOverGrade */
        info.testStudents(students, new CheckStudentOverGrade());
        System.out.println("=====");

        /* проверяем с помощью АНОНИМНОГО класса
         * анонимный класс нужен чтобы не создавать классы имплементирующие интерфейсы */
        info.testStudents(students, new StudentCheck() {
            @Override
            public boolean check(Student s) {
                return s.age < 30; // и тут пишем любую проверку, которую хотим
            }
        });
        System.out.println("=====");

        /* проверяем с помощью лямбда-выражения
         * во второй параметр сразу вставляем главную часть анонимного класса
         * по сути в качестве второго параметра используется метод, в который передаем необходимую логику */
        info.testStudents(students, (Student s) -> {return s.age < 30;}); //это выражение можно сократить и
        info.testStudents(students, s -> s.age < 30); //записать так
        System.out.println("=====");

        info.testStudents(students, (Student s) -> {
            return s.age > 20 && s.avgGrade < 9.5 && s.sex == 'f';
        });

        /* еще один вариант написания лямбд, когда переменной присваивается ЛВ */
        StudentCheck sc = (Student p) -> {return p.avgGrade > 8;};
        info.testStudents(students, sc);
    }
}

public class StudentInfo {
    void printStudentOverGrade(ArrayList<Student> al, double grade) {
        for (Student s : al) {
            if (s.avgGrade > grade) {
                System.out.println(s);
            }
        }
    }

    void printStudentUnderAge(ArrayList<Student> al, int age) {
        for (Student s : al) {
            if (s.age < age) {
                System.out.println(s);
            }
        }
    }

    void printStudentMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
        for (Student s : al) {
            if (s.age > age && s.avgGrade < grade && s.sex == sex) {
                System.out.println(s);
            }
        }
    }

    /* если необходима еще фильтрация, но нужно будет создавать еще новые методы в классе StudentInfo
     * это не всегда удобно, особенно когда к этому классу нет прямого доступа.
     *
     * Для решения этой проблемы можно использовать имплементацию, анонимные классы или лямбда-выражения.
     * Для этого, создадим интерфейс StudentCheck который содержит некий общий метод check, принимающий студентов
     *
     * и в классе StudentInfo достаточно написать всего лишь одну реализацию этого интерфейса */

    void testStudents(ArrayList<Student> list, StudentCheck ch) { //в качестве второго параметра метод принимает любую фильтрацию
        for (Student s : list) { //проходим по всему списку Студентов
            if (ch.check(s)) { // если фильтр проверяет Студента и возвращает true, то выводим этого студента в консоль
                System.out.println(s);
            }
        }
    }

    /* теперь, чтобы проверить какое-либо условие, нужно создать еще один класс, например CheckStudentOverGrade */
}

class CheckStudentOverGrade implements StudentCheck {
    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8; //тут прописываем строгую реализацию того что хотим проверить
        // и это не очень хороший подход, потому что если надо проверить не 8, а 9, надо будет создавать еще один класс
        // поэтому лучше использовать АНОНИМНЫЙ класс
    }
}

/* это функциональный интерфейс - он содержит всего ОДИН абстрактный метод
 * лямбды работают только с ФИ - только с ОДНИМ его методом
 * чтобы каждый раз не создавать интерфейсы надо использовать Predicate - смотри StudentInfoPredicate */
interface StudentCheck {
    boolean check(Student s);
}
