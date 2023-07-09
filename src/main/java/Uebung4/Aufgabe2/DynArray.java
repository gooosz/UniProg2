package Uebung4.Aufgabe2;

import Uebung4.Aufgabe2.Puffer;
import java.util.NoSuchElementException;

public class DynArray<T> implements Puffer<T>{
	private int capacity;
	private int size;
	private T[] arr;

	public DynArray() {
		capacity = 1;
		size = 0;
		arr = (T[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return capacity;
	}

	@Override
	public T get(int pos) throws NoSuchElementException {
		if (pos < 0 || pos >= size()) {
			throw new NoSuchElementException();
		}
		return arr[pos];
	}

	@Override
	public T set(int pos, T e) throws NoSuchElementException {
		if (pos < 0 || pos >= size()) {
			throw new NoSuchElementException();
		}
		T old = arr[pos];
		arr[pos] = e;
		return old;
	}

	@Override
	public void addFirst(T e) {
		if (needForLargerCapacity()) {
			resizeToLarger();
		}
		// move every element one to the back
		for (int i=size(); i>=1; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = e;
		size++;
	}

	@Override
	public void addLast(T e) {
		if (needForLargerCapacity()) {
			resizeToLarger();
		}
		arr[size()] = e;
		size++;
	}

	@Override
	public T removeFirst() throws NoSuchElementException {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		// move every element one to the front
		T first = get(0);
		for (int i=0; i<size()-1; i++) {
			set(i, get(i+1));
		}
		size--;
		if (needForSmallerCapacity()) {
			resizeToSmaller();
		}
		return first;
	}

	@Override
	public T removeLast() throws NoSuchElementException {
		if (size() == 0) {
			throw new NoSuchElementException();
		}
		T last = get(size()-1);
		arr[size()-1] = null;
		size--;
		if (needForSmallerCapacity()) {
			resizeToSmaller();
		}
		return last;
	}

	private boolean needForLargerCapacity() {
		return size() == capacity();
	}

	private boolean needForSmallerCapacity() {
		return size() * 4 == capacity();
	}

	private void resizeToLarger() {
		resize(2 * capacity());
	}
	private void resizeToSmaller() {
		resize(capacity() / 2);
	}

	private void resize(int capacity) {
		T[] resizedArr = (T[]) new Object[capacity];
		/*
		 * capacity may now be < this.capacity, but > this.size
		 * so check for size individually
		*/
		if (capacity < size()) {
			size = capacity;
		}
		for (int i=0; i<size(); i++) {
			resizedArr[i] = arr[i];
		}
		this.capacity = capacity;
		arr = resizedArr;
	}
}
