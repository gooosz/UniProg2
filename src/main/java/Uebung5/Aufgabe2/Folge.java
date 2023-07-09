package Uebung5.Aufgabe2;

import Uebung2.Aufgabe3.Puffer;

//

public interface Folge<T> extends Puffer<T> {
	public T get(int pos) throws IndexOutOfBoundsException;
	public T set(int pos, T e) throws IndexOutOfBoundsException;
	public T remove(int pos) throws IndexOutOfBoundsException;
	public void insert(int pos, T e) throws IndexOutOfBoundsException;
}