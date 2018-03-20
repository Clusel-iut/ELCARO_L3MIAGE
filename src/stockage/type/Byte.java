package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Byte extends Type<java.lang.Byte> {

	@Override
	protected void write(DataOutputStream os, java.lang.Byte valeur) throws IOException {
		os.writeByte(valeur);
		
	}

	@Override
	protected java.lang.Byte read(DataInputStream is) throws IOException {
		return is.readByte();
	}



}
