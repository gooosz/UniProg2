package Uebung8.Aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EVL<T> implements Puffer<T> {
	ListenElement first = null;

	protected class ListenElement {
		public T data;
		public ListenElement next = null;

		ListenElement(T data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public void addFirst(T e) {
		ListenElement element = new ListenElement(e);
		element.next = this.first;
		this.first = element;
	}
	public T removeLast() {
		if (isEmpty()) {
			// no element
			throw new NoSuchElementException();
		}
		ListenElement temp = first;
		if (temp.next == null) {
			// List with 1 element
			first = null;
			return temp.data;
		}

		while (temp.next.next != null) {
			// Normalfall: suche vorletztes element
			temp = temp.next;
		}
		T d = temp.next.data;
		temp.next = null;
		return d;
	}

	public T getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public T getLast() {
		ListenElement temp = first;
		if (temp == null) return null;

		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.data;
	}

	private ListenElement getFirstListenElement() {
		return first;
	}
	private ListenElement getLastListenElement() {
		ListenElement temp = first;
		if (temp == null) {
			throw new NoSuchElementException();
		}

		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	public void addLast(T e) {
		if (isEmpty()) {
			addFirst(e);
			return;
		}
		ListenElement newLast = new ListenElement(e);
		ListenElement oldLast = getLastListenElement();
		oldLast.next = newLast;
	}

	public boolean contains(T e) {
		ListenElement temp = first;
		while (!temp.data.equals(e) && temp.next != null) {
			temp = temp.next;
		}
		// if list doesn't contain e, temp should now be last element so check for it
		// else temp holds e
		return temp.data.equals(e);
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		int size = 1;
		ListenElement temp = first;
		while (temp.next != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	@Override
	public int capacity() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void insert(T n) throws IllegalStateException {
		addLast(n);
	}

	@Override
	public void remove() throws NoSuchElementException {
		removeLast();
	}

	public String toString() {
		if (getFirstListenElement() == null) {
			return "";
		}

		ListenElement temp = getFirstListenElement();
		String s = temp.data.toString();
		while (temp.next != null) {
			temp = temp.next;
			s += "-" + temp.data.toString();
		}
		return s;
	}

	public void zip(EVL<T> other) {
		if (other.isEmpty()) {
			return;
		}
		if (this.isEmpty()) {
			// this = other
			while (!other.isEmpty()) {
				this.addLast(other.getFirst());
				other.first = other.first.next;
			}
			return;
		}

		// zip
		// append this reversed to other except this.first
		// no need for i++ as size decreases in loop
		for (int i=0; i<this.size()-1;) {
			T temp = this.removeLast();
			other.addLast(temp);
		}

		for (int i=0; !other.isEmpty() && i <= other.size()-this.size();) {
			this.addLast(other.getFirst());
			other.first = other.first.next;
			this.addLast(other.getLast());
			other.removeLast();
		}
		// append the rest of other to this
		while (!other.isEmpty()) {
			this.addLast(other.getFirst());
			other.first = other.first.next;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new EVLIterator();
	}

	private class EVLIterator implements Iterator<T> {
		ListenElement node = first;

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T current = node.data;
			node = node.next;
			return current;
		}
	}
}
