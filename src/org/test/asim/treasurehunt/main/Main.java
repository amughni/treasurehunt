package org.test.asim.treasurehunt.main;

import org.test.asim.treasurehunt.instruction.Instruction;
import org.test.asim.treasurehunt.instruction.parser.InstructionsParser;
import org.test.asim.treasurehunt.transportation.Direction;
import org.test.asim.treasurehunt.transportation.Point;

import java.text.DecimalFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        DecimalFormat dec = new DecimalFormat("#0.0");
        double x = Math.abs(currentPosition.getX()) * 2.2369; //converting back mph
        double y = Math.abs(currentPosition.getY()) * 2.2369; //converting back mph

        String yDirection = Direction.NORTH.getFriendlyName();
        String xDirection = Direction.EAST.getFriendlyName();
        if(x < startingPoint.getX())
            xDirection = Direction.WEST.getFriendlyName();
        if(y < startingPoint.getY())
            yDirection = Direction.SOUTH.getFriendlyName();

        System.out.println(dec.format(y) + " miles to the " + yDirection + ", " +
                dec.format(x) + " miles to the " + xDirection + ".");
    }
}
