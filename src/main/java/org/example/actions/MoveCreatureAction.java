package org.example.actions;

import org.example.field.Cell;
import org.example.entity.creatures.Herbivore;
import org.example.entity.creatures.Predator;
import org.example.field.FieldOfPlay;
import org.example.field.RendererFieldOfPlay;

import java.util.HashSet;
import java.util.Set;


public class MoveCreatureAction {
    private int moveCounter = 1;
    /**
     * Метод для выполнения хода всех существ в порядке очереди
     */

    public void perform(FieldOfPlay field, Set<Cell> cellSet) {

        int i = 0;
        for (Cell cellEntity : cellSet) {
            if (field.getEntity(cellEntity).getClass().equals(Predator.class)) {
                Predator pre = (Predator) field.getEntity(cellEntity);
                pre.makeMove(field, cellEntity);

                System.out.println("Хищник " + cellEntity.toString() + " делает ход");
                RendererFieldOfPlay.showMap(field);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                i++;
            } else if (field.getEntity(cellEntity).getClass().equals(Herbivore.class)) {
                Herbivore herbivore = (Herbivore) field.getEntity(cellEntity);
                herbivore.makeMove(field, cellEntity);

                System.out.println("Травоядный " + cellEntity.toString() + " делает ход");
                RendererFieldOfPlay.showMap(field);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                i++;
            }
            System.out.println(i);
        }
        System.out.println("Ход №" + this.moveCounter + " выполнен");
        System.out.println("Добавление новых сущностей на карту");
        this.moveCounter++;
    }
}
