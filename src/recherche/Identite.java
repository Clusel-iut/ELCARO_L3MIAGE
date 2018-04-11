package recherche;

import java.util.Iterator;

import stockage.*;

public class Identite extends StateLessRelation{
	private final Relation rel;
	
	/**
	 * 
	 * @param rel : les donn�es de la base de donn�e
	 * @param schema : le schema � appliquer
	 */
	public Identite(Relation rel, Schema schema) {
		super(String.format("identite(%s)",rel),schema);
		this.rel = rel;
	}
	
	@Override public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>(){
			private Iterator<Tuple> it1 = rel.iterator();
			@Override public boolean hasNext() {
				return it1.hasNext();
			}

			@Override public Tuple next() {
				return it1.next();
			}
		};
	}
}
