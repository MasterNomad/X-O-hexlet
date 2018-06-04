package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class ConsoleView {

    public void show(final Game game) {

        System.out.format("Game name: %s\n", game.getName());

        final Field field = game.getField();

        for (int x = 0; x < field.getSize(); x += 1) {
            printeLine(field, x);
            if (x != field.getSize() - 1) printSeparator();
        }

    }


    public void move(final Game game) {


    }

    private void printeLine(final Field field, final int x) {

        for (int y = 0; y < field.getSize(); y += 1) {

            final Figure figure;

            try {
                figure = field.getFigure(new Point(x, y));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            if (y != field.getSize() - 1) System.out.print("|");
        }
    }

    private void printSeparator() {
        System.out.println();
        System.out.println("------");
    }


}
