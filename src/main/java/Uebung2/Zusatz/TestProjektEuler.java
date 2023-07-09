package Uebung2.Zusatz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestProjektEuler {
	@Test
	public void testSumme3Und5() {
		assertEquals(23, ProjektEuler.summe3Und5(10));
	}
}
