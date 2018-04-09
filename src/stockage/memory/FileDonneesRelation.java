package stockage.memory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import stockage.Attribut;
import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;
import stockage.type.Type;

public class FileDonneesRelation extends StateFullRelation {

	/** Accès aux tuples. */
	private DataInputStream isTuples;
	private DataOutputStream osTuples;

	/**
	 * @param name
	 *            : nom de la table de base de donnée
	 * @param schema
	 *            : contient les colonnes de la tables
	 */
	public FileDonneesRelation(String name, Schema schema, DataInputStream is, DataOutputStream os) {
		super(name, schema);
		this.isTuples = is;
		this.osTuples = os;
	}

	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {

			@Override
			public boolean hasNext() {
				try {
					return (isTuples.available() > 0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false; // TODO use throws case
			}

			@Override
			public Tuple next() {
				// TODO index à ajouter pour ne pas lire toujours le premier
				try {
					return getSchema().deserialisation(isTuples);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null; // TODO use throws case
			}

		};
	}

	/**
	 * Permet d'ajouter le tuple à la fin du fichier.
	 * 
	 * @param tuple
	 */
	public void addTuple(Tuple tuple) {
		try {
			isTuples.skipBytes(isTuples.available());
			while (iterator().hasNext())
				iterator().next();

			for (Attribut a : getSchema()) {
				for (Object obj : tuple) {
					a.getTypeOfAttribut().write(osTuples, obj);
				}
			}
			isTuples.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet de supprimer le tuple de la table.
	 * 
	 * @param tuple
	 */
	public void deleteTuple(Tuple tuple) {
		Tuple t = new Tuple();
		while (iterator().hasNext()) {
			t = iterator().next();
			if (tuple.equals(t))
				break;
		}

		if (tuple.equals(t)) {
			
		}
	}
}
