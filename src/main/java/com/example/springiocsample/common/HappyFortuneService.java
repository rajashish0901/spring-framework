package com.example.springiocsample.common;

import com.example.springiocsample.common.FortuneService;
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