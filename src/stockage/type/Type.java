package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Type<T extends Comparable<T>> {

	protected String nomType;

	/**
	 * Permet d'�crire sur une sortie une valeur
	 * @param os : le flux de sortie
	 * @param valeur : la valeur � �crire
	 * @throws IOException erreur lors de l'�criture
	 */
	public abstract void write(DataOutputStream os, Comparable<?> valeur) throws IOException; // TODO Comparable<?> -> T

	/**
	 * Permet de lire sur une entr� une valeur
	 * @param is : le flux d'entr�
	 * @return la valeur lue
	 * @throws IOException erreur de lecture
	 */
	public abstract T read(DataInputStream is) throws IOException;

	/**
	 * Permet de mettre en lien un string et un type
	 * @param data : le nom d'un type
	 * @return le type associer
	 */
	public abstract T parse(String data);

	@Override public String toString() {
		return nomType;
	}

	/**
	 * Permet de r�cup�rer la classe du type
	 * @return la classe du type
	 */
	public abstract Class<? extends Comparable<?>> getType();

}