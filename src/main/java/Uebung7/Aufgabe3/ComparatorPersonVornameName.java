package Uebung7.Aufgabe3;

import Uebung0.Aufgabe3.Person;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		// vorname
		int dv = p1.getVorname().compareTo(p2.getVorname());
		// name
		int dn = p1.getName().compareTo(p2.getName());
		return (dv != 0) ? dv : dn;
	}
}
