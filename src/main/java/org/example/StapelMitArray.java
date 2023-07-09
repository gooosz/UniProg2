package org.example;

import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel{
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
		return array[size];
	}
}
