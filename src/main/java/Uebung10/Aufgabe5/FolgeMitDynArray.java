package Uebung10.Aufgabe5;

import Uebung8.Aufgabe4.Puffer;

import java.util.Iterator;

public class FolgeMitDynArray<T> extends Uebung8.Aufgabe4.FolgeMitDynArray<T> {
    public void addAll(Puffer<? extends T> p) {
        for (T el : p) {
            insert(el);
        }
    }

    public void addAllTo(Puffer<? super T> p) {
        Iterator<T> iter = super.iterator();
        while (iter.hasNext()) {
            p.insert(iter.next());
        }
    }
}
