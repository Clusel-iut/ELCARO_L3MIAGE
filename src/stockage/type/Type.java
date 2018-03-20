package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Type<T> {

	protected String nomType;

	protected abstract void write(DataOutputStream os, T valeur) throws IOException;

	protected abstract T read(DataInputStream is) throws IOException;

}
// Byte, Short, Integer, Long, Float, Double, Character, Boolean