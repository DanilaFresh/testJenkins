package com.example.testSpring;

import org.springframework.stereotype.Component;

@Component
public class MyTaskUser {

    private final AsyncTasker tasker;

    public MyTaskUser(AsyncTasker tasker) {
        this.tasker = tasker;
    }

    public void useTask(){
        tasker.showThread();
    }
}
