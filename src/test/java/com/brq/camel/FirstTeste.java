package com.brq.camel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirstTeste {

	@Test
	public void firstSucessTeste() {
		
		int sum = 5 + 2;
		int expected = 7;
		
		assertEquals(expected, sum);
		
	}
	
	@Test
	public void firstIfExpectedGreatherThanSumTeste() {
		
		int sum = 5 + 2;
		int expected = 9;
		
		assertTrue(expected > sum);
		
	}
}
