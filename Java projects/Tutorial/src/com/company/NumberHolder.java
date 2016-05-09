package com.company;

/**
 * Created by zik on 10.02.16.
 */
public class NumberHolder {
    public int anInt;
    public float aFloat;
    
    public NumberHolder(int anInt, float aFloat){
        this.anInt = anInt;
        this.aFloat = aFloat;
    }

    public static void main(String[] args) {
        NumberHolder number = new NumberHolder(2, 4.6f);
        System.out.println(number.anInt);
        System.out.println(number.aFloat);
    }
}