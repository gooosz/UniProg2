package Uebung7.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAcat {
	@Test
	public void testNullStellePolynom() {
		double nullstelle = -1;
		//double berechnet = Acat.nullstelle(x -> x*x-2*x-3, -i, i);
		double berechnet = Acat.nullstelle(x -> x*x-2*x-3, -2, 2);
		System.out.println("Polynom1");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStellePolynom2() {
		double nullstelle = -2;
		//double berechnet = Acat.nullstelle(x -> x*x-2*x-3, -i, i);
		double berechnet = Acat.nullstelle(x -> x*x -4, -5, 5);
		System.out.println("Polynom2");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStelleExp() {
		double nullstelle = 0;
		double berechnet = Acat.nullstelle(x -> Math.exp(x) - 1, -2, 2);
		System.out.println("Exp");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStelleSin() {
		double nullstelle = 0;
		double berechnet = Acat.nullstelle(Math::sin, -2, 2);
		System.out.println("Sin");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStelleCos() {
		double nullstelle = -1.5707963268;
		double berechnet = Acat.nullstelle(Math::cos, -2, 2);
		System.out.println("Cos");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStelleTan() {
		double nullstelle = 0.0;
		double berechnet = Acat.nullstelle(Math::tan, -2, 2);
		System.out.println("Tan");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStelleSinh() {
		double nullstelle = 0.0;
		double berechnet = Acat.nullstelle(Math::sinh, -2, 2);
		System.out.println("Sinh");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}

	@Test
	public void testNullStelleCosh() {
		double nullstelle = -1.316958;
		double berechnet = Acat.nullstelle(x -> Math.cosh(x) - 2, -2, 2);
		System.out.println("Cosh");
		System.out.println("tatsaechliche Nullstelle: " + nullstelle);
		System.out.println("berechnete Nullstelle: " + berechnet);
		double anforderung = Math.abs(berechnet - nullstelle);
		assertTrue(anforderung <= 1e-6);
	}
}
