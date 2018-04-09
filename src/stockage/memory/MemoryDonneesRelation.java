package stockage.memory;

import java.util.ArrayList;
import java.util.Iterator;

import stockage.Attribut;
import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;

public class MemoryDonneesRelation extends StateFullRelation {

	/** Stockage des tuples. */
	private ArrayList<Tuple> tuples;

	/**
	 * @param name
	 *            : nom de la table de base de donnée
	 * @param schema
	 *            : contient les colonnes de la tables
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
	 * 
	 * @param tuple
	 */
	public void addTuple(Tuple tuple) {
		this.tuples.add(tuple);
	}

	/**
	 * Permet de supprimer le tuple de la table s'il existe sinon on fait rien.
	 * 
	 * @param tuple
	 */
	public void deleteTuple(Tuple tuple) {
		int v = searchToDelete(tuple);
		if (-1 != v)
			this.tuples.remove(v);
	}

	private int searchToDelete(Tuple tuple) {
		int nbAtt = 0;
		Iterator<Attribut> it = getSchema().iterator();
		while (it.hasNext()) {
			it.next();
			nbAtt++;
		}
		int nbAttTrouv = 0;

		for (int indexTuple = 0; indexTuple < tuples.size(); indexTuple++) {
			for (int indexAtt = 0; indexAtt < nbAtt; indexAtt++) {
				if (tuple.getValue(indexAtt).toString().equals(tuples.get(indexTuple).getValue(indexAtt).toString())) {
					nbAttTrouv++;
				} else {
					nbAttTrouv = 0;
					break; // il y en a au moins un pas pareil
				}

			}
			if (nbAttTrouv == nbAtt) {
				return indexTuple;
			}
		}
		return -1;
	}

}
