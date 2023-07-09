package Uebung2.Aufgabe6;

public class Paar<E,Z> {
	private E e;
	private Z z;

	public Paar(E e, Z z) {
		this.e = e;
		this.z = z;
	}

	public E getErstes() {
		return e;
	}
	public Z getZweites() {
		return z;
	}

	public E setErstes(E e) {
		E temp = this.e;
		this.e = e;
		return temp;
	}
	public Z setZweites(Z z) {
		Z temp = this.z;
		this.z = z;
		return temp;
	}

	public void setBeide(E e, Z z) {
		this.e = e;
		this.z = z;
	}

	public boolean equals(Paar<E,Z> p) {
		return this.getErstes().equals(p.getErstes())
			&& this.getZweites().equals(p.getZweites());
	}

	public String toString() {
		return "(" + e.toString() + "," + z.toString() + ")";
	}

}
