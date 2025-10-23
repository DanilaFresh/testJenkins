package com.example.testSpring.patternStrategy.DataStrat;

import com.example.testSpring.patternStrategy.DataPrintType;
import com.example.testSpring.patternStrategy.MyData;
import org.springframework.stereotype.Component;

@Component
public class PrintWithTab implements PrintType {

    private final DataPrintType printType = DataPrintType.TAB;

    @Override
    public DataPrintType getPrintType() {
        return printType;
    }

    @Override
    public void print(MyData data) {
        StringBuilder stringBuilder = new StringBuilder();
        String dataAsString = data.getData();
        long length = dataAsString.length();
        for (int i = 0; i < length; i += 20) {
            if (i + 20 < length) {
                stringBuilder.
                        append(dataAsString.substring(i, i + 20)).
                        append("\n");
            } else {
                stringBuilder.append(dataAsString.substring(i));
                break;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
