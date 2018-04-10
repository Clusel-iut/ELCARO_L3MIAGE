package recherche;

import java.util.ArrayList;
import java.util.Iterator;
import stockage.*;

public class Projection extends StateLessRelation {
	private final Relation rel;
	private ArrayList<Integer> indexes;

	public Projection(Relation rel, Schema schema) {
		super(String.format("projection(%s)", rel), schema);
		this.rel = rel;
		indexes = new ArrayList<Integer>();
		try {
			this.getIndexes(schema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getIndexes(Schema schema) throws Exception {

		Attribut[] attributsSchemaProjection = schema.getAttributs();

		for (int indexSchemaProjection = 0; indexSchemaProjection < attributsSchemaProjection.length; indexSchemaProjection++) {
			Attribut[] attributsSchemaActuel = rel.getSchema().getAttributs();

			for (int indexSchemaActuel = 0; indexSchemaActuel < attributsSchemaActuel.length; indexSchemaActuel++) {
				if (attributsSchemaProjection[indexSchemaProjection].getNomOfAttribut()
								.equals(attributsSchemaActuel[indexSchemaActuel].getNomOfAttribut())) {
					indexes.add(indexSchemaActuel);
				}
			}
		}

		if (attributsSchemaProjection.length != indexes.size()) {
			throw new Exception("Attribut(s) introuvable(s)");
		}
	}

	@Override
	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {
			private Iterator<Tuple> iterator = rel.iterator();
			private Tuple nextTuple;

			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public Tuple next() {
				setNext();
				return nextTuple;
			}

			private void setNext() {
				Tuple t1 = iterator.next();
				ArrayList<Object> attributs = new ArrayList<Object>();
				for (int index = 0; index < indexes.size(); index++) {
					attributs.add(t1.getValue(indexes.get(index)));
				}
				nextTuple = new Tuple(attributs);
			}
		};
	}
}
