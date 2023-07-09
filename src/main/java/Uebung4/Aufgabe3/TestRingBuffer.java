package Uebung4.Aufgabe3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class TestRingBuffer {
	private RingBuffer<Integer> ring;

	@BeforeEach
	public void init() {
		ring = new RingBuffer<>(4);
	}

	@Test
	public void testGetter() {
		assertEquals(0, ring.size());
		assertEquals(4, ring.capacity());
	}

	@Test
	public void testAddLast() {
		ring.addLast(1);
		assertEquals(1, ring.size());
		assertEquals(1, ring.get(0));
		assertEquals("1-_-_-_", ring.toString());

		ring.addLast(2);
		assertEquals(2, ring.size());
		assertEquals(2, ring.get(1));
		assertEquals("1-2-_-_", ring.toString());

		ring.addLast(3);
		assertEquals(3, ring.size());
		assertEquals(3, ring.get(2));
		assertEquals("1-2-3-_", ring.toString());

		ring.addLast(4);
		assertEquals(4, ring.size());
		assertEquals(4, ring.get(3));
		assertEquals("1-2-3-4", ring.toString());

		assertThrows(RingIsFullException.class, () -> ring.addLast(5));
	}

	@Test
	public void testAddFirst() {
		ring.addFirst(1);
		assertEquals(1, ring.size());
		assertEquals(1, ring.get(0));
		assertEquals("1-_-_-_", ring.toString());
		System.out.println(ring.toString());

		ring.addFirst(2);
		assertEquals(2, ring.size());
		assertEquals(2, ring.get(0));
		assertEquals("2-1-_-_", ring.toString());
		System.out.println(ring.toString());

		ring.addFirst(3);
		assertEquals(3, ring.size());
		assertEquals(3, ring.get(0));
		assertEquals("3-2-1-_", ring.toString());
		System.out.println(ring.toString());

		ring.addFirst(4);
		assertEquals(4, ring.size());
		assertEquals(4, ring.get(0));
		assertEquals("4-3-2-1", ring.toString());
		System.out.println(ring.toString());

		assertThrows(RingIsFullException.class, () -> ring.addFirst(5));
	}

	@Test
	public void testSet() {
		ring.addLast(1);
		assertEquals(1, ring.get(0));
		ring.set(0, 10);
		assertEquals(10, ring.get(0));

		ring.addLast(2);
		ring.set(1, 20);
		assertEquals(20, ring.get(1));

		ring.addFirst(3);
		ring.set(-1, 30);
		assertEquals(30, ring.get(-1));
	}

	@Test
	public void testRemoveLast() {
		ring.addLast(1);
		ring.removeLast();
		assertEquals(0, ring.size());

		ring.addLast(1);
		ring.addLast(2);
		ring.removeLast();
		assertEquals(1, ring.size());
		assertEquals(1, ring.get(0));

		ring.addLast(2);
		ring.addLast(3);
		ring.addLast(4);
		ring.removeLast();
		assertEquals(3, ring.size());
		assertEquals(1, ring.get(0));
		assertEquals(2, ring.get(1));
		assertEquals(3, ring.get(2));
		assertThrows(NoSuchElementException.class, () -> ring.get(3));
	}

	@Test
	public void testRemoveFirst() {
		ring.addLast(1);
		ring.removeFirst();
		assertEquals(0, ring.size());

		ring.addLast(1);
		System.out.println(ring.toString());
		ring.addLast(2);
		System.out.println(ring.toString());
		ring.removeFirst();
		assertEquals(1, ring.size());
		assertEquals(2, ring.get(0));
	}

	@Test
	public void testRemoveFirstWithRingFull() {
		ring.addLast(1);
		ring.addLast(2);
		ring.addLast(3);
		ring.addLast(4);
		ring.removeFirst();
		assertEquals(3, ring.size());
		assertEquals(2, ring.get(0));
		assertEquals(3, ring.get(1));
		assertEquals(4, ring.get(2));
		assertThrows(NoSuchElementException.class, () -> ring.get(3));
	}
}
