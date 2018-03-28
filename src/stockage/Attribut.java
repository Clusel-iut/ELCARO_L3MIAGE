package stockage;
import stockage.type.Type;

public class Attribut {
	private Type type;

	public Attribut(Type type) {
		super();
		this.type = type;
	}

	/**
	 * @return Type : retourn le type de l'attribut
	 */
	public Type getTypeOfAttribut() {
		return type;
	}
	
}
