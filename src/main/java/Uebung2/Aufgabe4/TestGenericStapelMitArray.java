package Uebung2.Aufgabe4;

import Uebung2.Aufgabe3.Schlange;
import Uebung2.Aufgabe3.SchlangeMitArray;
import Uebung2.Aufgabe3.StapelMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGenericStapelMitArray {
	private StapelMitArray<Integer> stapelInteger;
	private StapelMitArray<String> stapelString;

	@BeforeEach
	public void init() {
		stapelInteger = new StapelMitArray<>(10);
		stapelString = new StapelMitArray<>(10);
	}

	@Test
	public void testInsert() {
		stapelInteger.insert(5);
		assertEquals(1, stapelInteger.size());
		stapelInteger.insert(10);
		assertEquals(2, stapelInteger.size());

		stapelString.insert("Hello");
		assertEquals(1, stapelString.size());
		stapelString.insert("World");
		assertEquals(2, stapelString.size());
	}

	@Test
	public void testFirstElement() {
		stapelInteger.insert(1);
		assertEquals(1, stapelInteger.top());

		stapelString.insert("Hello");
		assertEquals("Hello", stapelString.top());
	}

	@Test
	public void testApplyToAll() {
		StapelMitArray<String> stapel = new StapelMitArray<>(5);
		for (int i=0; i<stapel.capacity(); i++) {
			stapel.insert("String" + i);
		}

		for (int i=0; i<stapel.top().length(); i++) {
			int finalI = i;
			stapel.applyToAll(wert -> wert.substring(0, wert.length() - finalI));
		}

		for (int i=0; i<stapel.size(); i++) {
			System.out.println(stapel.size()-1 + ": " + stapel.top());
			stapel.remove();
		}
	}
}
