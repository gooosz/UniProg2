package Uebung6.Zusatz;

import Uebung4.Aufgabe2.DynArray;

public class ProjektEuler {
	public static void main(String[] args) {
		System.out.println(groessterPrimfaktor(600851475143L));
	}

	public static boolean istPrim(long n) {
		for (long i=2; i*i<=n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static DynArray<Long> primes(Long n) {
		DynArray<Long> primes = new DynArray<>();
		for (long i=2; i*i<=n; i++) {
			if (istPrim(i)) {
				primes.addLast(i);
			}
		}
		return primes;
	}

	public static DynArray<Long> primfaktoren(long n) {
		DynArray<Long> primes = primes(n);
		DynArray<Long> primfaktoren = new DynArray<>();
		return primfaktoren(n, primes, primfaktoren, 0);
	}
	public static DynArray<Long> primfaktoren(long n, DynArray<Long> primes, DynArray<Long> primfaktoren, int index) {
		long y;
		if (!istPrim(n)) {
			if (n % primes.get(index) == 0) {
				primfaktoren.addLast(primes.get(index));
				y = n / primes.get(index);
				primfaktoren(y, primes, primfaktoren, index);
			} else {
				index++;
				primfaktoren(n, primes, primfaktoren, index);
			}
		} else {
			primfaktoren.addLast(n);
		}
		return primfaktoren;
	}

	public static long groessterPrimfaktor(long n) {
		DynArray<Long> primfaktoren = primfaktoren(n);
		return primfaktoren.get(primfaktoren.size()-1);
	}

	public static String dynArrayToString(DynArray<Long> a) {
		String s = "[";
		for (int i=0; i<a.size(); i++) {
			s += a.get(i);
			if (i < a.size()-1) {
				s += ",";
			}
		}
		s += "]";
		return s;
	}


}
