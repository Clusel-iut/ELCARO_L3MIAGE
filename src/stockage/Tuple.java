package stockage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tuple implements Iterable<Object> {

	private final Object[] valeurs;

	/**
	 * @param v : les valeurs d'un tuple
	 */
	public Tuple(Object... v) {
		super();
		this.valeurs = v;
	}

	/**
	 * @param valeurs  : la liste des valeurs d'un tuple
	 */
	public Tuple(ArrayList<Object> valeurs) {
		this.valeurs = new Object[valeurs.size()];
		valeurs.toArray(this.valeurs);
	}

	@Override public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			private int index = 0;
			
			@Override public boolean hasNext() {
				return (this.index < Tuple.this.valeurs.length);
			}

			@Override public Object next() {
				return Tuple.this.valeurs[this.index++];
			}
		};
	}

	/**
	 * Permet de récupérer un tuple via une entrée
	 * @param is : un flux d'entré
	 * @param schema : le schema de la relation
	 * @return le tuple lu
	 * @throws IOException erreur de l'ecture
	 */
	public Tuple deserialisation(DataInputStream is, Schema schema) throws IOException {
		List<Object> tuple = new ArrayList<Object>();
		for (Attribut a : schema) {
			tuple.add(a.getTypeOfAttribut().read(is));
		}
		System.out.println(tuple.toString());
		return new Tuple(tuple);
	}

	/**
	 * Permet de récupérer une valeur dans le tuple via un index
	 * @param index : index d'une valeur dans un tuple
	 * @return la valeur à l'index index dans le tuple
	 */
	public <T> T getValue(int index) {
		if (this.valeurs.length <= index)
			return null; // TODO throws Errors
		if (index < 0)
			return null; // TODO throws Errors
		return (T) this.valeurs[index];
	}

	/**
	 * Permet de comparer deux tuples
	 * @param tuple : le tuple à comparer au tuple courant
	 * @return true s'ils sont identique sinon false
	 */
	public boolean equals(Tuple tuple) {
		if (!tuple.toString().equals(this.toString()))
			return false;
		for (Object o1 : tuple)
			for (Object o2 : this)
				if (o1 != o2)
					return false;
		return true;
	}

	/**
	 * Permet d'écrire un tuple sur une sortie
	 * @param osTuples : le flux de sorti
	 * @param schema : le schema de la relation
	 * @throws IOException erreur lors de l'écriture
	 */
	public void ecrireTuple(DataOutputStream osTuples, Schema schema) throws IOException {
		int index = 0;
		for (Attribut a : schema.getAttributs()) {
			a.getTypeOfAttribut().write(osTuples, (a.getTypeOfAttribut().getType()).cast(this.getValue(index++)));
			System.out.print((a.getTypeOfAttribut().getType()).cast(this.getValue(index - 1)).toString()+ " ");
		}
		System.out.println();
	}
	
	@Override public String toString() {
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
}
