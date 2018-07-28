package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

public class OnFoot extends Mode {

    public OnFoot(int speed) {
        this.speed = speed;
    }
    public static int WALK = 3;
    public static int RUN = 6;

    public Point walk(Point location, Instruction instruction) {
        speed = WALK;

        return travel(location, instruction);
    }

    public Point run(Point location, Instruction instruction) {
        speed = RUN;

        return travel(location, instruction);
    }

    @Override
    public Point travel(Point location, Instruction instruction) {
        return new Point(0,0);
    }
}
