package Uebung4.Aufgabe3;

import Uebung4.Aufgabe2.Puffer;

import java.util.NoSuchElementException;

public class RingBuffer<T> implements Puffer<T> {
	private int size;
	private int capacity;
	private T[] arr;
	private int start;	// index of start element, %= size

	public RingBuffer(int capacity) {
		this.start = 0;
		this.size = 0;
		this.capacity = capacity;
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

	/**
	 *
	 * @param pos
	 * @return element at pos relative to start
	 * @throws NoSuchElementException
	 */
	@Override
	public T get(int pos) throws NoSuchElementException {
		// gets relative to start
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int index = (start + pos) % capacity();
		if (index < 0) {
			index = (capacity() - Math.abs(index)) % capacity();
		}
		return arr[index];
	}

	@Override
	public T set(int pos, T e) throws NoSuchElementException {
		// gets relative to start
		// only allowed to overwrite what has been inserted before
		int index = (start + pos) % capacity();
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (index < 0) {
			index = capacity() - Math.abs(index);
		}
		T old = arr[index];
		arr[index] = e;
		return old;
	}

	/**
	 * inserted element is oldest in ringbuffer
	 * @param e
	 * @throws RingIsFullException
	 */
	@Override
	public void addFirst(T e) throws RingIsFullException {
		if (size() == capacity()) {
			throw new RingIsFullException();
		}
		if (isEmpty()) {
			arr[start] = e;
		} else {
			// next index, wraps around when start+1 == capacity()
			start = (start + capacity() - 1) % capacity();
			arr[start] = e;
		}
		size++;
	}

	/** inserted element is now the youngest in ringbuffer
	 * @param e
	 * @throws RingIsFullException
	 */
	@Override
	public void addLast(T e) throws RingIsFullException {
		if (size() == capacity()) {
			throw new RingIsFullException();
		}
		arr[(start + size()) % capacity()] = e;
		size++;
	}

	/**
	 * removes oldest element in ringbuffer
	 * @return removed value
	 * @throws NoSuchElementException
	 */
	@Override
	public T removeFirst() throws NoSuchElementException {
		// just increase start pointer, no "memory free"
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T old = arr[start];
		start = (start + 1) % capacity();
		size--;
		return old;
	}

	/**
	 * removes latest added element
	 * @return deleted element
	 * @throws NoSuchElementException
	 */
	@Override
	public T removeLast() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T old = arr[(start + capacity() - 1) % capacity()];
		size--;
		return old;
	}

	private boolean isFull() {
		return size() == capacity;
	}

	private boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i=start; i<start+capacity(); i++) {
			int index = i % capacity();
			if (arr[index] == null) {
				s += "_";
			} else {
				s += arr[index].toString();
			}

			if (i < start+capacity()-1) {
				s += "-";
			}
		}
		return s;
	}
}
