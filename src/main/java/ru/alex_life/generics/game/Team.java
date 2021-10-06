package ru.alex_life.generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Видео-курс Черный пояс.
 * 3. Generics
 * 3.4. Пример на generics
 * <p>
 * Создаем Команду и методы взаимодействия
 * У каждой команды есть имя и список участников
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2021
 */
public class Team<T extends Participant> { //чтобы в команду можно было добавить только наследников Participant
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    //чтобы принимать в команду новых игроков напишем метод:
    public void addNewParticipant(T p) {
        participants.add(p);
        System.out.println("В команду " + name + " добавлен новый участник с именем "
                + p.getName() + " и возрастом " + p.getAge());
    }

    //например играют две команды.
    //выигрывать будет та которой больше повезет - рандом добавляем
    public void playWith(Team<T> team) { //добавив Т, мы говорим что играть можем только с командой которая выбрана в наследниках
        String winnerName; // название победителя
        Random random = new Random();
        int i = random.nextInt(2); //даём два варианта - 0 или 1
        if (i == 0) {
            winnerName = this.name; // это команда которая вызывает на себе этот метод
        } else {
            winnerName = team.name; // это команда с которой мы играем
        }
        System.out.println("Выиграла команда: " + winnerName);
    }

}
