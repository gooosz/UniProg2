package Uebung4.Zusatz;

public class ProjektEuler {
	public static void main(String[] args) {
		System.out.println(problem5(20));
	}
	public static int problem5(int range) {
		int kgv = 1;
		for (; ; kgv++) {
			boolean isDivisibleByRange = true;
			for (int i=1; i<=range; i++) {
				if (kgv % i != 0) {
					isDivisibleByRange = false;
					break;
				}
			}
			if (isDivisibleByRange) {
				break;
			}
		}
		return kgv;
	}

	public static int kgV(int a, int b) {
		return (a * b) - ggT(a, b);
	}

	public static int ggT(int a, int b) {
		if (a == 0) {
			return Math.abs(b);
		}
		if (b == 0) {
			return Math.abs(a);
		}
		do {
			int h = a % b;
			a = b;
			b = h;
		} while (b != 0);
		return Math.abs(a);
	}
}
