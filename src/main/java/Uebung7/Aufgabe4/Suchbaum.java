package Uebung7.Aufgabe4;

import Uebung2.Aufgabe3.Schlange;
import Uebung2.Aufgabe3.SchlangeMitArray;
import Uebung5.Aufgabe2.Folge;
import Uebung5.Aufgabe3.FolgeMitDynArray;

import java.util.Comparator;

public class Suchbaum<T extends Comparable<T>> {
	private Comparator<T> comp;
	private BaumEl wurzel;

	class BaumEl {
		T data;
		BaumEl left;
		BaumEl right;

		BaumEl(T i) {
			data = i;
			left = null;
			right = null;
		}
	}

	public Suchbaum() {
		this.comp = null;
	}

	public Suchbaum(Comparator<T> comp) {
		this.comp = comp;
	}

	// -------------------------

	public boolean isEmpty() {
		return wurzel == null;
	}

	public void insert(T i) {
		if (this.contains(i)) {
			return;
		}

		if (isEmpty()) {
			wurzel = new BaumEl(i);
			return;
		}

		BaumEl prevWurzel = wurzel;
		// i einfuegen
		if (compare(i, this.wurzel.data) <= 0) {
			// left subtree
			if (this.wurzel.left == null) {
				this.wurzel.left = new BaumEl(i);
			} else {
				this.wurzel = this.wurzel.left;
				insert(i);
			}
		} else {
			// right subtree
			if (this.wurzel.right == null) {
				this.wurzel.right = new BaumEl(i);
			} else {
				this.wurzel = this.wurzel.right;
				insert(i);
			}
		}
		// setze wurzel auf ursprung zurueck
		wurzel = prevWurzel;
	}

	public boolean contains(T i) {
		if (isEmpty()) {
			return false;
		}

		if (wurzel.data.equals(i)) {
			return true;
		}

		boolean doesContain = false;
		BaumEl prevWurzel = wurzel;
		if (compare(i, this.wurzel.data) <= 0) {
			// left subtree
			wurzel = wurzel.left;
		} else {
			// right subtree
			wurzel = wurzel.right;
		}
		doesContain = contains(i);
		// reset wurzel to previous wurzel
		wurzel = prevWurzel;
		return doesContain;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "";
		}

