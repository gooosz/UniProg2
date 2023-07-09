package Uebung4.Aufgabe2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class TestDynArray {
	private DynArray<Integer> da;

	@BeforeEach
	public void init() {
		da = new DynArray<>();
	}

	@Test
	public void testGetter() {
		assertEquals(0, da.size());
		assertEquals(1, da.capacity());
		assertThrows(NoSuchElementException.class, () -> da.get(0));
	}

	@Test
	public void testAddFirst() {
		da.addFirst(1);
		assertEquals(1, da.get(0));
		assertEquals(1, da.size());
		assertEquals(1, da.capacity());

		da.addFirst(2);
		assertEquals(2, da.get(0));
		assertEquals(1, da.get(1));
		assertEquals(2, da.size());
		assertEquals(2, da.capacity());
	}

	@Test
	public void testAddLast() {
		da.addLast(1);
		assertEquals(1, da.get(0));
		assertEquals(1, da.size());
		assertEquals(1, da.capacity());

		da.addLast(2);
		assertEquals(1, da.get(0));
		assertEquals(2, da.get(1));
		assertEquals(2, da.size());
		assertEquals(2, da.capacity());
	}

	@Test
	public void testSet() {
		assertThrows(NoSuchElementException.class, () -> da.set(0, 1));
		da.addLast(1);
		da.set(0, 2);
		assertEquals(2, da.get(0));
	}

	@Test
	public void testRemoveFirst() {
		assertThrows(NoSuchElementException.class, () -> da.removeFirst());
		da.addFirst(1);
		da.removeFirst();
		assertEquals(0, da.size());
		assertEquals(1, da.capacity());

		da.addLast(1);
		da.addLast(2);
		da.removeFirst();
		assertEquals(2, da.get(0));
		assertEquals(1, da.size());
		assertEquals(2, da.capacity());
	}

	@Test
	public void testRemoveFirstWithCapacityDecrease() {
		// capacity should decrease here
		da.addLast(1);
		da.addLast(2);
		da.addLast(3);
		da.addLast(4);
		assertEquals(4, da.capacity());
		for (int i=0; i<3; i++) {
			da.removeFirst();
		}
		assertEquals(4, da.get(0));
		assertEquals(1, da.size());
		assertEquals(2, da.capacity());
	}

	@Test
	public void testRemoveLast() {
		assertThrows(NoSuchElementException.class, () -> da.removeFirst());
		da.addLast(1);
		da.removeLast();
		assertEquals(0, da.size());
		assertEquals(1, da.capacity());

		da.addLast(1);
		da.addLast(2);
		da.removeLast();
		assertEquals(1, da.get(0));
		assertEquals(1, da.size());
		assertEquals(2, da.capacity());
	}

	@Test
	public void testRemoveLastWithCapacityDecrease() {
		// capacity should decrease here
		da.addLast(1);
		da.addLast(2);
		da.addLast(3);
		da.addLast(4);
		assertEquals(4, da.capacity());
		for (int i=0; i<3; i++) {
			da.removeLast();
		}
		assertEquals(1, da.get(0));
		assertEquals(1, da.size());
		assertEquals(2, da.capacity());
	}
}
