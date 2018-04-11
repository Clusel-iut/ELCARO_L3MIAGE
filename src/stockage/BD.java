package stockage;

import java.util.ArrayList;
import java.util.List;

public class BD {
	private List<Relation> relations;

	/**
	 * @param relations : liste de relation contenant le nom, le schema et une liste de tuples
	 */
	public BD(List<Relation> relations) {
		super();
		this.relations = relations;
	}

	/**
	 * Permet de r�cup�rer toutes les relations de la base de donn�e
	 * @return une liste de relation
	 */
	public List<Relation> getRelations() {
		return relations;
	}

	/**
	 * Permet de changer la liste des relations
	 * @param relations : une liste de relation
	 */
	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	/**
	 * Permet d'ajouter une relation � la liste des relations
	 * @param relation : une relation
	 */
	public void addRelations(Relation relation) {
		this.relations.add(relation);
	}

	/**
	 * Permet de supprimer une relation � la liste des relations
	 * @param relation : une relation
	 */
	public void removeRelation(Relation relation) {
		this.relations.remove(relation); // TODO � finir
	}

	@Override public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Relation r : relations) {
			sb.append(r.toString());
		}
		return sb.toString();
	}
	
	/**
	 * Permet de r�cup�rer l'index d'une relation
	 * @param from : nom de la relation � chercher
	 * @return l'index de la relation ayant le m�me nom que from ou -1 si on n'a pas trouv�
	 */
	public int getIndexRelation(String from) {
		int indexRel = -1;
		int i = 0;
		boolean find = false;
		while(i < this.relations.size() && find == false) {
			if(this.relations.get(i).getName().equals(from)) {
			  	find = true;
			  	indexRel = i;
			} else {
			  i++;
			}
		}
		return indexRel;
	}
}
