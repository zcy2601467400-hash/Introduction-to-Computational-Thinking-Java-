//*******************************************************************
//
//   File: Bulldog.java          Assignment No.: 10
//
//   Author: 曾诚誉      Email: zcy19859231839@126.com
//
//   Class: Bulldog
// 
//   Description: My creative critter.
//   Strategy:
//   1. Fighting: Analyzes the opponent's string to counter their likely attack.
//      - Vs Ant (%): Ant scratches, so Bulldog Roars (Roar > Scratch).
//      - Vs Bird/Vulture (^, >, V, <): They usually Pounce on non-Ants. 
//        Bulldog Scratches (Scratch > Pounce).
//      - Vs Stone (S): Stone Roars. Bulldog Pounces (Pounce > Roar).
//      - Vs Hippo (Number): 
//          If "0" (Full), Hippo Pounces -> Bulldog Scratches.
//          If Number (Hungry), Hippo Scratches -> Bulldog Roars.
//   2. Movement: Random to explore.
//   3. Appearance: Changes color randomly (Disco mode) and looks like "B".
//
//*******************************************************************

import java.awt.*;
import java.util.*;

public class Bulldog extends Critter {
    private Random rand;

    public Bulldog() {
        this.rand = new Random();
    }

    
    public boolean eat() {
        return true;
    }

    
    public Attack fight(String opponent) {
        
        if (opponent.equals("%")) {
            return Attack.ROAR;
        }
        
        else if (opponent.equals("S")) {
            return Attack.POUNCE;
        }
        
        else if (opponent.equals("^") || opponent.equals(">") || 
                 opponent.equals("V") || opponent.equals("<")) {
            return Attack.SCRATCH;
        }
        
        else {
            boolean isHippoHungry = !opponent.equals("0");
            try {
                
                Integer.parseInt(opponent);
                if (isHippoHungry) {
                    
                    return Attack.ROAR;
                } else {
                    
                    return Attack.SCRATCH;
                }
            } catch (NumberFormatException e) {
                
                return Attack.SCRATCH; 
            }
        }
    }

    
    public Color getColor() {
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    
    public Direction getMove(String[][] grid) {
        int r = rand.nextInt(4);
        if (r == 0) return Direction.NORTH;
        else if (r == 1) return Direction.SOUTH;
        else if (r == 2) return Direction.EAST;
        else return Direction.WEST;
    }

    public String toString() {
        return "B";
    }
}

