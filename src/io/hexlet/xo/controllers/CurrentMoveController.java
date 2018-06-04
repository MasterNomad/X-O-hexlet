package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(Field field) {

        final int count = figureCounter(field);

        if (count == field.getSize() * field.getSize()) return null;
        if (count % 2 == 0) return Figure.X;

        return Figure.O;
    }

    private int figureCounter (Field field) {

        int counter = 0;

        try {
            for (int i = 0; i < field.getSize(); i += 1) {
                for (int j = 0; j < field.getSize(); j += 1) {
                    if (field.getFigure(new Point(i, j)) != null) counter += 1;
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return counter;

    }

}
