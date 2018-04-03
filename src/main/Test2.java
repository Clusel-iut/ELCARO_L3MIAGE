package main;

import recherche.Predicat;
import recherche.Selection;
import stockage.Attribut;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.MemoryDonneesRelation;
import stockage.type.TypeBoolean;
import stockage.type.TypeInteger;
import stockage.type.StringBuff;

public class Test2 {

	public static void main(String[] args) {
		Schema sc = new Schema(new Attribut(new TypeInteger(), "ENTIER"),
				new Attribut(new TypeBoolean(), "ESTCEUNNOMBRE"));

		MemoryDonneesRelation r = new MemoryDonneesRelation("RELATION", sc);
		r.addTuple(new Tuple(new Integer(785), new Boolean(true)));
		r.addTuple(new Tuple(new Integer(9), new Boolean(false)));
		r.addTuple(new Tuple(new Integer(10), new Boolean(true)));
		r.addTuple(new Tuple(new Integer(416), new Boolean(true)));

		System.out.println(r.getName());
		for (Attribut att : sc) {
			System.out.println(att.toString());
		}
		for (Tuple t : r) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}
		Relation s = new Selection(r, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return tuple.get(1).equals(new Boolean(false));
			}
		});
		for (Tuple t : s) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}
	}

}
