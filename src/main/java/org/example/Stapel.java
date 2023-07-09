package org.example;

import java.util.NoSuchElementException;

public interface Stapel extends Puffer {
	public int top() throws NoSuchElementException;
}
