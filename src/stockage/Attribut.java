package stockage;
import stockage.type.Type;

// TODO error valeur (set) 
public class Attribut {
	private Type type;

	public Attribut(Type valeur) {
		super();
		this.type = valeur;
	}

	public Type getValeur() {
		return type;
	}

	public void setValeur(Type valeur) {
		this.type = valeur;
	}
	
	
}
