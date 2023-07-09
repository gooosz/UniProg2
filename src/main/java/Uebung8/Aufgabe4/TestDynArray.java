package Uebung8.Aufgabe4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDynArray {
	private DynArray<Integer> arr;

	@BeforeEach
	public void init() {
		arr = new DynArray<>();
		for (int i=1; i<=10; i++) {
			arr.addLast(i);
		}
	}

	@Test
	public void testIterate() {
		String s = "";
		for (Integer i: arr) {
			s += i + " ";
		}
		assertEquals("1 2 3 4 5 6 7 8 9 10 ", s);
	}

	@Test
	public void test() {
		Integer[] arr = {1, 2, 3};
		for (Integer element: arr) {
			element = 42;
		}
		System.out.println(Arrays.toString(arr));
	}
}
