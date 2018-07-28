package org.test.asim.treasurehunt.instruction;

import org.test.asim.treasurehunt.transportation.Direction;
import org.test.asim.treasurehunt.transportation.Mode;

public class Instruction {
    private Mode mode;
    private long durationMillis;
    private Direction direction;

    public Instruction(Mode mode, long durationMillis, Direction direction) {
        this.mode = mode;
        this.durationMillis = durationMillis;
        this.direction = direction;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
