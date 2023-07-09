package Uebung8.Aufgabe4;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T>, Iterable<T> {
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	private EVL<T> list;

	public SchlangeMitEVL() {
		list = new EVL<>();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public int capacity() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void insert(T n) throws IllegalStateException {
		list.addLast(n);
	}


	@Override
	public void remove() throws NoSuchElementException {
		list.removeLast();
	}

	@Override
	public T front() throws NoSuchElementException {
		return list.getFirst();
	}
}