		BaumEl prevWurzel = wurzel;
		String baum = "(";
		if (wurzel.left != null) {
			wurzel = wurzel.left;
			baum += toString();
		}
		wurzel = prevWurzel;
		baum += wurzel.data;
		if (wurzel.right != null) {
			wurzel = wurzel.right;
			baum += toString();
		}
		baum += ")";
		wurzel = prevWurzel;
		return baum;
	}

	public int hoehe() {
		if (isEmpty()) {
			return 0;
		}
		return hoehe(wurzel);
	}

	private int hoehe(BaumEl e) {
		int hoeheLeft = 0;
		int hoeheRight = 0;
		if (e.left != null) {
			hoeheLeft += hoehe(e.left);
		}
		if (e.right != null) {
			hoeheRight += hoehe(e.right);
		}
		int max = Math.max(hoeheLeft, hoeheRight);
		return max + 1;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}

		BaumEl prevWurzel = wurzel;
		// diese wurzel gibt es schonmal
		int size = 1;

		// size of unterbaum
		if (wurzel.left != null) {
			wurzel = wurzel.left;
			size += size();
		}
		wurzel = prevWurzel;
		if (wurzel.right != null){
			wurzel = wurzel.right;
			size += size();
		}
		wurzel = prevWurzel;
		return size;
	}

	public Folge<T> preorder() {
		Folge<T> folge = new FolgeMitDynArray<>();
		preorder(wurzel, folge);
		return folge;
	}

	private void preorder(BaumEl k, Folge<T> folge) {
		if (k == null) {
			return;
		}

		folge.insert(k.data);
		if (k.left != null) {
			// preorder traverse left
			preorder(k.left, folge);
		}
		if (k.right != null) {
			// preorder traverse right
			preorder(k.right, folge);
		}
	}

	public Folge<T> inorder() {
		Folge<T> folge = new FolgeMitDynArray<>();
		inorder(wurzel, folge);
		return folge;
	}

	private void inorder(BaumEl k, Folge<T> folge) {
		if (k == null) {
			return;
		}

		if (k.left != null) {
			// preorder traverse left
			inorder(k.left, folge);
		}
		folge.insert(k.data);
		if (k.right != null) {
			// preorder traverse right
			inorder(k.right, folge);
		}
	}

	public Folge<T> postorder() {
		Folge<T> folge = new FolgeMitDynArray<>();
		postorder(wurzel, folge);
		return folge;
	}

	private void postorder(BaumEl k, Folge<T> folge) {
		if (k == null) {
			return;
		}

		if (k.left != null) {
			// preorder traverse left
			postorder(k.left, folge);
		}
		if (k.right != null) {
			// preorder traverse right
			postorder(k.right, folge);
		}
		folge.insert(k.data);
	}

	public Folge<T> breitensuche() {
		if (wurzel == null) {
			return new FolgeMitDynArray<>();
		}

		Folge<T> folge = new FolgeMitDynArray<>();
		Schlange<BaumEl> queue = new SchlangeMitArray<>(size());
		queue.insert(wurzel);

		while (!queue.isEmpty()) {
			// process front
			BaumEl front = queue.front();
			folge.insert(front.data);
			if (front.left != null) {
				queue.insert(front.left);
			}
			if (front.right != null) {
				queue.insert(front.right);
			}
			queue.remove();
		}
		return folge;
	}

	public void remove(T i) {
		if (!contains(i)) {
			return;
		}

		BaumEl knoten = getKnoten(i);
		if (knoten == wurzel) {
			if (wurzel.left == null) {
				wurzel = wurzel.right;
			} else if (wurzel.right == null) {
				wurzel = wurzel.left;
			} else {
				// wurzel hat 2 children
				// tree balances itself for more performance
				if (hoehe(knoten.left) >= hoehe(knoten.right)) {
					mergeRightTreeToLeft(knoten);
					wurzel = knoten.left;
					//mergeRightTreeToLeft(knoten);
					// make left tree the new wurzel
					//wurzel = knoten.left;
				} else {
					mergeLeftTreeToRight(knoten);
					// make right tree the new wurzel
					wurzel = knoten.right;
				}
			}
			return;
		}


		// Case 1: Knoten ohne children wird entfernt
		if (knoten.left == null && knoten.right == null) {
			BaumEl parent = getParent(knoten);
			if (parent.left == knoten) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return;
		}

		// Case 2: Knoten mit einem Children wird entfernt
		if (knoten.left == null) {
			BaumEl parent = getParent(knoten);
			if (parent.left == knoten) {
				parent.left = knoten.right;
			} else {
				parent.right = knoten.right;
			}
			return;
		} else if (knoten.right == null) {
			BaumEl parent = getParent(knoten);
			if (parent.left == knoten) {
				parent.left = knoten.left;
			} else {
				parent.right = knoten.left;
			}
			return;
		}

		// Case 3: Knoten mit zwei children wird entfernt
		// make left one the wurzel from this
		BaumEl parent = getParent(knoten);
		if (parent.right == knoten) {
			parent.right = knoten.left;
			mergeRightTreeToLeft(knoten);
		} else {
			parent.left = knoten.left;
			mergeRightTreeToLeft(knoten);
		}
	}

	private void mergeRightTreeToLeft(BaumEl knoten) {
		// hand entire right tree to most right element of left tree
		BaumEl greatestLeft = knoten.left;
		while (greatestLeft.right != null) {
			greatestLeft = greatestLeft.right;
		}
		greatestLeft.right = knoten.right;
	}

	private void mergeLeftTreeToRight(BaumEl knoten) {
		// hand entire left tree to most left element of right tree
		BaumEl lowestRight = knoten.right;
		while (lowestRight.left != null) {
			lowestRight = lowestRight.left;
		}
		lowestRight.left = knoten.left;
	}

	private BaumEl getKnoten(T i) {
		return getKnoten(wurzel, i);
	}

	private BaumEl getKnoten(BaumEl knoten, T i) {
		if (isEmpty() || !contains(i)) {
			return null;
		}

		if (knoten.data.equals(i)) {
			return knoten;
		}

		if (compare(i, knoten.data) < 0) {
			return getKnoten(knoten.left, i);
		} else {
			return getKnoten(knoten.right, i);
		}
	}

	private BaumEl getParent(T i) {
		return getParent(wurzel, i);
	}
	private BaumEl getParent(BaumEl e) {
		return getParent(e.data);
	}
	private BaumEl getParent(BaumEl root, T i) {
		if (wurzel.data.equals(i) || root == null) {
			return null;
		}

		if ((root.left != null && root.left.data.equals(i))
			|| (root.right != null && root.right.data.equals(i))) {
			return root;
		}

		if (compare(i, root.data) < 0) {
			return getParent(root.left, i);
		} else {
			return getParent(root.right, i);
		}
	}

	private int compare(T t1, T t2) {
		if (comp == null) {
			return t1.compareTo(t2);
		}
		return comp.compare(t1, t2);
	}

}
