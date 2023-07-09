package Uebung3.Zusatz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestProjektEuler {
	@Test
	public void testDiff() {
		assertEquals(2640, ProjektEuler.diff(10));
	}
}
