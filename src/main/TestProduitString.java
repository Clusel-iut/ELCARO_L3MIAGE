package main;

import java.util.ArrayList;

import recherche.Produit;
import stockage.Attribut;
import stockage.BD;
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

		Schema sc2 = new Schema(new Attribut(new TypeInteger(), "AGE"), new Attribut(new TypeVarchar(), "STATUS"));

		MemoryDonneesRelation r2 = new MemoryDonneesRelation("RELATION2", sc2);
		r2.addTuple(new Tuple(new Integer(40), new StringBuff("PROF")));
		r2.addTuple(new Tuple(new Integer(21), new StringBuff("ETUDIANT")));
		r2.addTuple(new Tuple(new Integer(19), new StringBuff("ETUDIANT")));
		r2.addTuple(new Tuple(new Integer(20), new StringBuff("ETUDIANT")));

		ArrayList<Relation> ar = new ArrayList<Relation>();
		ar.add(r1);
		ar.add(r2);
		BD bd = new BD(ar);
		System.out.print(bd.toString());

		System.out.println("\nProduit entre les deux tables");
		Relation s = new Produit(r1, r2);
		System.out.println(s.toString());
	}

}
