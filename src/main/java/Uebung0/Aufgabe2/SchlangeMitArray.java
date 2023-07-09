package Uebung0.Aufgabe2;

import org.example.Schlange;

import java.util.NoSuchElementException;

public class SchlangeMitArray implements Schlange {
	private int[] array;
	private int size;

	public SchlangeMitArray(int maxGroesse) {
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
		// insert into stapel FIFO
		// [1, 0, 0, 0] -> [1, 1, 0, 0]
		array[size] = n;
		size++;
	}

	@Override
	public void remove() throws NoSuchElementException {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		// remove FIFO
		// Aufruecken
		for (int i=0; i<size()-1; i++) {
			array[i] = array[i+1];
		}
		size--;
	}

	@Override
	public int front() throws NoSuchElementException{
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return array[0];
	}
}
