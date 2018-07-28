package org.test.asim.treasurehunt.instruction.parser;

import org.test.asim.treasurehunt.instruction.Instruction;
import org.test.asim.treasurehunt.transportation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class InstructionsParser {
    public List<Instruction> parseInstructions(String fileName) {
        List<Instruction> instructionList = null;

        File instructionsFile = verifyAndGetFile(fileName);

        if (instructionsFile != null) {
            try {
                instructionList = new ArrayList<>();

                Scanner lineScanner = new Scanner(instructionsFile);

                while (lineScanner.hasNextLine()) {
                    Scanner instructionScanner = new Scanner(lineScanner.nextLine());
                    instructionScanner.useDelimiter(",");

                    String strMode = instructionScanner.next().trim();

                    Mode mode = parseMode(strMode);

                    String strDuration = instructionScanner.next().trim();

                    long durationMillis = parseDuration(strDuration);

                    String strDirection = instructionScanner.next().trim();

                    Direction direction = parseDirection(strDirection);

                    instructionList.add(new Instruction(mode, durationMillis, direction));

                }

                return instructionList;
            } catch (FileNotFoundException fnfe) {
                System.err.println("File was not found on the provided path");

                return null;
            }
        }

        return null;
    }

    private Direction parseDirection(String strDirection) {
        return Direction.getDirectionByCode(strDirection);
    }

    /**
     *This method normalize the duration string so that any variations may be parsed
     * TODO: Add replacall for days, weeks, months, years, etc.
     */
    private String normalizeDuration(String strDuration) {
        //normalize hours
        strDuration = strDuration.replaceAll
                ("hours", "h").replaceAll
                ("hr", "h").replaceAll
                ("hrs", "h").replaceAll
                ("hour", "h");
        //normalize mins
        strDuration = strDuration.replaceAll
                ("minutes", "m").replaceAll
                ("minute", "m").replaceAll
                ("mins", "m").replaceAll
                ("min", "m");

        //normalize secs
        strDuration = strDuration.replaceAll
                ("seconds", "s").replaceAll
                ("second", "s").replaceAll
                ("secs", "s").replaceAll
                ("sec", "s");

        return strDuration;
    }

    private long parseDuration(String strDuration) {
        strDuration = normalizeDuration(strDuration);

        long duration = 0;

        String [] parts = strDuration.split("[ \\t]+");

        if (parts.length % 2 == 0) {
            for (int i = 0; i < parts.length; i += 2) {
                if ("h".equals(parts[i + 1])) {
                    duration += TimeUnit.HOURS.toMillis(Integer.parseInt(parts[i]));
                } else if ("m".equals(parts[i + 1])) {
                    duration += TimeUnit.MINUTES.toMillis(Integer.parseInt(parts[i]));
                } else if ("s".equals(parts[i + 1])) {
                    duration += TimeUnit.SECONDS.toMillis(Integer.parseInt(parts[i]));
                }
            }
        }

        return duration;
    }

    private Mode parseMode(String strMode) {
        switch (strMode) {
            case "Walk": return new OnFoot(OnFoot.WALK);
            case "Run": return new OnFoot(OnFoot.RUN);
            case "Horse trot": return new Horse(Horse.TROT);
            case "Horse gallop": return new Horse(Horse.GALLOP);
            case "Elephant ride": return new Elephant();
            default: return new OnFoot(OnFoot.WALK);
        }
    }

    private File verifyAndGetFile(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            System.err.println("No filename provided");

            return null;
        }

        File instructionsFile = new File(fileName);

        if (!instructionsFile.exists()) {
            System.err.println("The instructions file does not exist at the given path");

            return null;
        }

        if (instructionsFile.isDirectory()) {
            System.err.println("The expected path should be a file");

            return null;
        }

        if (!instructionsFile.canRead()) {
            System.err.println("Instructions file could not be read. Please check, if you have rights to it");

            return null;
        }

        return instructionsFile;
    }
}
