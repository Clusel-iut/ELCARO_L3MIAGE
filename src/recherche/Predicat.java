package recherche;

import java.util.Dictionary;

import stockage.*;
import stockage.type.Type;

public abstract class Predicat {
//	private Attribut attribut;
//	private Type value;
//	private String comparateur; //contient > < <> = 
	public abstract boolean eval(Tuple t);
}
