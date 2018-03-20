package stockage.type;

public class Integer extends Type<Integer> {

	@Override
	protected void write(Integer valeur) {
		
	}
	
	@Override
	protected Integer read() {
		return new Integer();
	}
}
