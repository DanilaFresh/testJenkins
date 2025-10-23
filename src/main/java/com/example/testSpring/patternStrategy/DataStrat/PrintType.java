package com.example.testSpring.patternStrategy.DataStrat;

import com.example.testSpring.patternStrategy.DataPrintType;
import com.example.testSpring.patternStrategy.MyData;

public interface PrintType {
    DataPrintType getPrintType();
    void print(MyData data);
}
