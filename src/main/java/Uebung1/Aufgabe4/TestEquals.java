package Uebung1.Aufgabe4;

import Uebung0.Aufgabe3.Boxer;
import Uebung0.Aufgabe3.Student;
import Uebung2.Aufgabe3.StapelMitArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEquals {
	private Student s1;
	private Boxer b1;

	@BeforeEach
	public void init() {
		s1 = new Student("student", "vorname", 10);
		b1 = new Boxer("boxer", "vorname", 90);
	}

	@Test
	public void testBoxerEqualsReflexiv() {
		assertEquals(b1, b1);
	}

	@Test
	public void testBoxerEqualsSymmetrie() {
		Boxer b2 = new Boxer("boxer", "vorname", 90);
		assertEquals(b1.equals(b2), b2.equals(b1));
		b2 = new Boxer("boxer2", "henry", 20);
		assertEquals(b1.equals(b2), b2.equals(b1));
	}

	/*
	 * a==b && b==c  =>  a==c
	 * Fails when:
	 * a==b && b==c && a!=c
	 */
	@Test
	public void testBoxerEqualsTransitiv() {
		Boxer b2 = new Boxer("boxer", "vorname", 90);
		Boxer b3 = new Boxer("boxer", "vorname", 90);
		if (b1.equals(b2) && b2.equals(b3)) {
			assertEquals(b1, b3);
		}
	}

	/*
	 * read
	 * https://www.jstage.jst.go.jp/article/transinf/E102.D/8/E102.D_2018EDP7254/_pdf/-char/en
	 * why
	 */
	@Test
	public void testBoxerEqualsKonsistenz() {
		/*
		 * if two boxer are equal, their hashcode must be the same for consistency
		*/
	}

	@Test
	public void testBoxerEqualsNull() {
		assertNotEquals(b1, null);
	}

	// -----

	@Test
	public void testStudentEqualsReflexiv() {
		assertEquals(s1, s1);
	}

	@Test
	public void testStudentEqualsSymmetrie() {
		Student s2 = new Student("student", "vorname", 10);
		assertEquals(s1.equals(s2), s2.equals(s1));
		s2 = new Student("student2", "henry", 20);
		assertEquals(s1.equals(s2), s2.equals(s1));
	}

	/*
	 * a==b && b==c  =>  a==c
	 * Fails when:
	 * a==b && b==c && a!=c
	 */
	@Test
	public void testStudentEqualsTransitiv() {
		Student s2 = new Student("student", "vorname", 90);
		Student s3 = new Student("student", "vorname", 90);
		if (s1.equals(s2) && s2.equals(s3)) {
			assertEquals(s1, s3);
		}
	}

	/*
	 * read
	 * https://www.jstage.jst.go.jp/article/transinf/E102.D/8/E102.D_2018EDP7254/_pdf/-char/en
	 * why
	 */
	@Test
	public void testStudentEqualsKonsistenz() {
		/*
		 * if two students are equal, their hashcode must be the same for consistency
		 */

	}

	@Test
	public void testStudentEqualsNull() {
		assertNotEquals(s1, null);
	}

}
