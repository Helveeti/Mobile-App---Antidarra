package com.example.jallu;

/* Veera A. */

public class Value {
    private int value;

    public Value(int value){
        this.value = value;
    }

    public void plus(){
        this.value++;
    }

    public void plusItem(int value){this.value += value;}

    public int getValue(){
        return this.value;
    }
}
