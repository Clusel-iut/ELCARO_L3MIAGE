package stockage;

import java.util.Iterator;

public abstract class Relation implements Iterable<Tuple> {

	/** Nom de la table de base de donnée */
	private final String name;
	/** Contient les colonnes de la tables */
	private final Schema schema;

	/**
	 * @param name : nom de la table de la relation
	 * @param schema : contient les colonnes de la relation
	 */
	public Relation(String name, Schema schema) {
		super();
		this.name = name;
		this.schema = schema;
	}

	public abstract Iterator<Tuple> iterator();
	
	public abstract String toString();

	/**
	 * Permet de récupérer le schema de la relation
	 * @return le schema de la relation
	 */
	public Schema getSchema() {
		return this.schema;
	}

	/**
	 * Permet de récupérer le nom de la relation
	 * @return le nom de la relation
	 */
	public String getName() {
		return this.name;
	}
}
