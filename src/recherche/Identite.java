package recherche;

import java.util.Iterator;

import stockage.*;

public class Identite extends StateLessRelation{
	private final Relation rel;
	
	public Identite(Relation rel, Schema schema) {
		super(String.format("identite(%s)",rel),schema);
		this.rel = rel;
	}
	
	@Override
	public Iterator<Tuple> iterator() {
		// Il est dans FullMemoryRelation.
		
		return new Iterator<Tuple>(){
			Iterator<Tuple> it1 = rel.iterator();
			@Override
			public boolean hasNext() {
				return it1.hasNext();
			}

			@Override
			public Tuple next() {
				return it1.next();
			}
		};
	}
}
