package com.example.testSpring.patternStrategy;

import com.example.testSpring.patternStrategy.DataStrat.PrintType;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StringPrinter {


    private final Map<String, PrintType> printTypes;

    public StringPrinter(List<PrintType> printTypeList) {
        printTypes = new HashMap<>();
        printTypeList.forEach(printType -> {
            printTypes.put(printType.getPrintType().toString(), printType);
        });
    }

//    @EventListener(ApplicationReadyEvent.class)
//    private void printData() {
//        var myDataInst=new MyData();
//        myDataInst.setData("wqqwewqewqewqweqweqweqweqwe");
//        printTypes.get("INLINE").print(myDataInst);
//    }
}
