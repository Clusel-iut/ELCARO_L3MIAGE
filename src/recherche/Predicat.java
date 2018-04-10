package recherche;
import stockage.*;

import stockage.*;

public abstract class Predicat {
	public abstract boolean eval(Tuple tuple);
	
	public static Predicat createPredicat(int attrIndex, Object value, String operator)
	{
		Predicat pred = null;
		switch(operator)
		{
		case "=":
			pred = new Predicat() {
				@Override
				public boolean eval(Tuple tuple) {
					return tuple.getValue(attrIndex).equals(value);
				}
			};
		break;
		case ">":
			if(value.getClass() == Integer.class || value.getClass() == Double.class)
			{
				pred = new Predicat() {
				@Override
				public boolean eval(Tuple tuple) {
					return Integer.parseInt(tuple.getValue(attrIndex).toString()) > Integer.parseInt(value.toString());
				}};
			}
		break;
		case "<":
			if(value.getClass() == Integer.class || value.getClass() == Double.class)
			{
				pred = new Predicat() {
				@Override
				public boolean eval(Tuple tuple) {
					return Integer.parseInt(tuple.getValue(attrIndex).toString()) < Integer.parseInt(value.toString());
				}};
			}
		break;
		}
		return pred;
	}
}
