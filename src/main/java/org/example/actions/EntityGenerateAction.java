package org.example.actions;

import org.example.field.Cell;
import org.example.entity.Entity;
import org.example.field.FieldOfPlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class EntityGenerateAction<T extends Entity> implements Action {
    public int spawnRate;

    @Override
    public void perform(FieldOfPlay field)  {
        int rate = 0;
        while (rate < spawnRate) {
            Cell cell;
            try {
                cell = getRandomEmptyCell(field);
                field.add(cell, createEntity());
                rate++;
            } catch (IllegalArgumentException e) {
                System.out.println("На карте не хватает места : " + e.getMessage());
                break;
            }
        }
    }

    // Реализация рандомного расположение игровых объектов
    private Cell getRandomEmptyCell(FieldOfPlay field) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if (!field.contains(new Cell(i, j))) {
                    cells.add(new Cell(i, j));
                }
            }
        }
        return cells.get(new Random().nextInt(cells.size()));
    }

    abstract T createEntity();
}
