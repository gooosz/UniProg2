package Uebung1.Aufgabe3;

import org.example.Stapel;

import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel {
	private int[] array;
	private int size;

	public StapelMitArray(int maxGroesse) {
		array = new int[maxGroesse];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return array.length;
	}

	@Override
	public void insert(int n) throws IllegalStateException {
		if (size == capacity()) {
			throw new IllegalStateException();
		}
		// insert into stapel LIFO
		array[size] = n;
		size++;
	}

	@Override
	public void remove() throws NoSuchElementException {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		// remove from stapel LIFO
		array[size-1] = 0;
		size--;
	}

	@Override
	public int top() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return array[size-1];
	}

	public void applyToAll(Funktion f) {
		for (int i=size-1; i>=0; i--) {
			array[i] = f.auswerten(array[i]);
		}
	}

	public static void main(String[] args) {
		final int matheCP = 6;
		final int logikCP = 3;
		final int eidpCP = 9;
		final int tiCP = 9;
		final int bwlCP = 3;

		double logik = 1.0 / logikCP;
		double eidp = 1.7 / eidpCP;

		double schnitt = (logik + eidp) / 2;
		System.out.println("Logik: " + logik);
		System.out.println("EidP: " + eidp);
		System.out.println("Schnitt: " + schnitt);
	}
}
