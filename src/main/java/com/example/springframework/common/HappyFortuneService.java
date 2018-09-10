package com.example.springframework.common;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    public HappyFortuneService() {
        System.out.println("++ HappyFortuneService::Const() ++");
    }

    @Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}