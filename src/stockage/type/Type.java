package stockage.type;

public abstract class Type<T> {

	  protected String type;
	  
	  protected abstract void write(T valeur);
	  
	  protected abstract T read();
	  
	}