package com.example.jallu;

//Luominen
public class Counter {
    private int value;
    private int max;
    private int min;
    //Alustaminen
    Counter(int max, int min){
        this.value = 0;
        this.max = max;
        this.min = min;
    }

    void plus(){
        if (value < max){
            value++;
        }
    }


    void minus(){
        if (value > min){
            value--;
        }
    }

    void reset(){
        value = 0;
    }

    int getValue() {
        return value;
    }
}

