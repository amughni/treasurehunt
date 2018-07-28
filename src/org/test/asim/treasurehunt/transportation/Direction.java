package org.test.asim.treasurehunt.transportation;

public enum Direction {
    NORTH ("N", "North"),
    NORTH_EAST ("NE", "North East"),
    EAST ("E", "East"),
    SOUTH_EAST ("SE", "South East"),
    SOUTH ("S", "South"),
    SOUTH_WEST ("SW", "South West"),
    NORTH_WEST ("NW", "North West");

    private final String directionCode;
    private final String friendlyName;

    Direction(String directionCode, String friendlyName) {
        this.directionCode = directionCode;
        this.friendlyName = friendlyName;
    }

    public String getDirectionCode() {
        return directionCode;
    }

    public String getFriendlyName() {
        return friendlyName;
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
