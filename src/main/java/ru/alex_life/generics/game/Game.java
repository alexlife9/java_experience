package ru.alex_life.generics.game;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.4. Пример на generics
 *
 * Собственно сама игра
 * Тут добавляем участников и играем (вызываем методы взаимодействия)
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Game {
    public static void main(String[] args) {
        //создаем участников:
        Schoolar schoolar1 = new Schoolar("Alex", 10);
        Schoolar schoolar2 = new Schoolar("Petr", 12);

        Student student1 = new Student("Vano", 21);
        Student student2 = new Student("Tyr", 23);

        Employee employee1 = new Employee("Galya", 40);
        Employee employee2 = new Employee("Igor", 50);

        //создаем команды и сразу добавляем в них участников:
        Team<Schoolar> schoolarTeam = new Team("Мелкие");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);
//        schoolarTeam.addNewParticipant(employee1); // !!!чтобы нельзя было добавить взрослых в команду к школьникам,
//                                              //надо использовать дженерик <Schoolar> и в классе Team указать тип Т

        Team<Student> studentTeam = new Team("Средние");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Старые");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        //нам надо чтобы школькники играли со школьниками напрмер, поэтому создаем еще одну команду школьников:
        Team<Schoolar> schoolarTeam2 = new Team("Мелкие2");
        Schoolar schoolar3 = new Schoolar("OP", 13);
        Schoolar schoolar4 = new Schoolar("GO", 11);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);
        //и играем с первой командой школьников:
        schoolarTeam.playWith(schoolarTeam2);
//        schoolarTeam.playWith(studentTeam); //такого быть не должно, поэтому в методе playWith ставим тип Т

    }
}
