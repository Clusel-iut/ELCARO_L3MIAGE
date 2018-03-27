package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Short extends Type<java.lang.Short> {

	@Override
	public void write(DataOutputStream os, java.lang.Short valeur) throws IOException {
		os.writeShort(valeur);
		
	}

	@Override
	public java.lang.Short read(DataInputStream is) throws IOException {
		return is.readShort();
	}

	@Override
	public java.lang.Short parse(String data) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
