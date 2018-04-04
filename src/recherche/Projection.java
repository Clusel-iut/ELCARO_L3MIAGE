package recherche;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	// TODO BUG AVEC TEST 3
	// TODO MAUVAIS NOM
	private void getIndexes(Schema schema) throws Exception {

		Attribut[] attributsSchemaProjection = schema.getAttributs();
		
		for (int indexSchemaProjection = 0; indexSchemaProjection < attributsSchemaProjection.length; indexSchemaProjection++) {
			Attribut[] attributsSchemaActuel = rel.getSchema().getAttributs();
						
			for (int indexSchemaActuel = 0; indexSchemaActuel < attributsSchemaActuel.length; indexSchemaActuel++) {
				if (attributsSchemaProjection[indexSchemaProjection].getTypeOfAttribut().toString().equals(attributsSchemaActuel[indexSchemaActuel].getTypeOfAttribut().toString())
						&& attributsSchemaProjection[indexSchemaProjection].getNomOfAttribut().equals(attributsSchemaActuel[indexSchemaActuel].getNomOfAttribut())) {
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

			// TODO PAS FONCTIONNEL
			private void setNext() {
				boolean b = false;
				Tuple t1 = iterator.next();
				ArrayList<Object> attributs = new ArrayList<Object>();
				for (int i = 0; i < indexes.size(); i++) {
					attributs.add(t1.iterator().next());
				}
				nextTuple = t1;
				hasNext = b;
			}
		};
	}
}
