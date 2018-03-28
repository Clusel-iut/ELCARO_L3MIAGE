package stockage;

import java.util.List;

import recherche.Predicat;

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

	public Schema getSchema() {
		return schema;
	}

}
