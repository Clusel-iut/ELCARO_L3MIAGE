package stockage;

import java.util.List;

public class Relation {
	private Schema schema;
	private List<Tuple> tuples;
	
	public Relation(Schema schema, List<Tuple> tuples) {
		super();
		this.schema = schema;
		this.tuples = tuples;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public List<Tuple> getTuples() {
		return tuples;
	}

	public void setTuples(List<Tuple> tuples) {
		this.tuples = tuples;
	}
	
	
}
