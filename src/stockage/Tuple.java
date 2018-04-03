package stockage;

import java.util.Iterator;
import java.util.List;

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

}
