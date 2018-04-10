package stockage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import stockage.type.Type;

public class Tuple implements Iterable<Object> {

	@Override
	public String toString() {
		if (this.valeurs == null)
			return "null";

		int iMax = this.valeurs.length - 1;
		if (iMax == -1)
			return "vide";

		StringBuilder b = new StringBuilder();
		for (int i = 0;; i++) {
			b.append(String.valueOf(this.valeurs[i]));
			if (i == iMax)
				return b.toString();
			b.append("\t");
		}
	}

	private final Object[] valeurs;

	public Tuple(Object... v) {
		super();
		this.valeurs = v;
	}

	public Tuple(ArrayList<Object> valeurs) {
		this.valeurs = new Object[valeurs.size()];
		valeurs.toArray(this.valeurs);
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

	public Tuple deserialisation(DataInputStream is, Schema schema) throws IOException {
		System.out.println("Deserial");
		List<Object> tuple = new ArrayList<Object>();
		for (Attribut a : schema) {
			tuple.add((Type<?>) a.getTypeOfAttribut().read(is));
			System.out.println(tuple.size() + " : " + tuple.toString());
		}
		return new Tuple(tuple);
	}

	public <T> T getValue(int index) {
		if (valeurs.length <= index)
			return null; // TODO throws Errors
		if (index < 0)
			return null; // TODO throws Errors
		return (T) valeurs[index];
	}

	public boolean equals(Tuple tuple) {
		if (!tuple.toString().equals(this.toString()))
			return false;
		for (Object o1 : tuple)
			for (Object o2 : this)
				if (o1 != o2)
					return false;
		return true;
	}

	public void ecrireTuple(DataOutputStream osTuples, Schema schema) throws IOException {
		int index = 0;
		for (Attribut a : schema.getAttributs()) {
			a.getTypeOfAttribut().write(osTuples, (a.getTypeOfAttribut().getType()).cast(this.getValue(index++)));
			System.out.print((a.getTypeOfAttribut().getType()).cast(this.getValue(index-1)).toString() + " ");
		}
		System.out.println();
	}
}
