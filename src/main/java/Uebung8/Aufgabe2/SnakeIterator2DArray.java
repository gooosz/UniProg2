package Uebung8.Aufgabe2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SnakeIterator2DArray<T> implements Iterator<T> {
    private T[][] arr;
    private int[] ptr;  // [0]: row, [1]: col

    public SnakeIterator2DArray(T[][] arr) {
        this.arr = arr;
        this.ptr = new int[]{0, 0};
    }

    @Override
    public boolean hasNext() {
        int row = ptr[0];
        int col = ptr[1];

        if (row % 2 == 0) {
            // iterate front to back
            if (row+1 >= arr.length && col == arr[row].length-1) {
                return false;
            }
        } else {
            // iterate back to front
            if (row+1 >= arr.length && col == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        setPtrNext();
        return arr[ptr[0]][ptr[1]];
    }

    private void setPtrNext() {
        if (ptr[0] % 2 == 0) {
            // iterate front to back
            ptr[1]++;
            if (ptr[1] >= arr[0].length) {
                // wrap around
                ptr[1] = arr[ptr[0]].length-1;
                ptr[0]++;
            }
        } else {
            // iterate back to front
            ptr[1]--;
            if (ptr[1] < 0) {
                // wrap around
                ptr[1] = 0;
                ptr[0]++;
            }
        }
    }


    public static void main(String[] args) {
        Integer[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        SnakeIterator2DArray<Integer> iter = new SnakeIterator2DArray<>(a);
    }
}
