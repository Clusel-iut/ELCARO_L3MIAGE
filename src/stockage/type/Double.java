package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Double extends Type<java.lang.Double> {

	@Override
	public void write(DataOutputStream os, java.lang.Double valeur) throws IOException {
		os.writeDouble(valeur);
		
	}

	@Override
	public java.lang.Double read(DataInputStream is) throws IOException {
		return is.readDouble();
	}

	@Override
	public java.lang.Double parse(String data) {
		return new java.lang.Double(data);
	}



}
