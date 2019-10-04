/*
 * Name:
 *  Ship.java
 * Version:
 *  2.0
 * Revisions:
 *  None
 */

import java.io.Serializable;

/**
 * Creates a ship
 */
class Ship implements Serializable {
    int length;
    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;
    int shipHealth;

    Ship(int startX, int startY, int endX,
         int endY, int shipLength) {
        length = shipLength;
        start_x = startX;
        start_y = startY;
        end_x = endX;
        end_y = endY;
        shipHealth = length;
    }

    void decrementShipHealth() {
        this.shipHealth--;
    }

    boolean shipIsHit() {
        return this.shipHealth == 0;
    }

    boolean checkShipStatus(int x, int y) {
        if (x >= start_x && x <= end_x && y >= start_y && y <= end_y) {
            decrementShipHealth();
            return true;
        }
        return false;
    }
}