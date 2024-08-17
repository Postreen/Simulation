package org.example.entity.fieldobject;

import org.example.entity.Entity;

public class Rock extends Entity {
    private String name = "🏔️";
    public Rock(){
        setName("🏔️");
    }

    @Override
    public String toString() {
        return "Rock{" +
                "name='" + name + '\'' +
                '}';
    }
}
