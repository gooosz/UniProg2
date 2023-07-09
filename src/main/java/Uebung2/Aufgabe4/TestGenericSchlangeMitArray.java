package Uebung2.Aufgabe4;

import Uebung2.Aufgabe3.Schlange;
import Uebung2.Aufgabe3.SchlangeMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGenericSchlangeMitArray {
	private SchlangeMitArray<Integer> schlangeInteger;
	private SchlangeMitArray<String> schlangeString;

	@BeforeEach
	public void init() {
		schlangeInteger = new SchlangeMitArray<>(10);
		schlangeString = new SchlangeMitArray<>(10);
	}

	@Test
	public void testInsert() {
		schlangeInteger.insert(5);
		assertEquals(1, schlangeInteger.size());
		schlangeInteger.insert(10);
		assertEquals(2, schlangeInteger.size());

		schlangeString.insert("Hello");
		assertEquals(1, schlangeString.size());
		schlangeString.insert("World");
		assertEquals(2, schlangeString.size());
	}

	@Test
	public void testFirstElement() {
		schlangeInteger.insert(1);
		assertEquals(1, schlangeInteger.front());

		schlangeString.insert("Hello");
		assertEquals("Hello", schlangeString.front());
	}
}
