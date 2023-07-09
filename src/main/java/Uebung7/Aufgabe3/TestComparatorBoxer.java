package Uebung7.Aufgabe3;


import Uebung7.Aufgabe2.Boxer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestComparatorBoxer {
	private ComparatorBoxerGewicht comp;

	@BeforeEach
	public void init() {
		comp = new ComparatorBoxerGewicht();
	}

	@Test
	public void testGreaterThan() {
		Boxer b1 = new Boxer("A", "B", 100);
		Boxer b2 = new Boxer("A", "B", 60);
		assertTrue(comp.compare(b1, b2) > 0);
	}

	@Test
	public void testEquals() {
		Boxer b1 = new Boxer("A", "B", 100);
		Boxer b2 = new Boxer("F", "G", 100);
		assertEquals(0, comp.compare(b1, b2));
	}

	@Test
	public void testSmallerThan() {
		Boxer b1 = new Boxer("A", "B", 60);
		Boxer b2 = new Boxer("E", "H", 120);
		assertTrue(comp.compare(b1, b2) < 0);
	}
}
