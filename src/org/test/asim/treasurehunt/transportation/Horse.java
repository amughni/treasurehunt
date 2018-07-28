package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

public class Horse extends Mode {
    public static int TROT = 4;
    public static int GALLOP = 15;

    public Horse(int speed) {
        this.speed = speed;
    }

    public Point trot(Point location, Instruction instruction) {
        speed = TROT;

        return move(location, instruction);
    }

    public Point gallop(Point location, Instruction instruction) {
        speed = GALLOP;

        return move(location, instruction);
    }
}
