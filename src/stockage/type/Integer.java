package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Integer extends Type<java.lang.Integer> {

	@Override
	public void write(DataOutputStream os, java.lang.Integer valeur) throws IOException {
		os.writeInt(valeur);
		
	}

	@Override
	public java.lang.Integer read(DataInputStream is) throws IOException {
		return is.readInt();
	}

	@Override
	public java.lang.Integer parse(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
