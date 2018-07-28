package org.test.asim.treasurehunt.main;

import org.test.asim.treasurehunt.instruction.Instruction;
import org.test.asim.treasurehunt.instruction.parser.InstructionsParser;
import org.test.asim.treasurehunt.transportation.Point;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        args = new String[1];

        args[0] = "C:\\Users\\sah_r\\Desktop\\Instructions.txt";

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
            currentPosition = instruction.getMode().travel(currentPosition, instruction);
        }

        double distance = Math.hypot(currentPosition.getX() - startingPoint.getX(), currentPosition.getY() - startingPoint.getY());

        System.out.println(currentPosition.getY() + " miles to the north, " + currentPosition.getX() + " miles to the east. " + distance + " miles away from the starting point!");
    }
}
