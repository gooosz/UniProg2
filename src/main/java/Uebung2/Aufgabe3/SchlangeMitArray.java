package Uebung2.Aufgabe3;

import java.util.NoSuchElementException;

public class SchlangeMitArray<T> implements Schlange<T> {
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public SchlangeMitArray(int maxGroesse) {
		array = (T[]) new Object[maxGroesse];
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
	public void insert(T n) throws IllegalStateException {
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
	public T front() throws NoSuchElementException{
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return array[0];
	}
}
