package org.test.asim.treasurehunt.main;

import org.test.asim.treasurehunt.instruction.Instruction;
import org.test.asim.treasurehunt.instruction.parser.InstructionsParser;
import org.test.asim.treasurehunt.transportation.Point;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No filename provided");

            return;
        }

        String fileName = args[0];

        List<Instruction> instructionList = InstructionsParser.parseInstructions(fileName);

        if (instructionList == null) {
            System.err.println("Instructions couldn't be parsed. Exiting...");

            return;
        }
        Point startingPoint = new Point(0d, 0d);

        for (Instruction instruction: instructionList) {
            startingPoint = instruction.getMode().travel(startingPoint, instruction);
        }

        Point endingPoint = startingPoint;
    }
}
