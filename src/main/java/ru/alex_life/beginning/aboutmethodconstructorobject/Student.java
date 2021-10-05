package ru.alex_life.beginning.aboutmethodconstructorobject;

/**
 * Видео-курс UDEMY Java для начинающих с нуля.
 * 6. Перегрузка методов и конструкторов (overloading). Ключевое слово this.
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Student {
    int numberStudBilet; //номер студенческого билета
    String name; //имя
    int course; //на каком курсе обучается студент
    double averageMath; //средняя оценка по математике
    double averageEconom; //средняя оценка по экономике
    double averageLanguage; //средняя оценка по ин.язу

}

class StudentUse {
    double averageLessons(Student xxx) { //создаем метод в параметры которого передаем объект Student с переменной xxx
                                       //переменная xxx c типом данных Student
        double sredOzenka
                = (xxx.averageMath        //в методе создаем переменную типом дабл с именем sredOzenka
                + xxx.averageEconom       //и прираниваем ее к значению вычисления средней оценки объекта Student
                + xxx.averageLanguage) / 3; //
        System.out.println("Средняя оценка по всем предметам (успеваемость): "
                + xxx.name + " " + sredOzenka); //выводим в консоль результат работы метода averageLessons
                                                //по заданному шаблону
        return sredOzenka;
    }

    public static void main(String[] args) {
        Student alex = new Student();
        alex.numberStudBilet = 1;
        alex.name = "Alex";
        alex.course = 1;
        alex.averageMath = 9.5;
        alex.averageEconom = 6.8;
        alex.averageLanguage = 8.7;

        Student petr = new Student();
        petr.numberStudBilet = 2;
        petr.name = "Petr";
        petr.course = 1;
        petr.averageMath = 7.5;
        petr.averageEconom = 6.2;
        petr.averageLanguage = 6.9;

        Student lena = new Student();
        lena.numberStudBilet = 1;
        lena.name = "Lena";
        lena.course = 1;
        lena.averageMath = 8.2;
        lena.averageEconom = 5.7;
        lena.averageLanguage = 8.1;

//        System.out.println("Средняя оценка по всем предметам (успеваемость): "
//                + alex.name + " "
//                + (alex.averageMath + alex.averageEconom + alex.averageLanguage)/3);
//        System.out.println("Средняя оценка по всем предметам (успеваемость): "
//                + petr.name + " "
//                + (petr.averageMath + petr.averageEconom + petr.averageLanguage)/3);

        //поменяли вычисление средней оценки и вывод в консоль на отдельный метод

        //чтобы вызвать метод averageLessons надо создать объект класса StudentUse, потому что этот метод
        //принадлежит классу StudentUse.
        StudentUse allStud = new StudentUse(); //создаем новый объект класса StudentUse с именем allStud
        allStud.averageLessons(alex); //каждый раз вызывая этот метод в его параметре указываем разных студентов
        allStud.averageLessons(petr);
        allStud.averageLessons(lena);
    }
}

