package com.greenlandropes.ropesappdesign;


public class Score {
    public String name;
    public int pointValue;
    public int toggleValue = 0;

    public Score(String name, int pointValue) {
        this.name = name;
        this.pointValue = pointValue;
    }

    public void setToggleValue(int toggleValue) {
        this.toggleValue = toggleValue;
    }

    public int calculateTotalScore() {
        return 1;
    }
}
