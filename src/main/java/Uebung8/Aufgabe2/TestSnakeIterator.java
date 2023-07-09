package Uebung8.Aufgabe2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSnakeIterator {
    private SnakeIterator2DArray<Integer> iter;
    private Integer[][] a;

    @BeforeEach
    public void init() {
        a = new Integer[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        iter = new SnakeIterator2DArray<>(a);
    }

    @Test
    public void testNext() {
        assertEquals(1, a[0][0]);
        assertEquals(2, iter.next());
        assertEquals(3, iter.next());
        assertEquals(4, iter.next());

        assertEquals(8, iter.next());
        assertEquals(7, iter.next());
        assertEquals(6, iter.next());
        assertEquals(5, iter.next());

        assertEquals(9, iter.next());
        assertEquals(10, iter.next());
        assertEquals(11, iter.next());
        assertEquals(12, iter.next());
        assertFalse(iter.hasNext());
    }
}
