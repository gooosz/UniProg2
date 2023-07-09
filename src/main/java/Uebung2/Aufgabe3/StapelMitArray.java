package Uebung2.Aufgabe3;

import Uebung2.Aufgabe3.Funktion;

import java.util.NoSuchElementException;

public class StapelMitArray<T> implements Stapel<T> {
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public StapelMitArray(int maxGroesse) {
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
		array[size-1] = null;
		size--;
	}

	@Override
	public T top() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return array[size-1];
	}

	public void applyToAll(Funktion<T> f) {
		for (int i=size-1; i>=0; i--) {
			array[i] = f.auswerten(array[i]);
		}
	}
}
