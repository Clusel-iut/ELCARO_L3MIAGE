package stockage.memory;

import java.util.Iterator;
import stockage.Schema;
import stockage.StateFullRelation;
import stockage.Tuple;

public class MemoryDonneesRelation extends StateFullRelation {

	private Tuple[] tuples;

	public MemoryDonneesRelation(String name, Schema schema) {
		super(name, schema);
		// TODO Auto-generated constructor stub
	}

	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return (index < tuples.length);
			}

			@Override
			public Tuple next() {
				return tuples[index++];
			}

		};
	}

}
