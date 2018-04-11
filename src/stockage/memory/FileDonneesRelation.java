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

public class FileDonneesRelation extends StateFullRelation {

	/** Accès aux tuples. */
	private DataInputStream isTuples;
	private DataOutputStream osTuples;
	/** Permet de savoir combient de tuples sont disponnibles */
	private int counter;

	/**
	 * @param name : nom de la table de base de donnÃ©e
	 * @param schema : contient les colonnes de la tables
	 * @throws IOException
	 */
	public FileDonneesRelation(String name, Schema schema, DataInputStream is, DataOutputStream os) throws IOException {
		super(name, schema);
		this.isTuples = is;
		this.osTuples = os;
		this.osTuples.writeUTF(name);
		schema.ecrireSchema(this.osTuples);
		this.osTuples.flush();
		this.counter = 0;
		isTuples.mark(isTuples.available());
	}

	public Iterator<Tuple> iterator() {
		try {
			return new Iterator<Tuple>() {
				private int index = counter;

				{ isTuples.reset();}

				@Override public boolean hasNext() {
					try {
						return (isTuples.available() > 0 && index > 0);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
				}

				@Override public Tuple next() {
					try {
						index--;
						List<Object> tuple = new ArrayList<Object>();
						for (Attribut a : getSchema().getAttributs()) {
							tuple.add(a.getTypeOfAttribut().read(isTuples));
						}
						return new Tuple(tuple);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Permet d'ajouter le tuple Ã  la fin du fichier.
	 * 
	 * @param tuple
	 * @throws IOException
	 */
	public void addTuple(Tuple tuple) throws IOException {
		this.counter++;
		// this.isTuples.skipBytes(isTuples.available());
		tuple.ecrireTuple(osTuples, getSchema());
	}

	/**
	 * Permet de supprimer le tuple de la table. On le replace par un tuple null.
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

	/**
	 * Permet de récupérer le nombre de tuple dans la relation
	 */
	@Override public int nbTuples() {
		return counter;
	}
}
