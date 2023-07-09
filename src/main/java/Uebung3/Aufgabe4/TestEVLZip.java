package Uebung3.Aufgabe4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestEVLZip {
	private EVL<Integer> evl;

	@BeforeEach
	public void init() {
		evl = new EVL<>();
	}

	@Test
	public void testZipNoElementsInThis() {
		EVL<Integer> other = new EVL<>();
		other.addLast(2);
		other.addLast(4);
		evl.zip(other);
		assertEquals("2-4", evl.toString());
	}

	@Test
	public void testZipNoElementsInOther() {
		EVL<Integer> other = new EVL<>();
		evl.addLast(1);
		evl.zip(other);
		assertEquals("1", evl.toString());
	}

	@Test
	public void testZipElementsOtherSizeSmallerThanEVLSize() {
		evl.addLast(4);
		evl.addLast(1);
		evl.addLast(7);
		EVL<Integer> other = new EVL<>();
		other.addLast(3);
		other.addLast(5);
		evl.zip(other);
		assertEquals("4-3-1-5-7", evl.toString());
	}

	@Test
	public void testZipElementsOtherSizeEqualToEVLSize() {
		evl.addLast(1);
		evl.addLast(3);
		evl.addLast(5);
		EVL<Integer> other = new EVL<>();
		other.addLast(2);
		other.addLast(4);
		other.addLast(6);
		evl.zip(other);
		assertEquals("1-2-3-4-5-6", evl.toString());
	}

	@Test
	public void testZipElementsOtherSizeGreaterThanEVLSize() {
		evl.addLast(4);
		evl.addLast(1);
		evl.addLast(7);
		EVL<Integer> other = new EVL<>();
		other.addLast(3);
		other.addLast(5);
		other.addLast(2);
		other.addLast(8);
		other.addLast(6);
		evl.zip(other);
		assertEquals("4-3-1-5-7-2-8-6", evl.toString());
	}
}
