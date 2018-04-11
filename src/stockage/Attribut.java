package stockage;

import stockage.type.Type;

public class Attribut {
	private final Type<?> type;
	private final String nom;

	/**
	 * @param type : le type de l'attribut
	 * @param nom : le nom de l'attribut
	 */
	public Attribut(Type<?> type, String nom) {
		super();
		this.type = type;
		this.nom = nom;
	}
	
	/**
	 * Permet de récupérer le type d'un attribut
	 * @return le type de l'attribut
	 */
	public Type<? extends Comparable<?>> getTypeOfAttribut() {
		return this.type;
	}

	/**
	 * Permet de récupérer le nom d'un attribut
	 * @return le nom de l'attribut
	 */
	public String getNomOfAttribut() {
		return this.nom;
	}

	@Override public String toString() {
		return nom + ":" + type.toString();
	}

}
