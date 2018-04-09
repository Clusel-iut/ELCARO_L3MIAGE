package recherche;

import java.util.Iterator;

import stockage.Relation;
import stockage.StateLessRelation;
import stockage.Tuple;

public class Union extends StateLessRelation {

	private final Relation rel;
	private Predicat predicat1;
	private Predicat predicat2;

	public Union(Relation rel, Predicat predicat1, Predicat predicat2) {
		super(String.format("Union(%s)", rel), rel.getSchema());
		this.rel = rel;
		this.predicat1 = predicat1;
		this.predicat2 = predicat2;
	}

	@Override
	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {

			private Iterator<Tuple> iterator = rel.iterator();
			private Tuple nextTuple;
			private boolean hasNext;
			{setNext();}

			@Override
			public boolean hasNext() {
				return hasNext;
			}

			@Override
			public Tuple next() {
				Tuple temp = nextTuple;
				setNext();
				return temp;
			}

			private void setNext() {
				boolean b = false;
				while (iterator.hasNext() && !b)
				{
					nextTuple = iterator.next();
					b =(predicat1.eval(nextTuple) || predicat2.eval(nextTuple));
				} 
				hasNext = b;
			}
		};
	}

}
