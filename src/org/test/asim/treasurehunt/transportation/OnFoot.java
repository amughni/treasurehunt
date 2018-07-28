package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

import java.util.concurrent.TimeUnit;

public class OnFoot extends Mode {

    public static int WALK = 3;
    public static int RUN = 6;

    public OnFoot(int speed) {
        this.speed = speed;
    }

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
        long distance = speed * TimeUnit.MILLISECONDS.toHours(instruction.getDurationMillis()) ;

        /*Formula Chart
        * N: Y+ 90
        * S: Y- 90
        * E: X+ 0
        * W: x- 0
        * NE: Y+X+
        * */

        return new Point(location.getX() + distance,0);
    }
}
