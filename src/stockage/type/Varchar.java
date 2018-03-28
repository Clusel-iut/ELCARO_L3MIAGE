package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Varchar extends Type<StringBuff> {

	@Override
	public void write(DataOutputStream os, StringBuff valeur) throws IOException {
		os.writeUTF(valeur.toString()); //TODO CHANGE

	}

	@Override
	public StringBuff read(DataInputStream is) throws IOException {
		return new StringBuff(); //TODO USE is
	}

	@Override
	public StringBuff parse(String data) {
		return new StringBuff(data);
	}

}
