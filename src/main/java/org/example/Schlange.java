package org.example;

import java.util.NoSuchElementException;

public interface Schlange extends Puffer {
	public int front() throws NoSuchElementException;
}
