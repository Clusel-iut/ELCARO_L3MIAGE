package stockage;

import java.util.List;

import recherche.Predicat;

public abstract class Relation implements Iterable<Tuple>{
	
	private final String name;
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
