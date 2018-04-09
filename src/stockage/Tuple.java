package stockage;

import java.util.Arrays;
import java.util.Iterator;

public class Tuple implements Iterable<Object> {

	@Override
	public String toString() {
		return "Tuple [valeurs=" + Arrays.toString(valeurs) + "]";
	}

	private final Object[] valeurs;

	public Tuple(Object... v) {
		super();
		this.valeurs = v;
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return (index < valeurs.length);
			}

			@Override
			public Object next() {
				return valeurs[index++];
			}

		};
	}

	// TODO Serialisation / Deserialisation finish

	public <T> T getValue(int index) {
		if (valeurs.length <= index)
			return null; // TODO throws Errors
		if (index < 0)
			return null; // TODO throws Errors
		return (T) valeurs[index];
	}

	public boolean equals(Tuple tuple) {
		if(!tuple.toString().equals(this.toString())) return false;
		for(Object o1 : tuple)
			for(Object o2 : this)
				if (o1 != o2) return false;
		return true;
	}
}
