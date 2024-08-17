package org.example;

import org.example.actions.*;
import org.example.field.FieldOfPlay;
import org.example.field.RendererFieldOfPlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    FieldOfPlay field = new FieldOfPlay(10, 10);


    public void gameLoop() {
        List<Action> initActions = new ArrayList<>();
        List<Action> turnActions = new ArrayList<>();

        int userEnteredLetter = -1;

        createActions(field, initActions);

        while (userEnteredLetter != 0) {
            displayGameMessages();

            RendererFieldOfPlay.showMap(field);

            Scanner scanner = new Scanner(System.in);
            userEnteredLetter = scanner.nextInt();

            if (userEnteredLetter == 1) {
                makeTurnActions(field, turnActions);
                for (Action el : turnActions) {
                    el.perform(field);
                }
            } else if (userEnteredLetter == 2) {
                while (true) {
                    makeTurnActions(field, turnActions);
                    for (Action el : turnActions) {
                        el.perform(field);
                    }
                }
            } else if (userEnteredLetter == 3) {
                field = new FieldOfPlay(10, 10);
                initActions.removeAll(initActions);
                createActions(field, initActions);

            } else if (userEnteredLetter != 0){
                System.out.println("Выберите корректный пункт меню");
                displayGameMessages();
            }
        }

    }
    public void createActions(FieldOfPlay field, List<Action> initActions) {
        initActions.add(new GrassEntityGenerateAction(field));
        initActions.add(new RockEntityGenerateAction(field));
        initActions.add(new TreeEntityGenerateAction(field));
        initActions.add(new HerbivoreEntityGenerateAction(field));
        initActions.add(new PredatorEntityGenerateAction(field));
        for (Action el : initActions) {
            el.perform(field);
        }
    }
    public void makeTurnActions(FieldOfPlay field, List<Action> turnActions){
        turnActions.add(new MoveCreatureAction());
        turnActions.add(new GrassEntityGenerateAction(field));
    }

    public void displayGameMessages() {
        System.out.println("======================Меню симуляции======================");
        System.out.println("1 - Симулировать игровой Мир сделать один ход");
        System.out.println("2 - Запустить бесконечную симуляцию игрового Мира ");
        System.out.println("3 - Начать игру с начала");
        System.out.println("0 - Закончить  игры");
        System.out.println("==========================================================");
    }
}
