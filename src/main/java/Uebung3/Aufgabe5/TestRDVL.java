package Uebung3.Aufgabe5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
public class TestRDVL {
	private RDVL<Integer> rdvl;

	@BeforeEach
	public void init() {
		rdvl = new RDVL<>();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(rdvl.isEmpty());
	}

	@Test
	public void testElement() {
		assertThrows(NoSuchElementException.class, () -> rdvl.element());
		rdvl.add(1);
		assertEquals(1, rdvl.element());
	}

	@Test
	public void testAdd() {
		rdvl.add(1);
		assertFalse(rdvl.isEmpty());

		rdvl.add(2);
		assertFalse(rdvl.isEmpty());

		rdvl.add(3);
		assertEquals(1, rdvl.element());
		rdvl.next(1);
		assertEquals(2, rdvl.element());
		rdvl.next(1);
		assertEquals(3, rdvl.element());
		rdvl.next(1);
		assertEquals(1, rdvl.element());
	}

	@Test
	public void testSize() {
		assertEquals(0, rdvl.size());
		rdvl.add(1);
		assertEquals(1, rdvl.size());
		rdvl.add(2);
		assertEquals(2, rdvl.size());
	}

	@Test
	public void testRemove() {
		assertThrows(NoSuchElementException.class, () -> rdvl.remove());
		rdvl.add(1);
		assertEquals(1, rdvl.remove());
		assertTrue(rdvl.isEmpty());

		rdvl.add(1);
		rdvl.add(2);
		rdvl.add(3);
		rdvl.remove();
		assertEquals(2, rdvl.size());
	}

	@Test
	public void testToString() {
		assertEquals("", rdvl.toString());
		rdvl.add(1);
		assertEquals("-1-", rdvl.toString());

		rdvl.add(2);
		assertEquals("-1-2-", rdvl.toString());

		rdvl.add(3);
		assertEquals("-1-2-3-", rdvl.toString());

		rdvl.add(1);
		assertEquals("-1-2-3-1-", rdvl.toString());
	}
}
