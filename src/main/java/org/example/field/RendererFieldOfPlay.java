package org.example.field;

import org.example.entity.creatures.Herbivore;
import org.example.entity.creatures.Predator;

public class RendererFieldOfPlay {
    private static final String ANSI_GREY_COLOR_SPACE = "▪️";

    public static void showMap(FieldOfPlay field) {
        System.out.print("X\\Y |");
        for (int i = 0; i < field.getHeight(); i++) {
            System.out.print("Y" + ANSI_GREY_COLOR_SPACE + i + "|");
        }
        System.out.println();
        for (int i = 0; i < field.getHeight(); i++) {
            System.out.print("X " + i + " |");
            for (int j = 0; j < field.getWidth(); j++) {

                if (field.contains(new Cell(i, j))) {
                    if (field.getEntity(new Cell(i, j)).getClass().equals(Herbivore.class)) {
                        System.out.print(field.getEntity(new Cell(i, j)).getHp() + field.getEntity(new Cell(i, j)).getName() + " |");
                    }
                    else System.out.print(" " + field.getEntity(new Cell(i, j)).getName() + " |");
                } else {
                    System.out.print(" " + ANSI_GREY_COLOR_SPACE + " |");
                }

            }
            System.out.println();
        }
        System.out.println("__________________________________________________________");
    }
}
