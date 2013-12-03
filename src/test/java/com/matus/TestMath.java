package com.matus;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMath {

	@Test
	public void testAdd() {
		assertEquals(20.0, calculator.dodawanie(10, 10), 0);
	}

	@Test
	public void testSub() {
		assertEquals(0.0, calculator.odejmowanie(10, 10), 0);
	}

	@Test
	public void testSub2() {
		assertEquals(5.0, calculator.odejmowanie(10, 5),0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDiv() {
		calculator.dzielenie(10, 0);
	}
}
