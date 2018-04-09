package main;

import recherche.Intersection;
import recherche.Predicat;
import stockage.Attribut;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.MemoryDonneesRelation;
import stockage.type.StringBuff;
import stockage.type.TypeVarchar;

public class TestIntersectionString {

	public static void main(String[] args) {
		Schema sc = new Schema(new Attribut(new TypeVarchar(), "NOM"), new Attribut(new TypeVarchar(), "PRENOM"));

		//TODO Essayer avec des tuples identiques
		MemoryDonneesRelation r = new MemoryDonneesRelation("RELATION", sc);
		r.addTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		r.addTuple(new Tuple(new StringBuff("PIGNARD"), new StringBuff("FLORIAN")));
		r.addTuple(new Tuple(new StringBuff("MONBEIG"), new StringBuff("JONATHAN")));
		r.addTuple(new Tuple(new StringBuff("CLUSEL"), new StringBuff("MATHIEU")));
		r.addTuple(new Tuple(new StringBuff("GOURAT"), new StringBuff("SEBASTIEN")));

		System.out.println(r.getName());
		for (Attribut att : sc) {
			System.out.println(att.toString());
		}
		for (Tuple t : r) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}

		System.out.println("Selection des noms supérieur à 6 && prénom inférieur à 8");
		Relation s1 = new Intersection(r, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return ((StringBuff) tuple.getValue(0)).sb.toString().length() > 6;
			}
		}, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return ((StringBuff) tuple.getValue(1)).sb.toString().length() < 8;
			}
		});
		for (Tuple t1 : s1) {
			for (Object o1 : t1)
				System.out.print(o1 + " ");
			System.out.println();
		}

		System.out.println("Selection des noms qui commence par G && prénom qui commence par S");
		Relation s2 = new Intersection(r, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return ((StringBuff) tuple.getValue(0)).sb.toString().startsWith("G");
			}
		}, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return ((StringBuff) tuple.getValue(1)).sb.toString().startsWith("S");
			}
		});
		for (Tuple t1 : s2) {
			for (Object o1 : t1)
				System.out.print(o1 + " ");
			System.out.println();
		}
		
		System.out.println("Suppression d'un tuple");
		r.deleteTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		for (Tuple t : r) {
			for (Object o : t)
				System.out.print(o + " ");
			System.out.println();
		}
	}

}
