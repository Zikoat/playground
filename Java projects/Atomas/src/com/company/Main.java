package com.company;

public class Main {


    public Main (){

    }

    public static void main(String[] args) {

        int[] anArray;

        anArray = new int[10];

        anArray[0] = 100;
        anArray[1] = 200;


        for (int i = 0; i < anArray.length; i++) {
            System.out.println(anArray[i]);
        }

    }
}
