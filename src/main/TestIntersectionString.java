package main;

import java.util.ArrayList;

import recherche.Intersection;
import recherche.Predicat;
import stockage.Attribut;
import stockage.BD;
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

		ArrayList<Relation> ar = new ArrayList<Relation>();
		ar.add(r);
		BD bd = new BD(ar);
		System.out.print(bd.toString());

		System.out.println("\nSelection des noms supérieur à 6 && prénom inférieur à 8");
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
		System.out.println(s1.toString());
		
		System.out.println("\nSelection des noms qui commence par G && prénom qui commence par S");
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
		System.out.println(s2.toString());
		
		System.out.println("\nSuppression d'un tuple");
		r.deleteTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		System.out.print(bd.toString());
	}

}
