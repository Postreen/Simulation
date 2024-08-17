package org.example.actions;

import org.example.entity.Entity;
import org.example.entity.fieldobject.Grass;
import org.example.field.FieldOfPlay;

public class GrassEntityGenerateAction extends EntityGenerateAction {
    public GrassEntityGenerateAction(FieldOfPlay field) {
        super.spawnRate = field.getHeight() + field.getWidth() / 5;
    }
    @Override
    Entity createEntity() {
        return new Grass();
    }
}
