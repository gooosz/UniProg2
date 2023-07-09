package Uebung2.Zusatz;

public class ProjektEuler {
	public static int summe3Und5(int range) {
		int sum = 0;
		for (int i=3; i<range; i++) {
			if (i % 3 == 0 | i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(summe3Und5(1000));
	}
}
