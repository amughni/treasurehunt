package org.test.asim.treasurehunt.transportation;

public enum Direction {
    NORTH ("N", "north", 90.0),
    NORTH_EAST ("NE", "north east", 45.0),
    EAST ("E", "East", 0.0),
    SOUTH_EAST ("SE", "south east", 315.0),
    SOUTH ("S", "South", 270.0),
    SOUTH_WEST ("SW", "south west", 225.0),
    WEST("W", "West", 180.0),
    NORTH_WEST ("NW", "north west", 135.0);

    private final String directionCode;
    private final String friendlyName;
    private final Double angle;

    Direction(String directionCode, String friendlyName, Double angle) {
        this.directionCode = directionCode;
        this.friendlyName = friendlyName;
        this.angle = angle;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Double getAngle() {
        return angle;
    }

    public static Direction getDirectionByCode(String directionCode) {
        for (Direction direction: values()) {
            if (directionCode.equalsIgnoreCase(direction.getDirectionCode())) {
                return direction;
            }
        }

        return NORTH;
    }
}
