package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Type<T extends Comparable<T>> {

	protected String nomType;

	/**
	 * Permet d'écrire sur une sortie une valeur
	 * @param os : le flux de sortie
	 * @param valeur : la valeur à écrire
	 * @throws IOException erreur lors de l'écriture
	 */
	public abstract void write(DataOutputStream os, Comparable<?> valeur) throws IOException; // TODO Comparable<?> -> T

	/**
	 * Permet de lire sur une entré une valeur
	 * @param is : le flux d'entré
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
	 * Permet de récupérer la classe du type
	 * @return la classe du type
	 */
	public abstract Class<? extends Comparable<?>> getType();

}