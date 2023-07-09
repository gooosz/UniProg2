package Uebung4.Aufgabe4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestTemperaturSensor {
	private Temperatursensor ts;

	@BeforeEach
	public void init() {
		ts = new Temperatursensor();
	}

	@Test
	public void testNeueMessungOhneUeberschreiben() {
		ts.neueMessung(1.f);
		assertEquals(1.f, ts.aktuelleTemperatur());

		ts.neueMessung(2.f);
		assertEquals(2.f, ts.aktuelleTemperatur());
	}

	@Test
	public void testNeueMessungMitUeberschreiben() {
		for (float f=0.f; f<24.f; f+=1.f) {
			ts.neueMessung(f);
		}
		assertEquals(23.f, ts.aktuelleTemperatur());
		// ueberschreiben happens now
		ts.neueMessung(24.f);
		assertEquals(24.f, ts.aktuelleTemperatur());
	}

	@Test
	public void testDurchschnittstemperatur() {
		ts.neueMessung(1.f);
		assertEquals(1.f, ts.durchschnittsTemperatur());

		ts.neueMessung(2.f);
		assertEquals(1.5f, ts.durchschnittsTemperatur());

		ts.neueMessung(6.f);
		assertEquals(3.f, ts.durchschnittsTemperatur());
	}

	@Test
	public void testReset() {
		for (float f=0.f; f<24.f; f+=1.f) {
			ts.neueMessung(f);
		}
		ts.reset();
		assertEquals(Float.NaN, ts.aktuelleTemperatur());
	}
}
