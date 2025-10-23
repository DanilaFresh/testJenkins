package com.example.testSpring.cycleDependencies;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private final BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }
}
