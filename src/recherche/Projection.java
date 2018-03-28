package recherche;

import java.util.Iterator;
import java.util.List;

import stockage.*;

public class Projection extends StateLessRelation {
	private final Relation rel;
	private List<Integer> indexes;

	public Projection(Relation rel, Schema schema) {
		super(String.format("projection(%s)", rel), schema);
		this.rel = rel;
		
		try {
			this.getIndexes(schema);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getIndexes(Schema schema) throws Exception
	{
		for(int i = 0; i<schema.getAttributs().length; i++)
		{
			for(int j = 0; j<rel.getSchema().getAttributs().length; j++)
			{
				if(schema.getAttributs()[i].getClass() == rel.getSchema().getAttributs()[j].getClass() 
						&& schema.getAttributs()[i].getValeur() == rel.getSchema().getAttributs()[j].getValeur())
				{
					indexes.add(j);
				}
			}
		}
		
		if(!(indexes.size() == schema.getAttributs().length))
		{
			throw new Exception("Attribut(s) introuvable(s)");
		}
	}

	@Override
	public Iterator<Tuple> iterator() {
		Iterator<Tuple> it1 = rel.iterator();
		// Il est dans FullMemoryRelation.
		return new Iterator<Tuple>() {
			Iterator<Tuple> it1 = rel.iterator();

			@Override
			public boolean hasNext() {
				return it1.hasNext();
			}

			@Override
			public Tuple next() {
				if (this.hasNext()) {
					Tuple t1 = it1.next();
					List<Attribut> attributs = null;
					for (int i = 0; i < indexes.size(); i++) {
						attributs.add(t1.getAttributs().get(indexes.get(i)));
					}
					return new Tuple(attributs);
				}
				return null;
			}
		};
	}
}
