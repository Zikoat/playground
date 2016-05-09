package com.company;

/**
 * Created by zik on 24.01.16.
 */
class Bicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    void setCadence(int newValue){
        cadence = newValue;
    }

    void setGear(int newValue){
        gear = newValue;
    }

    void speedUp(int increment){
        speed += increment;
    }

    void applyBrakes(int decrement){
        speed -= decrement;
    }

    void printStates() {
        System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
    }
}
