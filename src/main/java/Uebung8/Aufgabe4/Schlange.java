package Uebung8.Aufgabe4;

import java.util.NoSuchElementException;

public interface Schlange<T> extends Puffer<T>, Iterable<T> {
    public T front() throws NoSuchElementException;
}
