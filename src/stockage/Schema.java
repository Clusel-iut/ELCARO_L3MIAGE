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

	/**
	 * Permet de r�cup�rer les attributs du schema
	 * @return le tableau d'attribut du schema
	 */
	public Attribut[] getAttributs() {
		return attributs;
	}
	
	/**
	 *  Permet de r�cup�rer les attributs du schema
	 * @return  la liste d'attribut du schema
	 */
	public ArrayList<Attribut> getAttributsToArray() {
		ArrayList<Attribut> list = new ArrayList<Attribut>();
		for(int i = 0; i<this.attributs.length; i++) {
			list.add(this.attributs[i]);
		}
		return list;
	}

	/** 
	 * @param attributs : les attributs du schema
	 */
	public Schema(Attribut... attributs) {
		this.attributs = attributs;
	}
	
	/**
	 * @param attributs : les attributs du schema
	 */
	public Schema(ArrayList<Attribut> attributs) {
		this.attributs = new Attribut[attributs.size()];
		attributs.toArray(this.attributs);
	}

	/**
	 * Permet de creer un schema via deux schema (concatenation)
	 * @param schema1 : un schema
	 * @param schema2 : un autre schema
	 */
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

	/**
	 * 
	 * @param fileName : le nom du fichier
	 * @throws FileNotFoundException
	 */
	public void saveSchema(String fileName) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
		try {
			encoder.writeObject(this);
			encoder.flush();
		} finally {
			encoder.close();
		}
	}

	@Override public Iterator<Attribut> iterator() {
		return new Iterator<Attribut>() {
			private int index = 0;
			
			@Override public boolean hasNext() {
				return (index < attributs.length);
			}

			@Override public Attribut next() {
				return attributs[index++];
			}
		};
	}

	/**
	 * Permet de lire le schema via une entr�e
	 * @param is : un flux d'entr�
	 * @return le tuple r�cup�r�
	 * @throws IOException erreur � l'ecture
	 */
	public Tuple deserialisation(DataInputStream is) throws IOException {
		List<Attribut> tuple = new ArrayList<Attribut>();
		for (Attribut a : this.attributs) {
			tuple.add(new Attribut((Type<?>) a.getTypeOfAttribut().read(is), a.getNomOfAttribut()));
		}
		return new Tuple(tuple);
	}
	
	/**
	 * Permet d'�crire le schema sur une sortie
	 * @param osTuples : un flux de sortie
	 * @throws IOException erreur � l'�criture
	 */
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
	
	/**
	 * Permet de r�cup�rer l'index d'un attribut
	 * @param attr : nom de l'attribut � r�cup�rer
	 * @return l'index de l'attribut ayant le m�me nom que attr ou -1 si on ne l'a pas trouv�
	 * @throws Exception
	 */
	// TODO remove Exception
	public int getIndex(String attr) throws Exception {
		int indexAttr = -1;
		for (int i = 0; i < this.attributs.length; i++) {
			if(attr.equals(this.attributs[i].getNomOfAttribut())) {
				indexAttr = i;
			}
		}
		return indexAttr;
	}
}
