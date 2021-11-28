package ru.alex_life.beginning.methodconstructorobjectuse;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 6. Перегрузка методов и конструкторов (overloading). Ключевое слово this.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Employee {
        int id;
        String surname;
        int age;
        double salary;
        String departament;

        //создали свой конструктор - перегрузили дефолтный конструктор
        Employee(int id2, String surname2, int age2, double salary2, String departament2) {
            id = id2;
            surname = surname2;
            age = age2;
            salary = salary2;
            departament = departament2;
        }

    double upSalaryX2(Employee xxx) {
        double uvelichenieZarplaty = xxx.salary * 2;
        System.out.println("Зарплата до увеличения: " + xxx.surname + " " + salary);
        System.out.println("Зарплата после увеличения: " + xxx.surname + " " + uvelichenieZarplaty);
        return uvelichenieZarplaty;
    }
}

class EmployeeUse {
    public static void main(String[] args) {
        Employee em1 = new Employee(1, "Alex", 40, 100.5, "Курс");
        Employee em2 = new Employee(2, "Petr", 30, 10.5, "Курс2");
        em1.upSalaryX2(em1);
        em2.upSalaryX2(em2);
    }
}
