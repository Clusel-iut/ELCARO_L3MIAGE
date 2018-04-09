package recherche;

import java.util.ArrayList;
import java.util.Iterator;

import stockage.Relation;
import stockage.Schema;
import stockage.StateLessRelation;
import stockage.Tuple;

public class Jointure extends StateLessRelation {
	private static final int _INDEXDULIEN = 1;
	private final Relation rel1;
	private final Relation rel2;
	private final Schema lien;
	private final Schema sc;

	public Jointure(Relation rel1, Relation rel2, Schema schema) {
		super(String.format("jointure(%s%s)", rel1, rel2), new Schema(rel1.getSchema(), rel2.getSchema()));
		this.sc = new Schema(rel1.getSchema(), rel2.getSchema());
		this.lien = schema;
		this.rel1 = rel1;
		this.rel2 = rel2;
	}

	@Override
	public Iterator<Tuple> iterator() {
		return new Iterator<Tuple>() {
			private Iterator<Tuple> iterator1 = rel1.iterator();
			private Iterator<Tuple> iterator2 = rel2.iterator();
			private Tuple nextTuple;

			@Override
			public boolean hasNext() {
				// TODO ils doivent avoir le même nombres de tuples ?
				// TODO Lever une erreur s'il reste des tuples dans l'un des
				// deux ?
				return iterator1.hasNext() && iterator2.hasNext();
			}

			@Override
			public Tuple next() {
				setNext();
				return nextTuple;
			}

			private void setNext() {
				Tuple t1 = iterator1.next();
				Tuple t2 = iterator2.next();

				ArrayList<Object> attributs = new ArrayList<Object>();
				for (int index = 0; index < sc.getAttributs().length; index++) {
					if (index < rel1.getSchema().getAttributs().length) {
						attributs.add(t1.getValue(index));
					} else if(!rel2.getSchema().getAttributs()[index- rel1.getSchema().getAttributs().length].toString().equals(lien.getAttributs()[_INDEXDULIEN].toString())){
						attributs.add(t2.getValue(index - rel1.getSchema().getAttributs().length));
					}
				}
				nextTuple = new Tuple(attributs);
			}
		};
	}

}
