//*******************************************************************
//
//   File: Hippo.java          Assignment No.: 10
//
//   Author: 曾诚誉      Email: zcy19859231839@126.com
//   Class: Hippo
// 
//   Description: Defines the Hippo critter.
//   Hippos wander randomly (5 steps in one direction).
//   They eat a set amount of food, change color when full,
//   and display their remaining hunger as text.
//
//*******************************************************************

import java.awt.*; 
import java.util.*; 

public class Hippo extends Critter {
    private int hunger;
    private int movesRemaining;
    private Direction currentDirection;
    private Random rand;

    
    public Hippo(int hunger) {
        this.hunger = hunger;
        this.movesRemaining = 0;
        this.rand = new Random();
        this.currentDirection = Direction.CENTER;
    }

    
    public boolean eat() {
        if (hunger > 0) {
            hunger--;
            return true;
        }
        return false;
    }

    
    public Attack fight(String opponent) {
        if (hunger > 0) {
            return Attack.SCRATCH;
        } else {
            return Attack.POUNCE;
        }
    }

    
    public Color getColor() {
        if (hunger > 0) {
            return Color.GRAY;
        } else {
            return Color.WHITE;
        }
    }

    
    public Direction getMove(String[][] grid) {
        if (movesRemaining > 0) {
            movesRemaining--;
            return currentDirection;
        } else {
            
            int r = rand.nextInt(4);
            if (r == 0) currentDirection = Direction.NORTH;
            else if (r == 1) currentDirection = Direction.SOUTH;
            else if (r == 2) currentDirection = Direction.EAST;
            else currentDirection = Direction.WEST;
            
            movesRemaining = 4; 
            return currentDirection;
        }
    }

    
    public String toString() {
        return "" + hunger;
    }
}

