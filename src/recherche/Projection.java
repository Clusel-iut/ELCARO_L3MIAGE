package recherche;

import java.util.Iterator;

import stockage.*;

public class Projection extends StateLessRelation{
	private final Relation rel;
	
	public Projection(Relation rel, Schema schema) {
		super(String.format("projection(%s)",rel),schema);
		this.rel = rel;
	}
	
	@Override
	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>(){
			@Override
			public boolean hasNext() {
				
			}

			@Override
			public Tuple next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
