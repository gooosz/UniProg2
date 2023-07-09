package Uebung3.Aufgabe1;


import java.util.List;
import java.util.NoSuchElementException;

public class EVL<T> {
	ListenElement first = null;

	class ListenElement {
		T data;
		ListenElement next = null;

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
}








