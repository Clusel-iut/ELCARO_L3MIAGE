package stockage;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import stockage.type.Type;

public class Tuple implements Iterable<Object> {

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

	public <T> T get(int index) {
		if (valeurs.length <= index) return null; // TODO throws Errors
		if(index < 0) return null; // TODO throws Errors
		return (T) valeurs[index];
	}
}
