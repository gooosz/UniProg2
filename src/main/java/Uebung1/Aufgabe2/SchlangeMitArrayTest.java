package Uebung1.Aufgabe2;


import Uebung0.Aufgabe2.SchlangeMitArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class SchlangeMitArrayTest {
	private SchlangeMitArray schlange;

	@BeforeEach
	public void init() {
		schlange = new SchlangeMitArray(10);
	}

	@Test
	public void testSchlangeCapacity() {
		assertEquals(10, schlange.capacity());
	}

	@Test
	public void testSchlangeSize() {
		assertEquals(0, schlange.size());
	}

	@Test
	public void testSchlangeIsEmpty() {
		assertTrue(schlange.isEmpty());
	}

	@Test
	public void testSchlangeIsNotEmpty() {
		schlange.insert(1);
		assertFalse(schlange.isEmpty());
	}

	@Test
	public void testSchlangeInsert() {
		schlange.insert(1);
		assertEquals(1, schlange.front());
	}

	@Test
	public void testSchlangeInsertThrows() {
		for (int i=0; i<10; i++) {
			schlange.insert(i);
		}
		assertEquals(schlange.size(), schlange.capacity());
		assertThrows(IllegalStateException.class, () -> schlange.insert(10));
	}


	@Test
	public void testSchlangeFrontExists() {
		schlange.insert(1);
		assertEquals(1, schlange.front());
	}

	@Test
	public void testSchlangeFrontThrows() {
		assertThrows(NoSuchElementException.class, () -> schlange.front());
	}


	@Test
	public void testSchlangeRemoveThrows() {
		assertThrows(NoSuchElementException.class, () -> schlange.remove());
	}

	@Test
	public void testSchlangeRemoveFront() {
		schlange.insert(1);
		assertEquals(1, schlange.size());
		schlange.remove();
		assertEquals(0, schlange.size());
	}

	@Test
	public void testSchlangeRemoveWithManyElements() {
		schlange.insert(1);
		schlange.insert(2);
		assertEquals(2, schlange.size());
		schlange.remove();
		assertEquals(1, schlange.size());
		assertEquals(2, schlange.front());
	}
}
