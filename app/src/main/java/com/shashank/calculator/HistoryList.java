package com.shashank.calculator;

public class HistoryList {
    private final String mCalculation;
    private final String mAnswer;
    public HistoryList(String Calculation, String Answer){
        mCalculation = Calculation;
        mAnswer = Answer;
    }
    public String getCalculation(){
        return mCalculation;
    }
    public String getAnswer(){
        return mAnswer;
    }
}
