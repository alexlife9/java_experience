package ru.alex_life.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Видео-курс Черный пояс
 * Многопоточность
 * Синхронизатор Exchanger
 * Это синхронизатор, позволяющий обмениваться данными между двумя потоками.
 * Обеспечивает одновременное получение информации друг от друга двумя потоками.
 *
 * Рассмотрим на примере игры "камень, ножницы, бумага"
 *
 * @author Alex_life
 * @version 1.0
 * @since 05.10.2022
 */
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> players1Action = new ArrayList<>();
        players1Action.add(Action.SCISSORS);
        players1Action.add(Action.PAPER);
        players1Action.add(Action.SCISSORS);

        List<Action> players2Action = new ArrayList<>();
        players2Action.add(Action.PAPER);
        players2Action.add(Action.STONE);
        players2Action.add(Action.STONE);

        new Players("name1", players1Action, exchanger);
        new Players("name2", players2Action, exchanger);

    }
}

enum Action {
    STONE, SCISSORS, PAPER
}

class Players extends Thread {
    private final String name;
    private final List<Action> myAction;
    private final Exchanger<Action> exchanger;

    public Players(String name, List<Action> myAction, Exchanger<Action> exchanger) {
        this.name = name;
        this.myAction = myAction;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action otherAction) {
        if ((myAction == Action.STONE && otherAction == Action.SCISSORS)
            || (myAction == Action.SCISSORS && otherAction == Action.PAPER)
            || (myAction == Action.PAPER && otherAction == Action.STONE)) {
            System.out.println(name + " WINS");
        }
    }

    public void run() {
        Action reply;
        for (Action action : myAction) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}