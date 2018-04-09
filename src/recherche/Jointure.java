package recherche;

import java.util.Iterator;

import stockage.Schema;
import stockage.StateLessRelation;
import stockage.Tuple;

public class Jointure extends StateLessRelation{

	public Jointure(String name, Schema schema) {
		super(name, schema);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
