package Uebung2.Aufgabe3;

import java.util.NoSuchElementException;

public interface Puffer<T> {
	public boolean isEmpty();
	public int size();
	public int capacity();
	public void insert(T n) throws IllegalStateException;
	public void remove() throws NoSuchElementException;
}
