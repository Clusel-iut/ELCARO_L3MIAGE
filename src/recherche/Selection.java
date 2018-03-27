package recherche;

import java.util.Iterator;
import java.util.List;

import stockage.*;

public class Selection extends StateLessRelation{
	private final Relation rel;
	private Predicat predicat;
	public Selection(Relation rel, Predicat predicat) {
		super(String.format("Selection(%s)",rel),rel.getSchema());
		this.rel = rel;
		this.predicat = predicat;
	}
	
	@Override
	public Iterator<Tuple> iterator() {
		Iterator<Tuple> it1 = rel.iterator();
		// Il est dans FullMemoryRelation.
		return new Iterator<Tuple>(){
			Iterator<Tuple> it1 = rel.iterator();
			@Override
			public boolean hasNext() {
				return it1.hasNext();
			}
			@Override
			public Tuple next() {
				Tuple t1 = it1.next();
				while(!predicat.eval(t1) && this.hasNext()){
					t1 = it1.next();
				}
				return new Tuple(x);
			}
		};
	}
}
