package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Long extends Type<java.lang.Long> {

	@Override
	protected void write(DataOutputStream os, java.lang.Long valeur) throws IOException {
		os.writeLong(valeur);
		
	}

	@Override
	protected java.lang.Long read(DataInputStream is) throws IOException {
		return is.readLong();
	}



}
