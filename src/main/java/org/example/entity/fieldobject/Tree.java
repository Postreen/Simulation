package org.example.entity.fieldobject;

import org.example.entity.Entity;

public class Tree extends Entity {
    private String name = "🌳";
    public Tree(){
        setName("🌳");
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                '}';
    }
}
