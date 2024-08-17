package org.example.entity.creatures;

import org.example.field.Cell;
import org.example.field.FieldOfPlay;
import org.example.entity.fieldobject.Grass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Herbivore extends Creature {

    public Herbivore(int speed, int hp) {
        this.setName("🐔");
        setSpeed(speed);
        setHp(hp);
    }

    @Override
    public String toString() {
        return "Herbivore{" +
                "name='" + getName() + '\'' +
                ", speed=" + getSpeed() +
                ", hp=" + getHp() +
                '}';
    }

    @Override
    public void makeMove(FieldOfPlay field, Cell cell) {
        //очередь с клетками по мере их обнаружения
        Queue<ArrayList<Cell>> lineOfCellsArray = new LinkedList<>();
        ArrayList<Cell> cellsList = new ArrayList<>();

        //посещенные клетки
        List<Cell> visitedCells = new LinkedList<>();

        findingOfPath(lineOfCellsArray, cellsList, visitedCells, cell, field, Grass.class);

        //получение последнего пути из очереди
        ArrayList<Cell> cells = lineOfCellsArray.stream()
                .reduce((e1, e2) -> e2)
                .orElse(null);

        if (cells != null && !cells.isEmpty()) {
            if (cells.size() == 2) {
                field.updateEntity(cells.get(cells.size() - 1), field.getEntity(cell));
                field.remove(cell);
            } else if (cells.size() - 1 > ((Herbivore) field.getEntity(cell)).getSpeed()) {
                field.add(cells.get(((Herbivore) field.getEntity(cell)).getSpeed() - 1), field.getEntity(cell));
                field.remove(cell);
            } else {
                field.add(cells.get(cells.size() - 1), field.getEntity(cell));
                field.remove(cell);
            }
        }
        //после поедания травы HP увеличивается на +1
        if (getHp() < 9) {
            setHp(getHp() + 1);
        }
    }

}

