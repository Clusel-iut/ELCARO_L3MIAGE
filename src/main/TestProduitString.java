package main;

import recherche.Produit;
import stockage.Attribut;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.MemoryDonneesRelation;
import stockage.type.StringBuff;
import stockage.type.TypeInteger;
import stockage.type.TypeVarchar;

public class TestProduitString {

	public static void main(String[] args) {
		Schema sc1 = new Schema(new Attribut(new TypeVarchar(), "NOM"), new Attribut(new TypeVarchar(), "PRENOM"));

		MemoryDonneesRelation r1 = new MemoryDonneesRelation("RELATION1", sc1);
		r1.addTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		r1.addTuple(new Tuple(new StringBuff("PIGNARD"), new StringBuff("FLORIAN")));
		r1.addTuple(new Tuple(new StringBuff("MONBEIG"), new StringBuff("JONATHAN")));
		r1.addTuple(new Tuple(new StringBuff("CLUSEL"), new StringBuff("MATHIEU")));

		Schema sc2 = new Schema(new Attribut(new TypeInteger(), "AGE"));

		MemoryDonneesRelation r2 = new MemoryDonneesRelation("RELATION2", sc2);
		r2.addTuple(new Tuple(new Integer(40)));
		r2.addTuple(new Tuple(new Integer(21)));
		r2.addTuple(new Tuple(new Integer(19)));
		r2.addTuple(new Tuple(new Integer(20)));

		System.out.println(r1.getName());
		for (Attribut att : sc1) {
			System.out.println(att.toString());
		}
		for (Tuple t : r1) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}
		
		System.out.println(r2.getName());
		for (Attribut att : sc2) {
			System.out.println(att.toString());
		}
		for (Tuple t : r2) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}

		System.out.println("Produit entre les deux tables");
		Relation s = new Produit(r1, r2);
		for (Tuple t : s) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}
	}

}
