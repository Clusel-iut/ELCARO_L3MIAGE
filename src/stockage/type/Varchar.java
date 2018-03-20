package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Varchar extends Type<StringBuffer> {

	@Override
	protected void write(DataOutputStream os, StringBuffer valeur) throws IOException {
		os.writeUTF(valeur.toString()); //TODO CHANGE

	}

	@Override
	protected StringBuffer read(DataInputStream is) throws IOException {
		return new StringBuffer(is.readUTF()); //TODO CHANGE
	}

}
