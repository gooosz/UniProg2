package Uebung5.Aufgabe3;

import Uebung4.Aufgabe2.DynArray;
import Uebung5.Aufgabe2.Folge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestFolgeMitDynArray {
    private FolgeMitDynArray<Integer> folge;

    @BeforeEach
    public void init() {
        folge = new FolgeMitDynArray<>();
    }

    @Test
    public void testInsert() {
        folge.insert(1);
        assertEquals(1, folge.get(0));

        folge.insert(2);
        assertEquals(2, folge.get(1));
    }

    @Test
    public void testGetter() {
        assertThrows(IndexOutOfBoundsException.class, ()->folge.get(0));

        folge.insert(1);
        assertEquals(1, folge.get(0));
    }

    @Test
    public void testGetAtPos() {
        folge.insert(1);
        assertThrows(IndexOutOfBoundsException.class,() ->folge.get(1));
    }

    @Test
    public void testToString() {
        assertEquals("", folge.toString());

        for (int i=1; i<=5; i++) {
            folge.insert(i);
        }
        assertEquals("1 2 3 4 5", folge.toString());
    }

    @Test
    public void testInsertAtPos() {
        assertEquals("", folge.toString());
        for (int i=1; i<=5; i++) {
            folge.insert(i);
        }
        assertEquals("1 2 3 4 5", folge.toString());

        folge.insert(0, 0);
        assertEquals("0 1 2 3 4 5", folge.toString());

        folge.insert(1, -1);
        assertEquals("0 -1 1 2 3 4 5", folge.toString());

        folge.insert(6, -1);
        assertEquals("0 -1 1 2 3 4 -1 5", folge.toString());

        assertThrows(IndexOutOfBoundsException.class,
                ()->folge.insert(folge.size(), -1));
    }

    @Test
    public void testRemove() {
        assertThrows(NoSuchElementException.class, () -> folge.remove());

        for (int i=1; i<=5; i++) {
            folge.insert(i);
        }
        assertEquals("1 2 3 4 5", folge.toString());

        folge.remove(0);
        assertEquals("2 3 4 5", folge.toString());

        folge.remove(1);
        assertEquals("2 4 5", folge.toString());

        folge.remove(2);
        assertEquals("2 4", folge.toString());
    }
}
