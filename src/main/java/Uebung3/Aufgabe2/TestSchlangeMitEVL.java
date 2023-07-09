package Uebung3.Aufgabe2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSchlangeMitEVL {
	private SchlangeMitEVL<Integer> schlange;

	@BeforeEach
	public void init() {
		schlange = new SchlangeMitEVL<>();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(schlange.isEmpty());
	}

	@Test
	public void testInsert() {
		schlange.insert(1);
		assertFalse(schlange.isEmpty());
	}

	@Test
	public void testGetSize() {
		assertEquals(0, schlange.size());
		schlange.insert(5);
		assertEquals(1, schlange.size());
	}

	@Test
	public void testRemove() {
		assertThrows(NoSuchElementException.class, () -> schlange.remove());

		schlange.insert(1);
		assertEquals(1, schlange.size());
		schlange.remove();
		assertEquals(0, schlange.size());
	}

	@Test
	public void testGetFront() {
		assertThrows(NoSuchElementException.class, () -> schlange.front());
		schlange.insert(1);
		assertEquals(1, schlange.front());
	}
}