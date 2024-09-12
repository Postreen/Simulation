package org.example.actions;

import org.example.entity.creatures.Herbivore;
import org.example.entity.creatures.Predator;
import org.example.field.Cell;
import org.example.entity.Entity;
import org.example.field.FieldOfPlay;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class EntityGenerateAction<T extends Entity> {
    public int spawnRate;

    public void spawnEntity(FieldOfPlay field) {

        checkForEntity(field);

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

    private static int checkForEntity(FieldOfPlay field) {

        Collection<Entity> list = field.cells.values();
        System.out.println(list.size());
        System.out.println("f");
        int rate = 0;

        return rate;
    }

    abstract T createEntity();
}
