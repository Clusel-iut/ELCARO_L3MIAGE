package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Double extends Type<java.lang.Double> {

	@Override
	protected void write(DataOutputStream os, java.lang.Double valeur) throws IOException {
		os.writeDouble(valeur);
		
	}

	@Override
	protected java.lang.Double read(DataInputStream is) throws IOException {
		return is.readDouble();
	}



}
