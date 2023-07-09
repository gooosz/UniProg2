package Uebung1.Aufgabe2;

import Uebung0.Aufgabe2.StapelMitArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class StapelMitArrayTest {
	private StapelMitArray stapel;

	@BeforeEach
	public void init() {
		stapel = new StapelMitArray(10);
	}

	@Test
	public void testStapelCapacity() {
		assertEquals(10, stapel.capacity());
	}

	@Test
	public void testStapelSize() {
		assertEquals(0, stapel.size());
	}

	@Test
	public void testStapelIsEmpty() {
		assertTrue(stapel.isEmpty());
	}

	@Test
	public void testStapelIsNotEmpty() {
		stapel.insert(1);
		assertFalse(stapel.isEmpty());
	}

	@Test
	public void testStapelInsert() {
		stapel.insert(1);
		assertEquals(1, stapel.top());
	}

	@Test
	public void testStapelInsertThrows() {
		for (int i=0; i<10; i++) {
			stapel.insert(i);
		}
		assertEquals(stapel.size(), stapel.capacity());
		assertThrows(IllegalStateException.class, () -> stapel.insert(10));
	}


	@Test
	public void testStapelTopExists() {
		stapel.insert(1);
		assertEquals(1, stapel.top());
	}

	@Test
	public void testStapelTopThrows() {
		assertThrows(NoSuchElementException.class, () -> stapel.top());
	}


	@Test
	public void testStapelRemoveThrows() {
		assertThrows(NoSuchElementException.class, () -> stapel.remove());
	}

	@Test
	public void testStapelRemoveFront() {
		stapel.insert(1);
		assertEquals(1, stapel.size());
		stapel.remove();
		assertEquals(0, stapel.size());
	}

	@Test
	public void testStapelRemoveWithManyElements() {
		stapel.insert(1);
		stapel.insert(2);
		assertEquals(2, stapel.size());

		stapel.remove();
		assertEquals(1, stapel.top());
	}
}
