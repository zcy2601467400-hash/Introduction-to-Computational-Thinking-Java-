//*******************************************************************
//
//   File: Bird.java          Assignment No.: 10
//
//   Author: 曾诚誉      Email: zcy19859231839@126.com
//
//   Class: Bird
// 
//   Description: Defines the Bird critter.
//   Birds fly in a clockwise square pattern (3 steps per side).
//   They never eat, appear blue, and have specific fighting behavior.
//
//*******************************************************************

import java.awt.*; 

public class Bird extends Critter {
    private int moveCount;
    private Direction lastDirection;

    public Bird() {
        this.moveCount = 0;
        this.lastDirection = Direction.NORTH; // Default mainly for initial toString logic
    }

    
    public boolean eat() {
        return false;
    }

    
    public Color getColor() {
        return Color.BLUE;
    }

    
    public Attack fight(String opponent) {
        if (opponent.equals("%")) {
            return Attack.ROAR;
        } else {
            return Attack.POUNCE;
        }
    }

    
    public Direction getMove(String[][] grid) {
        int step = moveCount % 12;
        moveCount++;

        if (step < 3) {
            lastDirection = Direction.NORTH;
            return Direction.NORTH;
        } else if (step < 6) {
            lastDirection = Direction.EAST;
            return Direction.EAST;
        } else if (step < 9) {
            lastDirection = Direction.SOUTH;
            return Direction.SOUTH;
        } else {
            lastDirection = Direction.WEST;
            return Direction.WEST;
        }
    }

    
    public String toString() {
        if (lastDirection == Direction.EAST) {
            return ">";
        } else if (lastDirection == Direction.SOUTH) {
            return "V";
        } else if (lastDirection == Direction.WEST) {
            return "<";
        } else {
            return "^"; 
        }
    }
}

