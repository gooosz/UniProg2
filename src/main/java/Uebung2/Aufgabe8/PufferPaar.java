package Uebung2.Aufgabe8;

import Uebung0.Aufgabe3.Student;
import Uebung0.Aufgabe3.Boxer;
import Uebung2.Aufgabe3.SchlangeMitArray;
import Uebung2.Aufgabe3.StapelMitArray;
import Uebung2.Aufgabe6.Paar;
import Uebung2.Aufgabe3.Puffer;

public class PufferPaar {
	public static void main(String[] args) {
		Puffer<Paar<Student, String>> servicePoint;
		servicePoint = new SchlangeMitArray<>(10);
		Puffer<Paar<Boxer, Boxer>> boxEvent;
		boxEvent = new StapelMitArray<>(10);

		Student s1 = new Student("Jonas", "Karl", 1020);
		Student s2 = new Student("Berrendorf", "Uwe", 1025);
		Student s3 = new Student("Mueller", "Martin", 1030);
		Student s4 = new Student("Uhde", "Tim", 1035);
		Paar<Student, String> ss1 = new Paar<>(s1, "Wo bleibt Immatrikulationsantrag?");
		Paar<Student, String> ss2 = new Paar<>(s2, "Wann Semesterbeitrag zahlen?");
		Paar<Student, String> ss3 = new Paar<>(s3, "Klausur sagt nicht erschienen, obwohl da?");
		Paar<Student, String> ss4 = new Paar<>(s4, "Beschwerde wegen Klausur");

		Boxer b1 = new Boxer("Pess", "Tom", 90);
		Boxer b2 = new Boxer("Troa", "Jean", 110);
		Boxer b3 = new Boxer("Joan", "Johann", 95);
		Paar<Boxer, Boxer> match1 = new Paar<>(b1, b2);
		Paar<Boxer, Boxer> match2 = new Paar<>(b1, b3);
		Paar<Boxer, Boxer> match3 = new Paar<>(b2, b3);

		servicePoint.insert(ss1);
		servicePoint.insert(ss2);
		servicePoint.insert(ss3);
		servicePoint.insert(ss4);

		boxEvent.insert(match1);
		boxEvent.insert(match2);
		boxEvent.insert(match3);

		while (!servicePoint.isEmpty()) {
			Paar<Student, String> front = ((SchlangeMitArray<Paar<Student, String>>) servicePoint).front();
			System.out.println(front.getErstes() + ": " + front.getZweites());
			servicePoint.remove();
		}

		while(!boxEvent.isEmpty()) {
			Paar<Boxer, Boxer> top = ((StapelMitArray<Paar<Boxer, Boxer>>) boxEvent).top();
			System.out.println(top.getErstes() + " vs. " + top.getZweites());
			boxEvent.remove();
		}
	}
}
