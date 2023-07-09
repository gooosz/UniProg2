package Uebung0.Aufgabe2;

import org.example.Puffer;

import java.util.NoSuchElementException;

public interface Stapel extends Puffer {
	public int top() throws NoSuchElementException;
}
