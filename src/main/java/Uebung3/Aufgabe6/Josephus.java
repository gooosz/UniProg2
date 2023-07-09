package Uebung3.Aufgabe6;

import Uebung3.Aufgabe5.RDVL;

public class Josephus {
	private static RDVL<Integer> kreis;
	public static int loese(int n, int k) {
		kreis = new RDVL<>();
		for (int i=1; i<=n; i++) {
			kreis.add(i);
		}
		assert(kreis.element() == 1);
		while (kreis.size() > 1) {
			// goto previous
			kreis.prev(1);
			kreis.next(k);
			kreis.remove();
		}
		return kreis.element();
	}

	public static void main(String[] args) {
		System.out.println(loese(5, 2));
	}
}
