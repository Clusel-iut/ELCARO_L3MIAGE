package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Type<T extends Comparable<T>> {

	protected String nomType;

	public abstract void write(DataOutputStream os, Comparable<?> valeur) throws IOException; // TODO Comparable<?> -> T

	public abstract T read(DataInputStream is) throws IOException;

	public abstract T parse(String data);

	@Override
	public String toString() {
		return nomType;
	}

	public abstract Class<? extends Comparable<?>> getType();

}