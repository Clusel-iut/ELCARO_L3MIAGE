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
import stockage.type.TypeBoolean;
import stockage.type.TypeInteger;

public class TestSelectionBoolFile {

	public static void main(String[] args) {

		DataInputStream dis;
		DataOutputStream dos;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test.primitif"))));
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("test.primitif"))));

			Schema sc = new Schema(new Attribut(new TypeInteger(), "ENTIER"), new Attribut(new TypeBoolean(), "ESTCEUNNOMBRE"));
			FileDonneesRelation fd = new FileDonneesRelation("RELATION", sc, dis, dos);

			fd.addTuple(new Tuple(new Integer(785), new Boolean(true)));
			fd.addTuple(new Tuple(new Integer(9), new Boolean(false)));
			fd.addTuple(new Tuple(new Integer(10), new Boolean(true)));
			fd.addTuple(new Tuple(new Integer(416), new Boolean(true)));

			ArrayList<Relation> ar = new ArrayList<Relation>();
			ar.add(fd);
			BD bd = new BD(ar);
			System.out.print(bd.toString());

			System.out.println("\nSelection des entier superieur à 400");
			Relation s1 = new Selection(fd, new Predicat() {
				@Override
				public boolean eval(Tuple tuple) {
					return (Integer) tuple.getValue(0) > 400;
				}
			});
			System.out.println(s1.toString());
			
			System.out.println("\nSelection des nombres");
			Relation s2 = new Selection(fd, new Predicat() {
				@Override
				public boolean eval(Tuple tuple) {
					return tuple.getValue(1).equals(new Boolean(false));
				}
			});
			System.out.println(s2.toString());
			
			dos.close();
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
