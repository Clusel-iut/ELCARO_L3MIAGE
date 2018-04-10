package stockage.memory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;

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
		super(name, schema); // TODO le schema n'ai pas dans le fichier
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
	 * @throws IOException
	 */
	public void addTuple(Tuple tuple) throws IOException {
		isTuples.skipBytes(isTuples.available());
		while (iterator().hasNext())
			iterator().next();

		tuple.ecrireTuple(osTuples, getSchema());

		isTuples.reset();
	}

	/**
	 * Permet de supprimer le tuple de la table. On le replace par un tuple
	 * null.
	 * 
	 * @param tuple
	 * @throws IOException
	 */
	// TODO faire methode qui enlève les lignes totalement null
	public void deleteTuple(Tuple tuple) throws IOException {
		Tuple t = new Tuple();
		while (iterator().hasNext()) {
			t = iterator().next();
			if (tuple.equals(t))
				break;
		}

		if (tuple.equals(t)) {
			ArrayList<Object> lo = new ArrayList<Object>();
			for (int i = 0; i < getSchema().getAttributs().length; i++) {
				lo.add(null);
			}
			new Tuple(lo).ecrireTuple(osTuples, getSchema());
		}
	}

	public int nbTuples() {
		try {
			return isTuples.available() / getSchema().getAttributs().length;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
