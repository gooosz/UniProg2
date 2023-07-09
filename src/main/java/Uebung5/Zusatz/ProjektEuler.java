package Uebung5.Zusatz;

import Uebung4.Aufgabe2.DynArray;

public class ProjektEuler {
	public static void main(String[] args) {
		aufgabe();
	}

	public static void aufgabe() {
		DynArray<Integer> fib = initFib();
		System.out.println("Summe: " + sumOfGeradeDynArray(fib));
		System.out.println("Anzahl: " + anzahlGerade(fib));
	}

	public static int anzahlGerade(DynArray<Integer> dyn) {
		int anzahl = 0;
		for (int i=0; i<dyn.size(); i++) {
			if (dyn.get(i) % 2 == 0) {
				anzahl++;
			}
		}
		return anzahl;
	}

	public static DynArray<Integer> initFib() {
		return initFib(Integer.MAX_VALUE);
	}
	public static DynArray<Integer> initFib(int max) {
		DynArray<Integer> fib = new DynArray<>();
		fib.addLast(1); fib.addLast(2);
		while (sumOfGeradeDynArray(fib) <= 4_000_000 && fib.size() < max) {
			int nextFib = nextFib(fib.get(fib.size()-1), fib.get(fib.size()-2));
			fib.addLast(nextFib);
		}
		return fib;
	}

	public static int nextFib(int a, int b) {
		return a+b;
	}
	public static int sumOfGeradeDynArray(DynArray<Integer> dyn) {
		int sum = 0;
		for (int i=0; i<dyn.size(); i++) {
			if (dyn.get(i) % 2 == 0) {
				sum += dyn.get(i);
			}
		}
		return sum;
	}
}
