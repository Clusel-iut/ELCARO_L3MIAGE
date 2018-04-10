package stockage;

import java.io.IOException;
import java.util.Iterator;

public abstract class Relation implements Iterable<Tuple> {

	/** Nom de la table de base de donnée */
	private final String name;
	/** Contient les colonnes de la tables */
	private final Schema schema;

	public Relation(String name, Schema schema) {
		super();
		this.name = name;
		this.schema = schema;
	}

	public abstract Iterator<Tuple> iterator();
	
	public abstract String toString();

	public Schema getSchema() {
		return this.schema;
	}

	public String getName() {
		return this.name;
	}

}
