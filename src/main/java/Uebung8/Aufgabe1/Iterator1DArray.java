package Uebung8.Aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {
    private T[] arr;
    private int ptr;
    private int end;    // exclusive

    /**
     * iterates from front to back of arr
     * @param arr
     */
    public Iterator1DArray(T[] arr) {
        this(arr, 0, arr.length);
    }

    public Iterator1DArray(T[] arr, int start) {
        this(arr, start, arr.length);
    }

    public Iterator1DArray(T[] arr, int start, int end) {
        // prevent ArrayOutOfBoundsException
        if (end > arr.length) {
            end = arr.length;
        }
        this.arr = arr;
        this.ptr = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return ptr < end;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr[ptr++];
    }
}
