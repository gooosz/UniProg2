package Uebung7.Test;

import Uebung2.Aufgabe3.Funktion;

public class Acat {
	public static double eval(Funktion<Double> f, double x) {
		return f.auswerten(x);
	}

	public static double nullstelle(Funktion<Double> f, double a, double b) {
		double genauigkeit = 1e-6;
		double delta = Math.abs(b - a);
		double mid = (a + b) / 2;
		if (delta <= genauigkeit || Math.abs(eval(f, mid)) < genauigkeit) {
			return mid;
		}

		// Intervallschachtelung
		if (eval(f, a) * eval(f, mid) < 0) {
			// Nullstelle in Intervall [a,ab2]
			return nullstelle(f, a, mid);
		}
		// Nullstelle in Intervall [ab2,b]
		return nullstelle(f, mid, b);
	}
}
