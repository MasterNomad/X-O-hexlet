package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(Field field) {

        if (figureCounter(field, Figure.X) == 0) return Figure.X;
        if (figureCounter(field, Figure.X) <= figureCounter(field, Figure.O)) return Figure.X;

        return Figure.O;
    }

    private int figureCounter (Field field, Figure figure) {

        int counter = 0;
        Figure currentFigure;

        try {
            for (int i = 0; i < field.getSize(); i += 1) {
                for (int j = 0; j < field.getSize(); j += 1) {
                    currentFigure = field.getFigure(new Point(i, j));
                    if (currentFigure == figure) counter += 1;
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return counter;

    }

}
