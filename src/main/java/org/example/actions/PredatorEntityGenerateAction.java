package org.example.actions;

import org.example.entity.Entity;
import org.example.entity.creatures.Predator;
import org.example.field.FieldOfPlay;

public class PredatorEntityGenerateAction extends EntityGenerateAction {
    public PredatorEntityGenerateAction(FieldOfPlay field) {
        super.spawnRate = (field.getHeight() + field.getWidth()) / 4;
    }
    @Override
    Entity createEntity() {
        return new Predator(10,5);
    }
}
