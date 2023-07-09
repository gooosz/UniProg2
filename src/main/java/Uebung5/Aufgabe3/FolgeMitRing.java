package Uebung5.Aufgabe3;

import Uebung4.Aufgabe3.RingBuffer;
import Uebung5.Aufgabe2.Folge;

import java.util.NoSuchElementException;

public class FolgeMitRing<T> implements Folge<T> {
	private RingBuffer<T> ring;
	public T get(int pos) throws IndexOutOfBoundsException {
		return ring.get(pos);
	}
	public T set(int pos, T e) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= ring.size()) {
			throw new IndexOutOfBoundsException();
		}
		return ring.set(pos, e);
	}
	public T remove(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= ring.size()) {
			throw new IndexOutOfBoundsException();
		}
		// run in circle, so that start pointer will be at same position as before
		return ring.removeFirst();
	}
	public void insert(int pos, T e) throws IndexOutOfBoundsException {

	}
	public boolean isEmpty() {
		return ring.size() == 0;
	}
	public int size() {
		return ring.size();
	}
	public int capacity() {
		return ring.capacity();
	}
	public void insert(T e) throws IllegalStateException {
		ring.addLast(e);
	}
	public void remove() throws NoSuchElementException {
		ring.removeLast();
	}
}
