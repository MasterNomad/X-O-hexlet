package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinnder(final Field field) {

        try {


            for (int i = 0; i < field.getSize(); i += 1) {

                if (checkLine(field, new Point(i, 0), new IPointChanger() {
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x, p.y + 1);
                    }
                })) {
                    return field.getFigure(new Point(i, 0));
                }
                if (checkLine(field, new Point(0, i), new IPointChanger() {
                    @Override
                    public Point next(Point p) {
                        return new Point(p.x + 1, p.y);
                    }
                })) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (checkLine(field, new Point(0, 0), new IPointChanger() {
                @Override
                public Point next(Point p) {
                    return new Point(p.x + 1, p.y + 1);
                }
            })) {
                return field.getFigure(new Point(0, 0));
            }

            if (checkLine(field, new Point(0, 2), new IPointChanger() {
                @Override
                public Point next(Point p) {
                    return new Point(p.x + 1, p.y - 1);
                }
            })) {
                return field.getFigure(new Point(0, 2));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean checkLine(final Field field,
                              final Point startPoint,
                              final IPointChanger pointChanger
    ) {

        final Point p1 = startPoint;
        final Point p2 = pointChanger.next(p1);
        final Point p3 = pointChanger.next(p2);

        try {
            if (field.getFigure(p1) == null) {
                return false;
            }
            if (field.getFigure(p1) == field.getFigure(p2) &&
                    field.getFigure(p1) == field.getFigure(p3)) {
                return true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return false;

    }

    private interface IPointChanger {

        Point next(final Point p);

    }

}
