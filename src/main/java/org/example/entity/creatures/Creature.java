package org.example.entity.creatures;

import org.example.field.Cell;
import org.example.field.FieldOfPlay;
import org.example.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Все существа
*/

public abstract class Creature extends Entity {
    private int hp;
    private int speed;

    public void findingOfPath(Queue<ArrayList<Cell>> lineOfCellsArray, ArrayList<Cell> cellsList, List<Cell> visitedCells,
                         Cell cell, FieldOfPlay field, Class T) {
        boolean flagExit = false;

        cellsList.add(cell);
        lineOfCellsArray.add(cellsList);
        while (!lineOfCellsArray.isEmpty()) {

            List<Cell> listFromQueue = lineOfCellsArray.poll();
            Cell cellFromQueue = listFromQueue.get(listFromQueue.size() - 1);
            visitedCells.add(cellFromQueue);
            int x = cellFromQueue.getX();
            int y = cellFromQueue.getY();

            // анализируем ячейки сверху/снизу/с лева/с права
            // если ячейка пустая, то добавляем её в очередь, если в ячейке Травоядное, то добавляем её в очередь и
            // заканчиваем цикл поиска
            // Другие ячейки не анализируются (камни, деревья, иные хищники)
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    Cell el = new Cell(x + i, y + j);
                    if (!visitedCells.contains(el)) {
                        if (field.getWidth() > x + i && x + i >= 0 && field.getHeight() > y + j && y + j >= 0 && Math.abs(i) != Math.abs(j)) {
                            if (!field.contains(el)) {
                                ArrayList<Cell> buf = new ArrayList<>(listFromQueue);
                                buf.add(el);
                                lineOfCellsArray.add(buf);
                            } else if (field.getEntity(el).getClass() == T) {
                                ArrayList<Cell> buf = new ArrayList<>(listFromQueue);
                                buf.add(el);
                                lineOfCellsArray.add(buf);
                                flagExit = true;
                                break;
                            }
                        }
                    }
                }
                if (flagExit) {
                    break;
                }
            }
            if (flagExit) {
                break;
            }
        }
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public abstract void makeMove(FieldOfPlay map, Cell cell);

}
