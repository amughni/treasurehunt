package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

public class Elephant extends Mode {
    public static int WALK = 6;

    protected int speed = WALK;

    public Elephant() {

    }

    @Override
    public Point move(Point location, Instruction instruction) {
        return new Point(0,0);
    }

    public Point ride(Point location, Instruction instruction) {
        speed = WALK;

        return move(location, instruction);
    }
}
