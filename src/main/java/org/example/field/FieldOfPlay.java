package org.example.field;

import org.example.entity.Entity;
import org.example.entity.fieldobject.*;

import java.awt.print.Paper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Iгровое поле
 */
public class FieldOfPlay {

    public Map<Cell, Entity> cells;
    private final int WIDTH;
    private final int HEIGHT;

    public FieldOfPlay(int WIDTH, int HEIGHT) {
        cells = new HashMap<>();
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public boolean contains(Cell cell) {
        return cells.containsKey(cell);
    }


    public void add(Cell cell, Entity entity) {
        cells.put(cell, entity);
    }

    public void updateEntity(Cell cell, Entity entity) {
        add(cell, entity);
    }

    public void remove(Cell cell) {
        cells.remove(cell);
    }

    public Entity getEntity(Cell cell) {
        return cells.get(cell);
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public Set<Cell> getCellsEntity() {
        return cells.keySet();
    }
    public Set<Cell> getCellsCreature() {
        Map<Cell, Entity> cellsCreatures = cells;
        boolean isFiltered = false;
        while (isFiltered != true) {
            if (cells.values().contains("🌳")) {
                cells.values().remove("🌳");
            } else if (cells.values().contains("🏔️")) {
                cells.values().remove("🏔️");
            }else if (cells.values().contains("🍀")) {
                cells.values().remove("🍀");
            } else {
                isFiltered = true;
            }
        }
        return cellsCreatures.keySet();
    }

}
