package main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import recherche.Predicat;
import recherche.Selection;
import stockage.Attribut;
import stockage.BD;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.FileDonneesRelation;
import stockage.type.StringBuff;
import stockage.type.TypeVarchar;

public class TestSelectionStringFile {

	public static void main(String[] args) {

		DataInputStream dis;
		DataOutputStream dos;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test.primitif"))));
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("test.primitif"))));

			Schema sc = new Schema(new Attribut(new TypeVarchar(), "NOM"), new Attribut(new TypeVarchar(), "PRENOM"));
			FileDonneesRelation fd = new FileDonneesRelation("RELATION", sc, dis, dos);

			fd.addTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
			fd.addTuple(new Tuple(new StringBuff("PIGNARD"), new StringBuff("FLORIAN")));
			fd.addTuple(new Tuple(new StringBuff("MONBEIG"), new StringBuff("JONATHAN")));
			fd.addTuple(new Tuple(new StringBuff("CLUSEL"), new StringBuff("MATHIEU")));

			ArrayList<Relation> ar = new ArrayList<Relation>();
			ar.add(fd);
			BD bd = new BD(ar);
			System.out.print(bd.toString());
			
			System.out.println("\nSelection des noms suppérieur à 6");
			Relation s = new Selection(fd, new Predicat() {
				@Override
				public boolean eval(Tuple tuple) {
					return ((StringBuff) tuple.getValue(0)).sb.toString().length() > 6;
				}
			});
			System.out.println(s.toString());

			System.out.println("\nSuppression d'un tuple");
			fd.deleteTuple(new Tuple(new StringBuff("MORAT"), new StringBuff("PHILIPPE")));
			System.out.print(bd.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
