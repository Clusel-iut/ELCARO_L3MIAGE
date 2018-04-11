package recherche;

import java.util.Iterator;

import stockage.Relation;
import stockage.StateLessRelation;
import stockage.Tuple;

public class Intersection extends StateLessRelation {

	private final Relation rel;
	private Predicat predicat1;
	private Predicat predicat2;

	/**
	 * 
	 * @param rel : les données de la base de donnée
	 * @param predicat1 : un prédicat
	 * @param predicat2 : un prédicat différent
	 */
	public Intersection(Relation rel, Predicat predicat1, Predicat predicat2) {
		super(String.format("Intersection(%s)", rel), rel.getSchema());
		this.rel = rel;
		this.predicat1 = predicat1;
		this.predicat2 = predicat2;
	}

	@Override public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {
			private Iterator<Tuple> iterator = Intersection.this.rel.iterator();
			private Tuple nextTuple;
			private boolean hasNext;
			
			{ this.setNext();}

			@Override public boolean hasNext() {
				return this.hasNext;
			}

			@Override public Tuple next() {
				Tuple temp = this.nextTuple;
				this.setNext();
				return temp;
			}

			private void setNext() {
				boolean b = false;
				while (this.iterator.hasNext() && !b) {
					this.nextTuple = this.iterator.next();
					b = (Intersection.this.predicat1.eval(this.nextTuple) && Intersection.this.predicat2
							.eval(this.nextTuple));
				}
				this.hasNext = b;
			}
		};
	}
}
