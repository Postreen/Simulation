package org.example;

import org.example.actions.*;
import org.example.entity.Entity;
import org.example.field.Cell;
import org.example.field.FieldOfPlay;
import org.example.field.RendererFieldOfPlay;

import java.util.*;

public class Simulation {
    FieldOfPlay field = new FieldOfPlay(10, 10);


    public void gameLoop() {
        List<EntityGenerateAction> initActions = new ArrayList<>();
        List<MoveCreatureAction> turnActions = new ArrayList<>();

        int userEnteredLetter = -1;

        createActions(field, initActions);

        while (userEnteredLetter != 0) {
            displayGameMessages();

            RendererFieldOfPlay.showMap(field);

            Scanner scanner = new Scanner(System.in);
            userEnteredLetter = scanner.nextInt();

            if (userEnteredLetter == 1) {
                makeTurnActions(field, turnActions);
            } else if (userEnteredLetter == 2) {
                while (true) {
                    makeTurnActions(field, turnActions);
//                    for (MoveCreatureAction el : turnActions) {
//                        el.perform(field);
//                    }
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
    public void createActions(FieldOfPlay field, List<EntityGenerateAction> initActions) {
        initActions.add(new GrassEntityGenerateAction(field));
        initActions.add(new RockEntityGenerateAction(field));
        initActions.add(new TreeEntityGenerateAction(field));
        initActions.add(new PredatorEntityGenerateAction(field));
        initActions.add(new HerbivoreEntityGenerateAction(field));
        for (EntityGenerateAction el : initActions) {
            el.spawnEntity(field);
        }
    }
    public void makeTurnActions(FieldOfPlay field, List<MoveCreatureAction> turnActions){
        turnActions.add(new MoveCreatureAction());
        Set<Cell> cellSet = new HashSet<>(field.getCellsCreature());
        for (MoveCreatureAction el : turnActions) {
            el.perform(field, cellSet);
        }
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
