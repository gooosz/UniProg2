package Uebung4.Aufgabe4;

import Uebung4.Aufgabe3.RingBuffer;
import Uebung4.Aufgabe3.RingIsFullException;

import java.util.NoSuchElementException;

public class Temperatursensor {
	private RingBuffer<Float> data;

	public Temperatursensor() {
		data = new RingBuffer<>(24);
	}

	public void neueMessung(Float wert) {
		try {
			data.addLast(wert);
		} catch (RingIsFullException e) {
			// overwrite oldest element
			data.removeFirst();
			data.addLast(wert);
		}
	}

	public Float aktuelleTemperatur() {
		try {
			if (data.size() == data.capacity()) {
				return data.get(-1);
			}
			return data.get(data.size()-1);
		} catch (NoSuchElementException e) {
			return Float.NaN;
		}
	}

	public Float durchschnittsTemperatur() {
		if (data.size() == 0) {
			return Float.NaN;
		}
		float avg = 0;
		for (int i=0; i<data.size(); i++) {
			try {
				avg += data.get(i);
			} catch (NoSuchElementException ignored) {}
		}
		avg /= data.size();
		return avg;
	}

	public void reset() {
		// no need to increment i, as removeFirst() decrements data.size() already
		for (int i=0; i<data.size();) {
			data.removeFirst();
		}
	}

}
