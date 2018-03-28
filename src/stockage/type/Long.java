package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Long extends Type<java.lang.Long> {

	@Override
	public void write(DataOutputStream os, java.lang.Long valeur) throws IOException {
		os.writeLong(valeur);
		
	}

	@Override
	public java.lang.Long read(DataInputStream is) throws IOException {
		return is.readLong();
	}

	@Override
	public java.lang.Long parse(String data) {
		return new java.lang.Long(data);
	}



}
