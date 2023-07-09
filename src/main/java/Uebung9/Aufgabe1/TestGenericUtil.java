package Uebung9.Aufgabe1;

import Uebung8.Aufgabe4.DynArray;
import Uebung8.Aufgabe4.Puffer;
import Uebung8.Aufgabe4.SchlangeMitEVL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGenericUtil {
    private Puffer<Integer> p1;
    private Puffer<Integer> p2;

    @BeforeEach
    public void init() {
        p1 = new DynArray<>();
        p2 = new DynArray<>();

        p1.insert(1);
        p1.insert(4);
        p2.insert(2);
        p2.insert(6);
    }

    @Test
    public void testGetMinima() {
        // should result in
        // 1-4
        Puffer<Integer> min = GenericUtil.getMinima(p1, p2);
        System.out.println("size: " + min.size());
        GenericUtil.printAll(min);
    }

    @Test
    public void testGetMinimaEmpty() {
        // should result in
        //
        Puffer<String> s1 = new DynArray<>();
        Puffer<String> s2 = new DynArray<>();
        Puffer<String> min = GenericUtil.getMinima(s1, s2);
        assertEquals(0, min.size());
        GenericUtil.printAll(min);
    }

    @Test
    public void testPrintAll() {
        /*
          * should print:
          * 1
          * 4
        */
        GenericUtil.printAll(p1);
    }

}
