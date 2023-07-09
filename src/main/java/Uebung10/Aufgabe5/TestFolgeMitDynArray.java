package Uebung10.Aufgabe5;

import Uebung0.Aufgabe3.*;
import Uebung8.Aufgabe4.DynArray;
import Uebung8.Aufgabe4.Puffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFolgeMitDynArray {
    private FolgeMitDynArray<Person> folge;

    @BeforeEach
    public void init() {
        folge = new FolgeMitDynArray<>();
    }

    @Test
    public void testAddAllPerson(){
        Puffer<Person> pp = new DynArray<>();
        Person p1 = new Student("Student1", "Vorname1", 1000);
        pp.insert(p1);
        folge.addAll(pp);
        assertEquals("Student1, Vorname1 1000",
                folge.toString());
    }

    @Test
    public void testAddAllBoxer() {
        Puffer<Boxer> pb = new DynArray<>();
        Boxer b1 = new Boxer("Boxer", "Vorname", 80);
        pb.insert(b1);
        folge.addAll(pb);
        assertEquals("Boxer, Vorname",
                pb.toString());

    }
}
