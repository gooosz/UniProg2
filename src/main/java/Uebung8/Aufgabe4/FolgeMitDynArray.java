package Uebung8.Aufgabe4;

import Uebung8.Aufgabe4.DynArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T> {
	private DynArray<T> array;

	public FolgeMitDynArray() {
		array = new DynArray<>();
	}

	@Override
	public boolean isEmpty() {
		return array.size() == 0;
	}

	@Override
	public int size() {
		return array.size();
	}

	@Override
	public int capacity() {
		return array.capacity();
	}

	@Override
	public void insert(T e) throws IllegalStateException {
		array.addLast(e);
	}

	@Override
	public void remove() throws NoSuchElementException {
		array.removeLast();
	}

	@Override
	public T get(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= array.size()) {
			throw new IndexOutOfBoundsException();
		}
		try {
			return array.get(pos);
		} catch (NoSuchElementException n) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T set(int pos, T e) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= array.size()) {
			throw new IndexOutOfBoundsException();
		}
		try {
			return array.set(pos, e);
		} catch (NoSuchElementException n) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public T remove(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= array.size()) {
			throw new IndexOutOfBoundsException();
		}
		T old = array.get(pos);
		DynArray<T> temp = new DynArray<>();
		for (int i=array.size()-1; i>pos; i--) {
			temp.addFirst(array.removeLast());
		}
		// removes the element at pos
		array.removeLast();
		// append all other elements again
		for (int i=0; i<temp.size(); i++) {
			array.addLast(temp.get(i));
		}
		return old;
	}

	@Override
	public void insert(int pos, T e) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= array.size()) {
			throw new IndexOutOfBoundsException();
		}
		T old = array.set(pos, e);
		for (int i=pos; i<array.size()-1; i++) {
			old = array.set(i+1, old);
		}
		// last one gets appended
		assert(old != null);
		insert(old);
	}

	@Override
	public String toString() {
		String s = "";
		for (int i=0; i<array.size(); i++) {
			s += array.get(i);
			if (i < array.size()-1) {
				s += " ";
			}
		}
		return s;
	}

	@Override
	public Iterator<T> iterator() {
		return array.iterator();
	}
}
