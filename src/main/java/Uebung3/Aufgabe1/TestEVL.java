package Uebung3.Aufgabe1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
public class TestEVL {
	private EVL<Integer> list;

	@BeforeEach
	public void init() {
		list = new EVL<>();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	public void testGetFirst() {
		assertThrows(NoSuchElementException.class, () -> list.getFirst());

		list.addFirst(1);
		assertEquals(1, list.getFirst());
	}

	@Test
	public void testGetLast() {
		assertNull(list.getLast());

		list.addFirst(1);
		assertEquals(1, list.getLast());

		list.addLast(2);
		assertEquals(2, list.getLast());

		list.addLast(5);
		assertEquals(5, list.getLast());
	}

	@Test
	public void testAddFirst() {
		list.addFirst(1);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testAddLast() {
		list.addLast(10);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testContains() {
		list.addLast(1);
		assertTrue(list.contains(1));

		list.addLast(2);
		assertTrue(list.contains(2));

		list.addFirst(5);
		assertFalse(list.contains(8));
	}

	@Test
	public void testSize() {
		assertEquals(0, list.size());

		for (int i=0; i<10; i++) {
			list.addFirst(i);
		}
		assertEquals(10, list.size());
	}

	@Test
	public void testToString() {
		assertEquals("", list.toString());

		for (int i=0; i<5; i++) {
			list.addLast(i);
		}
		assertEquals("0-1-2-3-4", list.toString());
	}

	@Test
	public void testRemoveLast() {
		assertThrows(NoSuchElementException.class, () -> list.removeLast());

		list.addLast(1);
		assertEquals(1, list.removeLast());

		assertTrue(list.isEmpty());
	}
}
