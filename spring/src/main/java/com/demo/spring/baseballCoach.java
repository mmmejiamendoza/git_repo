package com.demo.spring;

import org.springframework.stereotype.Component;

@Component 
public class baseballCoach implements Coach {
    @Override 
    public String getDailyWorkout() {
        return "play baseball";
    }
}
