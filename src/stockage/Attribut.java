package stockage;
import stockage.type.Type;

public class Attribut {
	private final Type type;
	private final String nom;

	public Attribut(Type type, String nom) {
		super();
		this.type = type;
		this.nom=nom;
	}

	/**
	 * @return Type : retourn le type de l'attribut
	 */
	public Type getTypeOfAttribut() {
		return type;
	}
	
}
