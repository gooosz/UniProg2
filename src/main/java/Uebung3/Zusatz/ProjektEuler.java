package Uebung3.Zusatz;

public class ProjektEuler {
	public static int diff(int range) {
		int squareOfSum = 0;
		int sumOfSquares = 0;
		for (int i=1; i<=range; i++) {
			squareOfSum += i;
			sumOfSquares += Math.pow(i, 2);
		}
		squareOfSum = (int) Math.pow(squareOfSum, 2);
		return squareOfSum - sumOfSquares;
	}

	public static void main(String[] args) {
		System.out.println(diff(100));
	}

}
