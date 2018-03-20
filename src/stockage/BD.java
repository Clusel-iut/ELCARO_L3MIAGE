package stockage;

import java.util.List;

public class BD {
	private List<Relation> relations;

	public BD(List<Relation> relations) {
		super();
		this.relations = relations;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}
	
	
}
