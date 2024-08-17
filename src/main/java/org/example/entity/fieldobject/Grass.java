package org.example.entity.fieldobject;

import org.example.entity.Entity;

public class Grass extends Entity {

    public Grass(){
        setName("🍀");
    }

    @Override
    public String toString() {
        return getName();
    }
}
