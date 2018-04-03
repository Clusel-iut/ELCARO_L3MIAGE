package stockage.memory;

import java.util.ArrayList;
import java.util.Iterator;
import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;

public class MemoryDonneesRelation extends StateFullRelation {

	/** Stockage des tuples. */
	private ArrayList<Tuple> tuples;

	/**
	 * @param name : nom de la table de base de donnée
	 * @param schema : contient les colonnes de la tables
	 */
	public MemoryDonneesRelation(String name, Schema schema) {
		super(name, schema);
		tuples = new ArrayList<Tuple>(); // TODO taille illimité ?
	}

	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return (index < tuples.size());
			}

			@Override
			public Tuple next() {
				return tuples.get(index++);
			}

		};
	}

	/**
	 * Permet d'ajouter le tuple à la fin de la table.
	 * @param tuple
	 */
	public void addTuple(Tuple tuple) {
		this.tuples.add(tuple);
	}

	/**
	 * Permet de supprimer le tuple de la table.
	 * @param tuple
	 */
	public void deleteTuple(Tuple tuple) {
		this.tuples.remove(tuple);
	}

}
