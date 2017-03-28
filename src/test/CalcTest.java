package test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Calc;

public class CalcTest {

	@Test
	public void testSum() {
		Calc c = new Calc();
		assertEquals(c.sum(2, 2), 4);;
	}

}
