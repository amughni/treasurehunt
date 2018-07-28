package org.test.asim.treasurehunt.main;

import org.test.asim.treasurehunt.instruction.Instruction;
import org.test.asim.treasurehunt.instruction.parser.InstructionsParser;
import org.test.asim.treasurehunt.transportation.Point;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        args = new String[1];

        args[0] = "C:\\Asim\\Instructions.txt";

        if (args.length == 0) {
            System.err.println("No filename provided");

            return;
        }

        String fileName = args[0];
        InstructionsParser parser = new InstructionsParser();
        List<Instruction> instructionList = parser.parseInstructions(fileName);

        if (instructionList == null) {
            System.err.println("Instructions couldn't be parsed. Exiting...");

            return;
        }

        Point startingPoint = new Point(0d, 0d);

        Point currentPosition = new Point(0d, 0d);

        for (Instruction instruction: instructionList) {
            currentPosition = instruction.getMode().move(currentPosition, instruction);
        }

        double distance = Math.hypot(currentPosition.getX() - startingPoint.getX(), currentPosition.getY() - startingPoint.getY());

        String yDirection = "north";
        String xDirection = "east";
        if(currentPosition.getX() < startingPoint.getX())
            xDirection = "west";
        if(currentPosition.getY() < startingPoint.getY())
            yDirection = "south";

        System.out.println(currentPosition.getY() + " miles to the " + yDirection + ", " +
                currentPosition.getX() + " miles to the " + xDirection + ". " +
                distance + " miles away from the starting point!");
    }
}
