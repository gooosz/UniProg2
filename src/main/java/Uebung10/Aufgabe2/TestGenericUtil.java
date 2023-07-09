package Uebung10.Aufgabe2;

import Uebung8.Aufgabe4.DynArray;
import Uebung8.Aufgabe4.Folge;
import Uebung8.Aufgabe4.Puffer;
import Uebung8.Aufgabe4.SchlangeMitEVL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGenericUtil {
    /*
     * Java Hierarchy:
     *
     * Number
     * -Integer
     * -Double
     *
     * String
     *
    */
    private Puffer<Integer> i1;
    private Puffer<Integer> i2;
    private Puffer<Double> d1;
    private Puffer<Number> n1;
    private Puffer<String> s1;

    private Comparator<Integer> icomp;
    private Comparator<Number> ncomp;

    @BeforeEach
    public void init() {
        i1 = new DynArray<>();
        i1.insert(10);
        i1.insert(11);
        i1.insert(12);

        i2 = new DynArray<>();
        i2.insert(20);
        i2.insert(21);
        i2.insert(22);

        d1 = new DynArray<>();
        d1.insert(1.0);
        d1.insert(2.0);
        d1.insert(3.0);

        s1 = new DynArray<>();
        s1.insert("S1");
        s1.insert("S2");
        s1.insert("S3");

        icomp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1.equals(i2)) {
                    return 0;
                }
                return (i1 < i2) ? 1 : -1;
            }
        };

        ncomp = new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                return new BigDecimal(n1.toString())
                        .compareTo(new BigDecimal(n2.toString()));
            }
        };
    }

    @Test
    public void testGetMinimaIntegerInteger() {
        Folge<Integer> min = GenericUtil.getMinima(i1, i2, icomp);
        // icomp returns max not min so this returns all the max from i1, i2
        // which are all in i2
        DynArray<Integer> mind = new DynArray<>();
        for (var m : min) {
            mind.insert(m);
        }
        assertEquals("20 21 22", mind.toString());
    }

    @Test
    public void testGetMinimaIntegerDouble() {

    }
}
