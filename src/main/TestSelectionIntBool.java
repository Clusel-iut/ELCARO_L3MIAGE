package main;

import java.util.ArrayList;

import recherche.Predicat;
import recherche.Selection;
import stockage.Attribut;
import stockage.BD;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.MemoryDonneesRelation;
import stockage.type.TypeBoolean;
import stockage.type.TypeInteger;

public class TestSelectionIntBool {

	public static void main(String[] args) {
		Schema sc = new Schema(new Attribut(new TypeInteger(), "ENTIER"),
				new Attribut(new TypeBoolean(), "ESTCEUNNOMBRE"));

		MemoryDonneesRelation r = new MemoryDonneesRelation("RELATION", sc);
		r.addTuple(new Tuple(new Integer(785), new Boolean(true)));
		r.addTuple(new Tuple(new Integer(9), new Boolean(false)));
		r.addTuple(new Tuple(new Integer(10), new Boolean(true)));
		r.addTuple(new Tuple(new Integer(416), new Boolean(true)));

		ArrayList<Relation> ar = new ArrayList<Relation>();
		ar.add(r);
		BD bd = new BD(ar);
		System.out.print(bd.toString());
		
		System.out.println("\nSelection des entier superieur à 400");
		Relation s1 = new Selection(r, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return ((Integer) tuple.getValue(0) > 400);
			}
		});
		System.out.println(s1.toString());
		
		System.out.println("\nSelection des nombres");
		Relation s2 = new Selection(r, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return tuple.getValue(1).equals(new Boolean(false));
			}
		});
		System.out.println(s2.toString());
	}

}
