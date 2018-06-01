package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinnder(final Field field) {

        try {


            for (int i = 0; i < field.getSize(); i += 1) {

                if (checkLine(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
                if (checkLine(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (checkLine(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }

            if (checkLine(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1))) {
                return field.getFigure(new Point(0, 2));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean checkLine(final Field field,
                              final Point currentPoint,
                              final IPointChanger pointChanger) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointChanger.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) {
            return false;
        }

        if (currentFigure != nextFigure) {
            return false;
        }

        return checkLine(field, nextPoint, pointChanger);

    }

    private interface IPointChanger {

        Point next(final Point p);

    }

}
