package recherche;

import java.util.Iterator;

import stockage.*;

public class Projection extends StateLessRelation{
	private final Relation rel;
	private int[] indexes;
	
	public Projection(Relation rel, Schema schema) {
		super(String.format("projection(%s)",rel),schema);
		this.rel = rel;
		
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
				Object[] x = new Object[2];
				for(int i = 0; i<indexes.length;i++){
					x[i]= t1.get(indexes[i]);
				}
				return new Tuple(x);
			}
		};
	}
}
