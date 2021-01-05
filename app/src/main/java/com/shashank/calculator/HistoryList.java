package com.shashank.calculator;

public class HistoryList {
    private String mCalculation;
    private String mAnswer;
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
