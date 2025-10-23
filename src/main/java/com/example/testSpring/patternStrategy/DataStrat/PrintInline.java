package com.example.testSpring.patternStrategy.DataStrat;

import com.example.testSpring.patternStrategy.DataPrintType;
import com.example.testSpring.patternStrategy.MyData;
import org.springframework.stereotype.Component;

@Component
public class PrintInline implements PrintType{
    private final DataPrintType printType=DataPrintType.INLINE;
    @Override
    public DataPrintType getPrintType() {
        return printType;
    }

    @Override
    public void print(MyData data) {
        System.out.println(data.getData());
    }
}
