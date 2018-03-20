package stockage.type;

public abstract class Type<T> {

	protected String nomType;

	protected abstract void write(T valeur);

	protected abstract T read();

}
// Byte, Short, Integer, Long, Float, Double, Character, Boolean