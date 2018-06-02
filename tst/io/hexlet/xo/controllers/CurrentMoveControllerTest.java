package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void FirstMove() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = Figure.X;
        final CurrentMoveController controller = new CurrentMoveController();

        final Figure expectedFigure = inputFigure;
        final Figure actualFigure = controller.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void xMove() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = Figure.X;
        final Figure secondFigure = Figure.O;
        final CurrentMoveController controller = new CurrentMoveController();

        for (int i = 0; i < field.getSize(); i += 1) {
            field.setFigure(new Point(i, 0), inputFigure);
            field.setFigure(new Point(i, 1), secondFigure);
        }

        final Figure expectedFigure = inputFigure;
        final Figure actualFigure = controller.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void oMove() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = Figure.O;
        final Figure secondFigure = Figure.X;
        final CurrentMoveController controller = new CurrentMoveController();

        for (int i = 0; i < field.getSize() - 1; i += 1) {
            field.setFigure(new Point(i, 0), inputFigure);
        }

        for (int i = 0; i < field.getSize(); i += 1) {
            field.setFigure(new Point(i, 1), secondFigure);
        }


        final Figure expectedFigure = inputFigure;
        final Figure actualFigure = controller.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }
}