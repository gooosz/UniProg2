package Uebung3.Aufgabe3;

import Uebung2.Aufgabe3.SchlangeMitArray;
import Uebung3.Aufgabe2.SchlangeMitEVL;

public class TimeTestSchlange {
	public static void main(String[] args) {
		SchlangeMitArray<Integer> array = new SchlangeMitArray<>(100000);
		SchlangeMitEVL<Integer> evl = new SchlangeMitEVL<>();

		long start, finish, elapsed;
		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++) {
			array.insert(i);
		}
		for (int i=0; i<100000; i++) {
			array.remove();
		}
		finish = System.currentTimeMillis();
		elapsed = finish - start;
		System.out.println("SchlangeMitArray: " + elapsed + "ms");

		start = System.currentTimeMillis();
		for (int i=0; i<100000; i++) {
			evl.insert(i);
		}
		for (int i=0; i<100000; i++) {
			evl.remove();
		}
		finish = System.currentTimeMillis();
		elapsed = finish - start;
		System.out.println("SchlangeMitEVL: " + elapsed + "ms");
	}
}
