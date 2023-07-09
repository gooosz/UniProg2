package Uebung0.Aufgabe3;

public class Student extends Person{
	private int matrikelnummer;

	public Student(String name, String vorname, int matrikelnummer) {
		super(name, vorname);
		this.matrikelnummer = matrikelnummer;
	}

	public int getMatrikel() {
		return matrikelnummer;
	}

	@Override
	public String toString() {
		return (super.toString() + " " + getMatrikel());
	}

	@Override
	public boolean equals(Person p) {
		if (!(p instanceof Student)) {
			// p is no student so compare by Person
			return super.equals(p);
		}
		return getMatrikel() == ((Student) p).getMatrikel();
	}
}
