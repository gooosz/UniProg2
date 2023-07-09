package Uebung7.Aufgabe3;

import Uebung7.Aufgabe2.Boxer;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator<Boxer> {
	@Override
	public int compare(Boxer b1, Boxer b2) {
		return b1.getGewicht() - b2.getGewicht();
	}
}
