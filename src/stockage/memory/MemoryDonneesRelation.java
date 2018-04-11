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
	 * @param name : nom de la table de base de donn√©e
	 * @param schema : contient les colonnes de la tables
	 */
	public MemoryDonneesRelation(String name, Schema schema) {
		super(name, schema);
		tuples = new ArrayList<Tuple>();
	}

	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {
			private int index = 0;

			@Override public boolean hasNext() {
				return (index < tuples.size());
			}

			@Override public Tuple next() {
				return tuples.get(index++);
			}
		};
	}

	/**
	 * Permet d'ajouter le tuple ‡†la fin de la table.
	 * @param tuple : un tuple ‡ ajouter
	 */
	public void addTuple(Tuple tuple) {
		this.tuples.add(tuple);
	}

	/**
	 * Permet de supprimer le tuple de la table s'il existe sinon on fait rien.
	 * @param tuple : un tuple ‡ supprimer
	 */
	public void deleteTuple(Tuple tuple) {
		int v = searchToDelete(tuple);
		if (-1 != v)
			this.tuples.remove(v);
	}

	/**
	 * Permet de rÈcupÈrer l'index du tuple identique au tuple passÈ en paramËtre
	 * @param tuple : le tuple ‡ rechercher
	 * @return l'index du tuple recherchÈ ou -1 si on ne l'a pas trouvÈ
	 */
	private int searchToDelete(Tuple tuple) {
		int nbAtt = 0;
		Iterator<Attribut> it = getSchema().iterator();
		while (it.hasNext()) {
			it.next();
			nbAtt++;
		}
		int nbAttTrouv = 0;
		for (int indexTuple = 0; indexTuple < tuples.size(); indexTuple++) {
			// TODO utiliser le equals(Tuple)
			for (int indexAtt = 0; indexAtt < nbAtt; indexAtt++) {
				if (tuple.getValue(indexAtt).toString().equals(tuples.get(indexTuple).getValue(indexAtt).toString())) {
					nbAttTrouv++;
				} else {
					nbAttTrouv = 0;
					break; // il y en a au moins un pas identique
				}
			}
			if (nbAttTrouv == nbAtt) {
				return indexTuple;
			}
		}
		return -1;
	}

	/**
	 * Permet de rÈcupÈrer le nombre de tuple dans la relation
	 */
	@Override public int nbTuples() {
		return tuples.size();
	}
}
