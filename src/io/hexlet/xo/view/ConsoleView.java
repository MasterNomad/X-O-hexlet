package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(final Game game) {

        System.out.format("Game name: %s\n", game.getName());

        final Field field = game.getField();

        for (int x = 0; x < field.getSize(); x += 1) {
            if (x != 0) printSeparator();
            printLine(field, x);
        }
        System.out.println();
        System.out.println();

    }


    public boolean move(final Game game) {

        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.format("Winner is %s! Congratulations!\n", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            System.out.println("No winner and no moves");
            return false;
        }

        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);

        } catch (InvalidPointException e) {
            // e.printStackTrace();
            invalidPointMassage("never exists");
        } catch (PointAlreadyOccupiedException e) {
            //e.printStackTrace();
            invalidPointMassage("already occupied");
        }


        return true;
    }

    private void invalidPointMassage(String message) {
        System.out.println();
        System.out.format("Point is %s! TryAgain\n", message);
        System.out.println();
    }

    private Point askPoint() {
        final int x = askCoordinate("X") - 1;
        final int y = askCoordinate("Y") - 1;
        return new Point(y, x);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s coordinate: ", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.format("\nO_o really?\n\n");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field, final int x) {

        System.out.print(" ");

        for (int y = 0; y < field.getSize(); y += 1) {

            final Figure figure;

            try {
                figure = field.getFigure(new Point(x, y));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            if (y != 0) System.out.print(" | ");
            System.out.print(figure != null ? figure : " ");
        }
        System.out.print(" ");
    }

    private void printSeparator() {
        System.out.println();
        System.out.println("-----------");
    }


}
