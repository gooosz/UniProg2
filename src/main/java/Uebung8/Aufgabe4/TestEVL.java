package Uebung8.Aufgabe4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEVL {
	private EVL<Integer> evl;

	@BeforeEach
	public void init() {
		evl = new EVL<>();
		evl.insert(1);
		evl.insert(2);
		evl.insert(3);
	}

	@Test
	public void testIterator() {
		String s = "";
		for (Integer i: evl) {
			s += i + "-";
		}
		assertEquals("1-2-3-", s);
	}
}
