package Uebung6.Aufgabe1;

import Uebung5.Aufgabe2.Folge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestIntSuchbaum {
    private IntSuchbaum tree;

    @BeforeEach
    public void init() {
        tree = new IntSuchbaum();
    }

    @Test
    public void testInsert() {
        tree.insert(1);
        assertEquals(1, tree.wurzel.data);

        tree.insert(-1);
        assertEquals(-1, tree.wurzel.left.data);

        tree.insert(2);
        assertEquals(2, tree.wurzel.right.data);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.insert(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(tree.contains(1));

        tree.insert(1);
        assertTrue(tree.contains(1));

        tree.insert(-2);
        tree.insert(-1);
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        assertTrue(tree.contains(-2));
        assertTrue(tree.contains(-1));
        assertTrue(tree.contains(0));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, tree.size());

        tree.insert(1);
        assertEquals(1, tree.size());

        tree.insert(1);
        assertEquals(1, tree.size());

        tree.insert(-1);
        tree.insert(2);
        assertEquals(3, tree.size());
    }

    @Test
    public void testToString() {
        assertEquals("", tree.toString());

        tree.insert(1);
        assertEquals("(1)", tree.toString());

        tree.insert(-1);
        assertEquals("((-1)1)", tree.toString());

        tree.insert(2);
        assertEquals("((-1)1(2))", tree.toString());

        tree.insert(3);
        assertEquals("((-1)1(2(3)))", tree.toString());
    }

    @Test
    public void testHoehe() {
        assertEquals(0, tree.hoehe());

        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        assertEquals(3, tree.hoehe());

        tree.remove(1);
        assertEquals(3, tree.hoehe());

        tree.remove(7);
        assertEquals(3, tree.hoehe());

        tree.remove(4);
        assertEquals(2, tree.hoehe());
    }

    @Test
    public void testAusAufgabe() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);

        assertEquals("(((1)2)3((4)5(7)))", tree.toString());
        assertEquals(3, tree.hoehe());
    }

    @Test
    public void testPreorder() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        assertEquals("3 2 1 5 4 7", tree.preorder().toString());
    }

    @Test
    public void testInorder() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        assertEquals("1 2 3 4 5 7", tree.inorder().toString());
    }

    @Test
    public void testPostorder() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        assertEquals("1 2 4 7 5 3", tree.postorder().toString());
    }

    @Test
    public void testBreitensuche() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        Folge<Integer> folge = tree.breitensuche();
        assertEquals("3 2 5 1 4 7", folge.toString());
    }


    @Test
    public void testRemoveLeaf() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);

        tree.remove(1);
        assertEquals("((2)3((4)5(7)))", tree.toString());
        assertEquals(5, tree.size());

        tree.remove(4);
        assertEquals("((2)3(5(7)))", tree.toString());
        assertEquals(4, tree.size());

        tree.remove(7);
        assertEquals("((2)3(5))", tree.toString());
        assertEquals(3, tree.size());
    }

    @Test
    public void testRemoveWurzel() {
        tree.insert (3);
        tree.remove(3);
        assertEquals("", tree.toString());
        tree.insert(3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        assertEquals("(((1)2)3((4)5(7)))", tree.toString());

        tree.remove(3);
        assertEquals("((1)2((4)5(7)))", tree.toString());
        assertEquals(5, tree.size());

        tree.remove(2);
        assertEquals("(((1)4)5(7))", tree.toString());
        assertEquals(4, tree.size());

        tree.remove(5);
        assertEquals("((1)4(7))", tree.toString());
        assertEquals(3, tree.size());
    }

    @Test
    public void testRemoveMitEinemChild() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);

        tree.remove(2);
        assertEquals("((1)3((4)5(7)))", tree.toString());
        assertEquals(5, tree.size());
    }

    @Test
    public void testRemoveMitZweiChildrenLeft() {
        tree.insert (4);
        tree.insert (2);
        tree.insert (6);
        tree.insert (1);
        tree.insert (3);
        tree.insert (7);
        assertEquals("(((1)2(3))4(6(7)))", tree.toString());

        tree.remove(2);
        assertEquals("((1(3))4(6(7)))", tree.toString());
        assertEquals(5, tree.size());
    }

    @Test
    public void testRemoveMitZweiChildrenRight() {
        tree.insert (3);
        tree.insert (2);
        tree.insert (5);
        tree.insert (4);
        tree.insert (1);
        tree.insert (7);
        assertEquals("(((1)2)3((4)5(7)))", tree.toString());

        tree.remove(5);
        assertEquals("(((1)2)3(4(7)))", tree.toString());
        assertEquals(5, tree.size());
    }
}
