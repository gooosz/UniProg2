package Uebung0.Aufgabe3;

public abstract class Person {
	private String name;
	private String vorname;

	public Person(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public boolean equals(Person p) {
		return (getName().equals(p.getName())
			&& getVorname().equals(p.getVorname()));
	}

	@Override
	public String toString() {
		return (getName() + ", " + getVorname());
	}
}
