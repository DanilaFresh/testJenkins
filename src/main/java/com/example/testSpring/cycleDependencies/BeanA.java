package com.example.testSpring.cycleDependencies;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class BeanA {

    private final BeanB beanB;

    public BeanA(@Lazy BeanB beanB) {
        this.beanB = beanB;
    }

    public BeanB f(){
        return beanB;
    }
}
