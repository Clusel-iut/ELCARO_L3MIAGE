package stockage.memory;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;
import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;

public class FileDonneesRelation extends StateFullRelation {

	private DataInputStream tuples;

	public FileDonneesRelation(String name, Schema schema) {
		super(name, schema);
		// TODO Auto-generated constructor stub
	}

	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {

			private int index = 0;

			@Override
			public boolean hasNext(){
				try {
					return (tuples.available() > 0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false; //TODO use throws case 
			}

			@Override
			public Tuple next(){
				// TODO index à ajouter pour ne pas lire toujours le premier
				try {
					return getSchema().deserialisation(tuples);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null; //TODO use throws case 
			}

		};
	}

}
