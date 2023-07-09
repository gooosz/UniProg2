package Uebung2.Aufgabe3;

import java.util.NoSuchElementException;

public interface Schlange<T> extends Puffer<T> {
	public T front() throws NoSuchElementException;
}
