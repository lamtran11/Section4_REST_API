package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
	
	@Override
	public String getFortune() {
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
			
		} catch (InterruptedException e) {
			
			throw new RuntimeException(e);
		}
		
		//return a fortune
		return "Be prepared for a good day ahead!";
	}

	@Override
	public String getFortune(boolean tripWire) {
		
		if (tripWire) {
            
            throw new RuntimeException("High way is closed!");
            
        }
		
		return getFortune();		
	}
	
}















