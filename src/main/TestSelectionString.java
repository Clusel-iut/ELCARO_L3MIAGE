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
import stockage.type.StringBuff;
import stockage.type.TypeVarchar;

public class TestSelectionString {

	public static void main(String[] args) {
		Schema sc = new Schema(new Attribut(new TypeVarchar(), "NOM"), new Attribut(new TypeVarchar(), "PRENOM"));

		MemoryDonneesRelation r = new MemoryDonneesRelation("RELATION", sc);
		r.addTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		r.addTuple(new Tuple(new StringBuff("PIGNARD"), new StringBuff("FLORIAN")));
		r.addTuple(new Tuple(new StringBuff("MONBEIG"), new StringBuff("JONATHAN")));
		r.addTuple(new Tuple(new StringBuff("CLUSEL"), new StringBuff("MATHIEU")));

		ArrayList<Relation> ar = new ArrayList<Relation>();
		ar.add(r);
		BD bd = new BD(ar);
		System.out.print(bd.toString());

		System.out.println("\nSelection des noms suppérieur à 6");
		Relation s = new Selection(r, new Predicat() {
			@Override
			public boolean eval(Tuple tuple) {
				return ((StringBuff) tuple.getValue(0)).sb.toString().length() > 6;
			}
		});
		System.out.println(s.toString());

		System.out.println("\nSuppression d'un tuple");
		r.deleteTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
		System.out.print(bd.toString());
	}
}
