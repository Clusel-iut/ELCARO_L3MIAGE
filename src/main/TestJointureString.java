package main;

import recherche.Jointure;
import stockage.Attribut;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.MemoryDonneesRelation;
import stockage.type.StringBuff;
import stockage.type.TypeInteger;
import stockage.type.TypeVarchar;

public class TestJointureString {

	public static void main(String[] args) {
		Schema sc1 = new Schema(new Attribut(new TypeVarchar(), "NOM"), new Attribut(new TypeVarchar(), "PRENOM"));

		MemoryDonneesRelation r1 = new MemoryDonneesRelation("RELATION1", sc1);
		r1.addTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		r1.addTuple(new Tuple(new StringBuff("PIGNARD"), new StringBuff("FLORIAN")));
		r1.addTuple(new Tuple(new StringBuff("MONBEIG"), new StringBuff("JONATHAN")));
		r1.addTuple(new Tuple(new StringBuff("CLUSEL"), new StringBuff("MATHIEU")));

		Schema sc2 = new Schema(new Attribut(new TypeVarchar(), "NOMDEFAMILLE"), new Attribut(new TypeInteger(), "AGE"),
				new Attribut(new TypeVarchar(), "STATUS"));

		MemoryDonneesRelation r2 = new MemoryDonneesRelation("RELATION2", sc2);
		r2.addTuple(new Tuple(new StringBuff("MORAT"), new Integer(40), new StringBuff("PROF")));
		r2.addTuple(new Tuple(new StringBuff("PIGNARD"), new Integer(21), new StringBuff("ETUDIANT")));
		r2.addTuple(new Tuple(new StringBuff("MONBEIG"), new Integer(19), new StringBuff("ETUDIANT")));
		r2.addTuple(new Tuple(new StringBuff("PROF"), new Integer(20), new StringBuff("ETUDIANT")));

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
		Schema lien = new Schema(new Attribut(new TypeVarchar(), "NOM"),
				new Attribut(new TypeVarchar(), "NOMDEFAMILLE"));
		Relation s = new Jointure(r1, r2, lien);
		for (Tuple t : s) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}
	}

}
