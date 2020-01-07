package com.example.infojallu;
//Luominen
public class DoubleCounter {
    private double value;
    private double max;
    private double min;
//Alustaminen
    DoubleCounter(int max, int min){
        this.value = 0;
        this.max = max;
        this.min = min;
    }
//Jos ehto pätee nostaa lukua
    void add(){
        if (value < max){
            value++;
        }
    }
    //Jos ehto pätee nostaa lukua
    void ad(){
        if (value < max){
            value = value + 1.5;
        }
    }
    //Jos ehto pätee laskee lukua
    void reduce(){
        if (value > min){
            value--;
        }
    }
    //Jos ehto pätee laskee lukua
    void red(){
        if(value > min){
            value = value - 1.5;
        }
    }
    // nollaa
    void nollaus(){
        value = 0.0;
    }

    double getValue() {
        return value;
    }
}


