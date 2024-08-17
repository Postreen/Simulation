package org.example.actions;

import org.example.entity.Entity;
import org.example.entity.fieldobject.Tree;
import org.example.field.FieldOfPlay;

public class TreeEntityGenerateAction extends EntityGenerateAction {
    public TreeEntityGenerateAction(FieldOfPlay field) {
        super.spawnRate = (field.getHeight() + field.getWidth()) / 2;
    }
    @Override
    Entity createEntity() {
        return new Tree();
    }
}
