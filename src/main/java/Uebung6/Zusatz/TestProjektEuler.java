package Uebung6.Zusatz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProjektEuler {
	@Test
	public void testIstPrim() {
		assertTrue(ProjektEuler.istPrim(2));
		assertTrue(ProjektEuler.istPrim(3));
		assertTrue(ProjektEuler.istPrim(5));
		assertTrue(ProjektEuler.istPrim(19));

		assertFalse(ProjektEuler.istPrim(25));
	}

	@Test
	public void testPrimfaktoren() {
		for (long i=2; i<=10; i++) {
			System.out.println(i + ": " + ProjektEuler.dynArrayToString(
				ProjektEuler.primfaktoren(i)));
		}
	}
}
