package stockage;

import java.util.Iterator;

public abstract class StateLessRelation extends Relation {

	public StateLessRelation(String name, Schema schema) {
		super(name, schema);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Attribut a : this.getSchema()) {
			sb.append("\t ");
			sb.append(a.getNomOfAttribut());
		}
		Iterator<Tuple> it = this.iterator();
		while(it.hasNext())
			sb.append("\n" + "\t"+it.next().toString());
		return sb.toString();
	}

}
