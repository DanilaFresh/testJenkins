package com.example.testSpring.patternStrategy;

import org.springframework.stereotype.Component;

@Component
public class MyData {

    private String data;

    private DataPrintType printType;

    public void setData(String data){
        this.data=data;
    }

    public String getData() {
        return data;
    }
}
