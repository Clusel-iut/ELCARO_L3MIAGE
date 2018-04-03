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
	public FileDonneesRelation(String name, Schema schema) {
		super(name, schema);
		// TODO Auto-generated constructor stub
	}

	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {

			private int index = 0;

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null; // TODO use throws case
			}

		};
	}

	/**
	 * Permet d'ajouter le tuple à la fin de la table.
	 * @param tuple
	 */
	public void addTuple(Tuple tuple) {
		try {
			
			isTuples.skipBytes(isTuples.available());
			Tuple attTuple = this.getSchema().deserialisation(isTuples); 
			List<Object> valeurs = tuple.getValeurs();
			
			while( attTuple.iterator().hasNext()){
				for(Object o : valeurs)
				{
					Attribut a = attTuple.iterator().next();
					.getTypeOfAttribut().write(osTuples, (attTuple.getTypeOfAttribut()) o); // TODO finish
				}
				
			}
			
			isTuples.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Permet de supprimer le tuple de la table.
	 * 
	 * @param tuple
	 */
	public void deleteTuple(Tuple tuple) {

	}

}
