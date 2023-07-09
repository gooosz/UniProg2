package Uebung3.Aufgabe5;

import java.util.NoSuchElementException;

public class RDVL<T> {
	private ListenElement entry;

	class ListenElement {
		T data;
		ListenElement prev = null;
		ListenElement next = null;
		ListenElement(T data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return entry == null;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		int size = 1;
		ListenElement temp = entry;
		/*
		 * compare memory locations of temp and entry specifically
		 * because the RDVL might store the same T many times,
		 * so, the "end" of RDVL is it's start value entry
		 */
		while (temp.next != entry) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	public void add(T e) {
		ListenElement newElement = new ListenElement(e);
		if (isEmpty()) {
			entry = newElement;
			entry.prev = entry;
			entry.next = entry;
			return;
		}
		newElement.prev = entry.prev;
		newElement.next = entry;

		entry.prev.next = newElement;
		entry.prev = newElement;
	}

	/**
	 * removes entry
	 * @return data of removed entry
	 */
	public T remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (size() == 1) {
			entry.prev = null;
			entry.next = null;
			ListenElement temp = entry;
			entry = null;
			return temp.data;
		}
		entry.prev.next = entry.next;
		entry.next = entry.prev;
		T temp = entry.data;
		entry = entry.next;
		return temp;
	}

	public T element() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return entry.data;
	}

	public void next(int s) {
		for (int i=0; i<s; i++) {
			entry = entry.next;
		}
	}

	public void prev(int s) {
		for (int i=0; i<s; i++) {
			entry = entry.prev;
		}
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		String result = "-" + entry.data;
		ListenElement initEntry = entry;
		next(1);
		while (entry != initEntry) {
			result += "-" + element();
			next(1);
		}
		result += "-";
		return result;
	}
}
