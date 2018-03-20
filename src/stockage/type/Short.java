package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Short extends Type<java.lang.Short> {

	@Override
	protected void write(DataOutputStream os, java.lang.Short valeur) throws IOException {
		os.writeShort(valeur);
		
	}

	@Override
	protected java.lang.Short read(DataInputStream is) throws IOException {
		return is.readShort();
	}

	

}
