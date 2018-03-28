package recherche;

import java.util.Dictionary;

import stockage.*;
import stockage.type.Type;

public class Predicat {
	private final Tuple tuple;

	public Predicat(Tuple tuple) {
		this.tuple = tuple;
	}

	public boolean eval(Tuple t) {
		boolean eval = true;
		int i = 0, j = 0;
		
		while(i < this.tuple.getAttributs().size() && eval == true)
		{
			while(j < t.getAttributs().size() && eval == true)
			{
				if (!(this.tuple.getAttributs().get(i) == t.getAttributs().get(j))) {
					eval = false;
				}
				j++;
			}
			i++;
		}
		return eval;
	}
}
