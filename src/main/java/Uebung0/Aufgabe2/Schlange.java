package Uebung0.Aufgabe2;

import org.example.Puffer;

import java.util.NoSuchElementException;

public interface Schlange extends Puffer {
	public int front() throws NoSuchElementException;
}
