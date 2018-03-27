package stockage.memory;

import java.beans.PropertyVetoException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import stockage.Attribut;
import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;

public class AccesDonneesFile extends StateFullRelation {

	private DataInputStream tuples;

	public AccesDonneesFile(String name, Schema schema) {
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
