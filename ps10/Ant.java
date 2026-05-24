//*******************************************************************
//
//   File: Ant.java          Assignment No.: 10
//
//   Author: 曾诚誉      Email: zcy19859231839@126.com
//
//   Class: Ant
// 
//   Description: Defines the Ant critter. 
//   Ants alternate between two directions (South/East or North/East).
//   They always eat and always scratch in a fight.
//
//*******************************************************************

import java.awt.*; 

public class Ant extends Critter {
    private boolean walkSouth;
    private int moves;

    
    public Ant(boolean walkSouth) {
        this.walkSouth = walkSouth;
        this.moves = 0;
    }

    
    public boolean eat() {
        return true;
    }

    
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    
    public Color getColor() {
        return Color.RED;
    }

    
    public String toString() {
        return "%";
    }

    
    public Direction getMove(String[][] grid) {
        moves++;
        if (walkSouth) {
            if (moves % 2 != 0) {
                return Direction.SOUTH;
            } else {
                return Direction.EAST;
            }
        } else {
            if (moves % 2 != 0) {
                return Direction.NORTH;
            } else {
                return Direction.EAST;
            }
        }
    }
}

