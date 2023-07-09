package Uebung5.Aufgabe4;

import Uebung2.Aufgabe3.Schlange;
import Uebung4.Aufgabe3.RingBuffer;

import java.util.NoSuchElementException;

public class SchlangeMitRing<T> implements Schlange<T> {
	private RingBuffer<T> ring;
	public SchlangeMitRing(int capacity) {
		ring = new RingBuffer<>(capacity);
	}

	@Override
	public boolean isEmpty() {
		return ring.size() == 0;
	}

	@Override
	public int size() {
		return ring.size();
	}

	@Override
	public int capacity() {
		return ring.capacity();
	}

	@Override
	public void insert(T e) throws IllegalStateException {
		ring.addLast(e);
	}

	@Override
	public void remove() throws NoSuchElementException {
		ring.removeLast();
	}

	@Override
	public T front() throws NoSuchElementException {
		return ring.get(0);
	}
}
