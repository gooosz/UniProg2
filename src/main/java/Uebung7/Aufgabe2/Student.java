package Uebung7.Aufgabe2;

public class Student extends Uebung0.Aufgabe3.Student implements Comparable<Student> {
	public Student(String name, String vorname, int matrikelnummer) {
		super(name, vorname, matrikelnummer);
	}

	@Override
	public int compareTo(Student s) {
		return this.getMatrikel() - s.getMatrikel();
	}
}
