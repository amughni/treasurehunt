package org.test.asim.treasurehunt.transportation;

import org.test.asim.treasurehunt.instruction.Instruction;

import java.util.concurrent.TimeUnit;

public abstract class Mode {
    protected int speed;

    public Point move(Point location, Instruction instruction) {
        double x = location.getX();
        double y = location.getY();
        Direction direction = instruction.getDirection();
        long time = TimeUnit.MILLISECONDS.toHours(instruction.getDurationMillis());
        long distance = speed * time;

        //Calculating "coordinate distance" ratio based on direction angle
        // Example: In case of north direction cos of 90 is 0, so no horizontal movement and
        // sin of 90 is 1, so full vertical movement
        double xRatio = Math.cos(Math.toRadians(direction.getAngle()));
        double yRatio = Math.sin(Math.toRadians(direction.getAngle()));
        x += (xRatio * distance);
        y += (yRatio * distance);

        return new Point(x,y);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


