package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

public abstract class Mode {
    protected int speed;

    public abstract Point travel(Point location, Instruction instruction);

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


