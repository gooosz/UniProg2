package Uebung4.Aufgabe2;

import java.util.NoSuchElementException;

public interface Puffer<T> {
	public int size();
	public int capacity();
	public T get(int pos) throws NoSuchElementException;
	public T set(int pos, T e) throws NoSuchElementException;
	public void addFirst(T e);
	public void addLast(T e);
	public T removeFirst() throws NoSuchElementException;
	public T removeLast() throws NoSuchElementException;
}
