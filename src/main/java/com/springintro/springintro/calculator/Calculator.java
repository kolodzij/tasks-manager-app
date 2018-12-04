package com.springintro.springintro.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;

    public double add(double val1, double val2) {
        display.displayValue(val1+val2);
        return val1+val2;

    }

}


