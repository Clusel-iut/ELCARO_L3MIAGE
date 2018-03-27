package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Float extends Type<java.lang.Float> {

	@Override
	public void write(DataOutputStream os, java.lang.Float valeur) throws IOException {
		os.writeFloat(valeur);
		
	}

	@Override
	public java.lang.Float read(DataInputStream is) throws IOException {
		return is.readFloat();
	}

	@Override
	public java.lang.Float parse(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
