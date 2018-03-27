package stockage;

import java.util.List;

public abstract class Relation {
	
	private Schema schema;
	
	public Relation(Schema schema) {
		super();
		this.schema = schema;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	
}
