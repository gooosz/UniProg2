package Uebung7.Aufgabe4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuchbaum {
	private Suchbaum<Integer> tree;

	@BeforeEach
	public void init() {
		tree = new Suchbaum<>();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(tree.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, tree.size());
	}

	@Test
	public void testInsert() {
		tree.insert(1);
		assertFalse(tree.isEmpty());
		assertEquals(1, tree.size());
		assertTrue(tree.contains(1));
	}

	@Test
	public void testRemoveWurzel() {
		tree.insert (3);
		tree.remove(3);
		assertEquals("", tree.toString());
		tree.insert(3);
		tree.insert (2);
		tree.insert (5);
		tree.insert (4);
		tree.insert (1);
		tree.insert (7);
		assertEquals("(((1)2)3((4)5(7)))", tree.toString());

		tree.remove(3);
		assertEquals("((1)2((4)5(7)))", tree.toString());
		assertEquals(5, tree.size());

		tree.remove(2);
		assertEquals("(((1)4)5(7))", tree.toString());
		assertEquals(4, tree.size());

		tree.remove(5);
		assertEquals("((1)4(7))", tree.toString());
		assertEquals(3, tree.size());
	}
}
