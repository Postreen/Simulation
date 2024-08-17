package org.example;

import org.example.actions.*;
import org.example.field.FieldOfPlay;

import java.util.List;

public class TurnAction {
    List<Action> turnActions;
    public TurnAction(FieldOfPlay field){
        turnActions.add(new MoveCreatureAction());
        turnActions.add(new GrassEntityGenerateAction(field));
        turnActions.add(new PredatorEntityGenerateAction(field));
        turnActions.add(new HerbivoreEntityGenerateAction(field));
    }

}
