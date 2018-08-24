package com.Lab1AED.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SortTest {

	private Number[] numbers;
	
	
	public void setup1() {
		
		Random r = new Random();
		for(int i = 0; i < 1000000; i++) {
			numbers[i] = r.nextInt(Integer.MAX_VALUE);
		}
		
	}
	
	@Test
	public void QuickSortTest1() {
		
	}
	

}
