package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

public class OnFoot extends Mode {

    public static int WALK = 3;
    public static int RUN = 6;

    public OnFoot(int speed) {
        this.speed = speed;
    }

    public Point walk(Point location, Instruction instruction) {
        speed = WALK;

        return move(location, instruction);
    }

    public Point run(Point location, Instruction instruction) {
        speed = RUN;

        return move(location, instruction);
    }
}
