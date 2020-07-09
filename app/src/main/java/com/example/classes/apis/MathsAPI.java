package com.example.classes.apis;

import com.example.classes.services.MathsAPIListener;

public class MathsAPI {
    //initialize the MathsAPIListener
    private MathsAPIListener mathsAPIListener;
    public void sum(int num1, int num2){
        int answer = num1 + num2;
        // report using the listener after getting answer
        mathsAPIListener.onAnswerReceived(answer);
    }

    public void product(int num1, int num2){
        int answer = num1 * num2;
        // report using the listener after getting answer
        mathsAPIListener.onAnswerReceived(answer);
    }

    public MathsAPIListener getMathsAPIListener() {
        return mathsAPIListener;
    }

    public void setMathsAPIListener(MathsAPIListener mathsAPIListener) {
        this.mathsAPIListener = mathsAPIListener;
    }
}
