package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Boolean extends Type<java.lang.Boolean> {

	@Override
	public void write(DataOutputStream os, java.lang.Boolean valeur) throws IOException {
		os.writeBoolean(valeur);		
	}

	@Override
	public java.lang.Boolean read(DataInputStream is) throws IOException {
		return is.readBoolean();
	}

	@Override
	public java.lang.Boolean parse(String data) {
		// TODO Auto-generated method stub
		return null;
	}

}
