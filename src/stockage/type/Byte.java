package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Byte extends Type<java.lang.Byte> {

	@Override
	public void write(DataOutputStream os, java.lang.Byte valeur) throws IOException {
		os.writeByte(valeur);
		
	}

	@Override
	public java.lang.Byte read(DataInputStream is) throws IOException {
		return is.readByte();
	}

	@Override
	public java.lang.Byte parse(String data) {
		return new java.lang.Byte(data);
	}



}
