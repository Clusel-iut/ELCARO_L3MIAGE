package stockage;

import java.util.Iterator;

public abstract class StateFullRelation extends Relation {

	public StateFullRelation(String name, Schema schema) {
		super(name, schema);
	}

	/**
	 * Permet de savoir combient de tuple possède la relation
	 * @return le nombre de tuple de la relation
	 */
	public abstract int nbTuples();

	@Override public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getName() + "(" + this.getSchema().toString()+ ") with " + this.nbTuples() + " tuples\n");
		for (Attribut a : this.getSchema()) {
			sb.append("\t " + a.getNomOfAttribut());
		}
		sb.append("\n");
		Iterator<Tuple> it = this.iterator();
		while (it.hasNext()) {
			sb.append("\t" + it.next().toString() + "\n");
		}
		return sb.toString();
	}
}
