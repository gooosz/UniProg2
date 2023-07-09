package Uebung1.Aufgabe3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestStapelFunktion {
	private StapelMitArray stapel;

	@BeforeEach
	public void init() {
		stapel = new StapelMitArray(10);
	}

	@Test
	public void testStapelApplyToAllVerdoppeln() {
		stapel.insert(1);
		stapel.insert(2);
		stapel.insert(3);

		stapel.applyToAll(x -> { return 2*x; });

		assertEquals(6, stapel.top());
		stapel.remove();
		assertEquals(4, stapel.top());
		stapel.remove();
		assertEquals(2, stapel.top());
	}

	@Test
	public void testStapelApplyToAllQuadrieren() {
		stapel.insert(1);
		stapel.insert(2);
		stapel.insert(3);

		stapel.applyToAll((x) -> { return x*x; });

		assertEquals(9, stapel.top());
		stapel.remove();
		assertEquals(4, stapel.top());
		stapel.remove();
		assertEquals(1, stapel.top());
	}

}
