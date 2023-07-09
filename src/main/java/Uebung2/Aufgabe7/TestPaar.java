package Uebung2.Aufgabe7;

import Uebung2.Aufgabe6.Paar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPaar {
	private Paar<Integer, String> p;

	@BeforeEach
	public void init() {
		p = new Paar<>(1, "Hello");
	}

	@Test
	public void testGetErstes() {
		assertEquals(1, p.getErstes());
	}

	@Test
	public void testGetZweites() {
		assertEquals("Hello", p.getZweites());
	}

	@Test
	public void testSetErstes() {
		Integer altes = p.setErstes(5);
		assertEquals(1, altes);
		assertEquals(5, p.getErstes());
	}

	@Test
	public void testSetZweites() {
		String altes = p.setZweites("World");
		assertEquals("Hello", altes);
		assertEquals("World", p.getZweites());
	}

	@Test
	public void testSetBeides() {
		p.setBeide(10, "World");
		assertEquals(10, p.getErstes());
		assertEquals("World", p.getZweites());
	}

	@Test
	public void testEquals() {
		Paar<Integer, String> p2 = new Paar<>(1, "Hello");
		assertTrue(p.equals(p2));
	}

	@Test
	public void testNotEquals() {
		Paar<Integer, String> p2 = new Paar<>(5, "World");
		assertFalse(p.equals(p2));

		Paar<String, Integer> p3 = new Paar<>("World", 5);
		assertFalse(p.equals(p3));
	}

	@Test
	public void testToString() {
		assertEquals("(1,Hello)", p.toString());
	}
}
