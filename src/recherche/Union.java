package recherche;

import java.util.Iterator;

import stockage.Schema;
import stockage.StateLessRelation;
import stockage.Tuple;

public class Union extends StateLessRelation{

	public Union(String name, Schema schema) {
		super(name, schema);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
