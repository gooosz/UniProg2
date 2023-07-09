package Uebung0.Aufgabe3;

public class Boxer extends Person {
	private int gewicht;

	public Boxer(String name, String vorname, int gewicht) {
		super(name, vorname);
		this.gewicht = gewicht;
	}

	public int getGewicht() {
		return gewicht;
	}

	@Override
	public boolean equals(Person p) {
		if (!(p instanceof Boxer)) {
			// p is no Boxer so use Person equals
			return super.equals(p);
		}
		return (super.equals(p) && getGewicht() == ((Boxer) p).getGewicht());
	}
}
