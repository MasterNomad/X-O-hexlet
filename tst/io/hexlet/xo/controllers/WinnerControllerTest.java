package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void DiagonalXTest() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = Figure.X;
        final WinnerController controller = new WinnerController();

        for (int i = 0; i < field.getSize(); i += 1) {
            field.setFigure(new Point(i, i), inputFigure);
        }

        final Figure expectedFigure = inputFigure;

        final Figure actualFigure = controller.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void DiagonalOTest() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = Figure.O;
        final WinnerController controller = new WinnerController();

        for (int i = 0; i < field.getSize(); i += 1) {
            field.setFigure(new Point(i, i), inputFigure);
        }

        final Figure expectedFigure = inputFigure;

        final Figure actualFigure = controller.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void SecondRowsOTest() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = Figure.O;
        final WinnerController controller = new WinnerController();

        for (int i = 0; i < field.getSize(); i += 1) {
            field.setFigure(new Point(i, 1), inputFigure);
        }

        final Figure expectedFigure = inputFigure;

        final Figure actualFigure = controller.getWinner(field);


        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void NoWinnerTest() throws Exception {

        final Field field = new Field(3);
        final Figure inputFigure = null;
        final WinnerController controller = new WinnerController();


        final Figure expectedFigure = inputFigure;

        final Figure actualFigure = controller.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }
}