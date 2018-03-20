package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Integer extends Type<java.lang.Integer> {

	@Override
	protected void write(DataOutputStream os, java.lang.Integer valeur) throws IOException {
		os.writeInt(valeur);
		
	}

	@Override
	protected java.lang.Integer read(DataInputStream is) throws IOException {
		return is.readInt();
	}

	
}
