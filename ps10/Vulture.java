//*******************************************************************
//
//   File: Vulture.java          Assignment No.: 10
//
//   Author: 曾诚誉      Email: zcy19859231839@126.com
//
//   Class: Vulture
// 
//   Description: Defines the Vulture critter.
//   Vultures are a type of Bird (inherit from Bird).
//   They have specific hunger logic: hungry initially and after fights.
//   They are black in color.
//
//*******************************************************************

import java.awt.*; 

public class Vulture extends Bird {
    private boolean isHungry;

    public Vulture() {
        super(); 
        this.isHungry = true; 
    }

    
    public boolean eat() {
        if (isHungry) {
            isHungry = false;
            return true;
        }
        return false;
    }

    
    public Color getColor() {
        return Color.BLACK;
    }

    
    public Attack fight(String opponent) {
        isHungry = true;
        return super.fight(opponent);
    }
    
    
}
