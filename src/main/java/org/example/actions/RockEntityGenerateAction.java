package org.example.actions;

import org.example.entity.Entity;
import org.example.entity.fieldobject.Rock;
import org.example.field.FieldOfPlay;

public class RockEntityGenerateAction extends EntityGenerateAction {
    public RockEntityGenerateAction(FieldOfPlay field) {
        super.spawnRate = (field.getHeight() + field.getWidth()) / 2;
    }
    @Override
    Entity createEntity() {
        return new Rock();
    }
}
