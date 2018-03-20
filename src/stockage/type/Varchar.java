package stockage.type;

public class Varchar extends Type<StringBuffer> {

	
	@Override
	protected void write(StringBuffer valeur) {
		
	}
	
	@Override
	protected StringBuffer read() {
		return new StringBuffer("");
	}

}
