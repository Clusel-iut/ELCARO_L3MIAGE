package stockage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;

import stockage.type.Type;

public class Schema implements Iterable<Attribut> {
	private final Attribut[] attributs;

	public Schema(Attribut... attributs) {
		this.attributs = attributs;
	}

	public Schema(String fileName) throws FileNotFoundException {
		Schema schema = null;
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
		try {
			this.attributs = ((Schema) decoder.readObject()).attributs;
		} finally {
			decoder.close();
		}
	}

	public void saveSchema(String fileName) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
		try {
			encoder.writeObject(this);
			encoder.flush();
		} finally {
			encoder.close();
		}
	}

	@Override
	public Iterator<Attribut> iterator() {
		return new Iterator<Attribut>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return (index < attributs.length);
			}

			@Override
			public Attribut next() {
				return attributs[index++];
			}

		};
	}

	public Tuple deserialisation(DataInputStream is) throws IOException {
		List<Attribut> tuple = new ArrayList<Attribut>();
		for (Attribut a : this) {
			tuple.add(new Attribut((Type) a.getValeur().read(is))); //TODO NOT SAFE CAST 
		}

		return new Tuple(tuple);
	}

}
