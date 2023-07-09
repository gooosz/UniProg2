package Uebung7.Aufgabe3;

import Uebung0.Aufgabe3.Person;
import Uebung7.Aufgabe2.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestComparatorPerson {
	private ComparatorPersonVornameName comp;

	@BeforeEach
	public void init() {
		comp = new ComparatorPersonVornameName();
	}

	@Test
	public void testCompareGroesserAlsName() {
		Student s1 = new Student("F", "B", 10);
		Student s2 = new Student("A", "B", 10);
		assertTrue(comp.compare(s1, s2) > 0);
	}

	@Test
	public void testCompareGroesserAlsVorname() {
		Student s1 = new Student("A", "M", 10);
		Student s2 = new Student("A", "B", 10);
		assertTrue(comp.compare(s1, s2) > 0);
	}
}
