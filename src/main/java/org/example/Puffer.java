package org.example;

import java.util.NoSuchElementException;

public interface Puffer {
	public boolean isEmpty();
	public int size();
	public int capacity();
	public void insert(int n) throws IllegalStateException;
	public void remove() throws NoSuchElementException;
}
