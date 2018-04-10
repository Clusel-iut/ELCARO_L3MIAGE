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

	public void addRelations(Relation relation) {
		this.relations.add(relation);
	}

	public void removeRelation(Relation relation) {
		this.relations.remove(relation); // TODO à finir
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Relation r : relations) {
			sb.append(r.toString());
		}
		return sb.toString();
	}

}
