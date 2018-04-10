package stockage;

import java.beans.XMLEncoder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import stockage.type.Type;

public class Schema implements Iterable<Attribut> {
	private final Attribut[] attributs;

	public Attribut[] getAttributs() {
		return attributs;
	}

	public Schema(Attribut... attributs) {
		this.attributs = attributs;
	}
	
	public Schema(ArrayList<Attribut> attributs) {
		this.attributs = new Attribut[attributs.size()];
		attributs.toArray(this.attributs);
	}

	public Schema(Schema schema1, Schema schema2) {
		ArrayList<Attribut> list = new ArrayList<Attribut>();
		int longSch = 0;
		for (Attribut att : schema1) {
			list.add(att);
			longSch++;
		}
		for (Attribut att : schema2) {
			list.add(att);
			longSch++;
		}
		this.attributs = new Attribut[longSch];
		list.toArray(this.attributs);
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
		for (Attribut a : this.attributs) {
			tuple.add(new Attribut((Type<?>) a.getTypeOfAttribut().read(is), a.getNomOfAttribut()));
		}
		return new Tuple(tuple);
	}
	
	public void ecrireSchema(DataOutputStream osTuples) throws IOException {
		for (Attribut a : this.attributs) {
			for (int index = 0; index < this.attributs.length; index++) {
				osTuples.writeUTF(a.toString());
			}
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Attribut a: this.attributs) {
			sb.append(a.toString());
			sb.append("\t");
		}
		return sb.toString();
	}

}
