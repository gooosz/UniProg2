package Uebung10.Aufgabe2;

import Uebung8.Aufgabe4.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
public abstract class GenericUtil {
    public static <T> T gambling(T t1, T t2) {
        Random r = new Random();
        return (r.nextInt() % 2 == 0) ? t1 : t2;
    }

    public static <T> Schlange<T> arrayToSchlange(T[] arr) {
        Schlange<T> schlange = new SchlangeMitEVL<>();
        for (int i=0; i<arr.length; i++) {
            schlange.insert(arr[i]);
        }
        return schlange;
    }

    public static <T> Puffer<T> gambling(Puffer<T> p1, Puffer<T> p2) {
        Random r = new Random();
        return (r.nextInt() % 2 == 0) ? p1 : p2;
    }

    public static <T extends Iterable<U>, U> void printAll(T t) {
        for (U element: t) {
            System.out.println(element);
        }
    }

    public static <T> void insertInto(Puffer<T> puffer, T[] arr) {
        for (T t : arr) {
            puffer.insert(t);
        }
    }

    /**
     * U must extend T
     * otherwise
     * e.g.
     * Puffer<Integer> and Puffer<Number>
     * may throw RuntimeError
     * because Integer gets Promoted to Number (common type)
     * and then can't be inserted into Puffer<Integer> p1 (downcast)
     */
    public static <T, U extends T> void insertInto(Puffer<T> p1, Puffer<U> p2) {
        for (T el : p2) {
            p1.insert(el);
        }
    }

    public static <T extends Comparable<T>> Folge<T>
    getMinima(Puffer<? extends T> p1, Puffer<? extends T> p2) {
        Folge<T> min = new FolgeMitDynArray<>();
        Iterator<? extends T> iter1 = p1.iterator();
        Iterator<? extends T> iter2 = p2.iterator();
        while (iter1.hasNext() & iter2.hasNext()) {
            // get pairwise minimum and append to Puffer min
            T currentIter1 = iter1.next();
            T currentIter2 = iter2.next();
            T currentMinimum = (currentIter1.compareTo(currentIter2) < 0) ? currentIter1 : currentIter2;
            min.insert(currentMinimum);
        }
        // iter1 is now empty append all remaining elements from iter2
        while (iter2.hasNext()) {
            min.insert(iter2.next());
        }
        return min;
    }

    // Vergleich ueber Oberklasse von T
    public static <T> Folge<T>
    getMinima(Puffer<? extends T> p1, Puffer<? extends T> p2, Comparator<? super T> comp) {
        Folge<T> min = new FolgeMitDynArray<>();
        Iterator<? extends T> iter1 = p1.iterator();
        Iterator<? extends T> iter2 = p2.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            // get pairwise minimum and append to Puffer min
            // groessere Werte werden nicht hinzugefuegt
            T currentIter1 = iter1.next();
            T currentIter2 = iter2.next();
            T currentMinimum = (comp.compare(currentIter1,currentIter2) < 0) ? currentIter1 : currentIter2;
            min.insert(currentMinimum);
        }
        // iter1 is now empty append all remaining elements from iter2
        while (iter2.hasNext()) {
            min.insert(iter2.next());
        }
        return min;
    }


}

