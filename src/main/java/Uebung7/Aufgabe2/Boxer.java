package Uebung7.Aufgabe2;

public class Boxer extends Uebung0.Aufgabe3.Boxer implements Comparable<Boxer> {
	public Boxer(String name, String vorname, int gewicht) {
		super(name, vorname, gewicht);
	}

	@Override
	public int compareTo(Boxer b) {
		// gewicht
		int dg = super.getGewicht() - b.getGewicht();
		// name
		int dn = super.getName().compareTo(b.getName());
		// vorname
		int dv = super.getVorname().compareTo(b.getVorname());

		// 1. gewicht
		// 2. name
		// 3. vorname
		return (dg != 0) ? dg :
			((dn != 0) ? dn : dv);
	}
}
