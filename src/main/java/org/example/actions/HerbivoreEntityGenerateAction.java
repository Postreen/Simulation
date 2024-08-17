package org.example.actions;


import org.example.entity.creatures.Herbivore;
import org.example.field.FieldOfPlay;

public class HerbivoreEntityGenerateAction extends EntityGenerateAction<Herbivore> {
    public HerbivoreEntityGenerateAction(FieldOfPlay field) {
        super.spawnRate = (field.getHeight() + field.getWidth()) / 2;
    }
    @Override
    Herbivore createEntity() {
        return new Herbivore(4,4);
    }
}
