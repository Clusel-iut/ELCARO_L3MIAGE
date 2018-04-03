package main;

import recherche.Predicat;
import recherche.Selection;
import stockage.Attribut;
import stockage.Relation;
import stockage.Schema;
import stockage.Tuple;
import stockage.memory.MemoryDonneesRelation;
import stockage.type.StringBuff;
import stockage.type.TypeVarchar;

public class Test {

	public static void main(String[] args) {
		Schema sc = new Schema(new Attribut(new TypeVarchar(),"NOM"),new Attribut(new TypeVarchar(),"PRENOM"));
	
		MemoryDonneesRelation r = new MemoryDonneesRelation("RELATION",sc);
		r.addTuple(new Tuple(new StringBuff("MORAT"),new StringBuff("PHILIPPE")));
		r.addTuple(new Tuple(new StringBuff("PIGNARD"),new StringBuff("FLORIAN")));
		r.addTuple(new Tuple(new StringBuff("MONBEIG"),new StringBuff("JONATHAN")));
		r.addTuple(new Tuple(new StringBuff("CLUSEL"),new StringBuff("MATHIEU")));
		
		System.out.println(r.getName());
		for (Attribut att : sc) {
			System.out.println(att.toString());
		}
		for(Tuple t : r){
			for(Object o : t) System.out.print(o+" ");
			System.out.println();
		}
		Relation s = new Selection(r,new Predicat(){
			@Override public boolean eval(Tuple tuple) { return ((StringBuff)tuple.get(0)).sb.toString().length()>6;
			}});
		for(Tuple t : s){
			for(Object o : t) System.out.print(o+" ");
			System.out.println();
		}
	}

}
