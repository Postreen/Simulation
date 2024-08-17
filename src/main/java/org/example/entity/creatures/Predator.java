package org.example.entity.creatures;

import org.example.entity.Entity;
import org.example.entity.fieldobject.Grass;
import org.example.field.Cell;
import org.example.field.FieldOfPlay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Predator extends Creature {
    private int attack;

    ///bug
    public Predator(int attack, int speed) {
        this.setName("🐯");
        setAttack(attack);
        setSpeed(speed);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "name='" + getName() + '\'' +
                ", attack=" + getAttack() +
                ", speed=" + getSpeed() +
                '}';
    }

    @Override
    public void makeMove(FieldOfPlay field, Cell cell) {
        //очередь с клетками по мере их обнаружения
        Queue<ArrayList<Cell>> lineOfCellsArray = new LinkedList<>();
        ArrayList<Cell> cellLinkedList = new ArrayList<>();

        //посещенные клетки
        List<Cell> visitedCells = new LinkedList<>();

        findingOfPath(lineOfCellsArray, cellLinkedList, visitedCells, cell, field, Herbivore.class);

        //получение последнего пути из очереди
        ArrayList<Cell> cells = lineOfCellsArray.stream()
                .reduce((e1, e2) -> e2)
                .orElse(null);


        // анализируем различные варианты когда хищник может или не может добраться до жертвы и
        // хватает ли ему атаки.
        //если жертва стоит впритык
        if (cells != null && !cells.isEmpty()) {
            if (cells.size() == 2) {
                //убиваем жертву или уменьшаем ХП жертвы
                if (getAttack() >= ((Herbivore) field.getEntity(cells.get(cells.size() - 1))).getHp()) {
                    field.updateEntity(cells.get(cells.size() - 1), field.getEntity(cell));
                    field.remove(cell);
                } else {
                    ((Herbivore) field.getEntity(cells.get(cells.size() - 1))).setHp(((Herbivore) field.
                            getEntity(cells.get(cells.size() - 1))).getHp() - getAttack());
                }
                //хватает скорости дойти до жервы и атаковать
            } else if (cells.size() - 1 - getSpeed() <= 0) {
                if (getAttack() >= ((Herbivore) field.getEntity(cells.get(cells.size() - 1))).getHp()) {
                    field.updateEntity(cells.get(cells.size() - 1), field.getEntity(cell));
                    field.remove(cell);
                } else {
                    field.updateEntity(cells.get(cells.size() - 2), field.getEntity(cell));
                    ((Herbivore) field.getEntity(cells.get(cells.size() - 1))).setHp(((Herbivore) field.
                            getEntity(cells.get(cells.size() - 1))).getHp() - getAttack());
                    field.remove(cell);
                }
                //просто двигаемся к жертве
            } else {
                field.add(cells.get(((Predator) field.getEntity(cell)).getSpeed()), field.getEntity(cell));
                field.remove(cell);
            }
        }
    }

}
