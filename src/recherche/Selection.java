package recherche;

import java.util.Iterator;
import stockage.*;

public class Selection extends StateLessRelation {
	private final Relation rel;
	private Predicat predicat;
	
	/**
	 * @param rel : les données de la base de donnée
	 * @param predicat : un prédicat
	 */
	public Selection(Relation rel, Predicat predicat) {
		super(String.format("Selection(%s)",rel),rel.getSchema());
		this.rel = rel;
		this.predicat = predicat;
	}
	
	@Override public Iterator<Tuple> iterator(){
		return new Iterator<Tuple>(){
			private Iterator<Tuple> iterator = rel.iterator();
			private Tuple nextTuple;
			private boolean hasNext;
			
			{setNext();}
			
			@Override public boolean hasNext() {return hasNext;}
			
			@Override public Tuple next(){
				Tuple temp = nextTuple;
				setNext();
				return temp;
			}
			
			private void setNext(){
				boolean b = false;
				while(iterator.hasNext() && !(b=predicat.eval(nextTuple = iterator.next())));
				hasNext=b;
			}
		};
	}
}
