package ru.alex_life.beginning.oop;

/**
 *  Видео-курс UDEMY Java для начинающих
 *  22. Наследование
 *  Преимущества:
 *  -более короткое написание кода
 *  -легкость в изменении/добавлении общих элементов
 *  -extensibility
 *  -более легкое тестирование классов
 *  -группировка классов под общим типом
 *
 * @author Alex_life
 * @version 1.0
 * @since 03.07.2022
 */
public class Inheritance {
    public static void main(String[] args) {
        Doctor doc = new Doctor();
        doc.name = "Ivan";
        doc.age = 24;
        doc.specialty = "okulist";

    }
}

    class  Emploee { //объединяет общие признаки всех работников - доктора, учителя и водителя. Укорачивает код
        String name;
        int age;
        int experience;
        void eat() {
            System.out.println("кушает");
        }
        void sleep() {
            System.out.println("спит");
        }
    }
    class Doctor extends Emploee {
        //String name; //убираем из дочерних классов все признаки которые есть в родительском классе
        //int age;
        //int experience;
        String specialty;
        //void eat() {System.out.println("кушает");}
        //void sleep() {System.out.println("спит");}
        void heals() {
            System.out.println("лечит");
        }
    }

    class Teacher extends Emploee {
        //String name; //убираем из дочерних классов все признаки которые есть в родительском классе
        //int age;
        //int experience;
        int quantityOfPupils;
        //void eat() {System.out.println("кушает");}
        //void sleep() {System.out.println("спит");}
        void teaches() {
            System.out.println("учит");
        }
    }

    class Driver extends Emploee {
        //String name; //убираем из дочерних классов все признаки которые есть в родительском классе
        //int age;
        //int experience;
        String carBrand;
        //void eat() {System.out.println("кушает");}
        //void sleep() {System.out.println("спит");}
        void drives() {
            System.out.println("водит");
        }
    }
