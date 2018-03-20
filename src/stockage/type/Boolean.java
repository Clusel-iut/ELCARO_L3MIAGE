package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Boolean extends Type<java.lang.Boolean> {

	@Override
	protected void write(DataOutputStream os, java.lang.Boolean valeur) throws IOException {
		os.writeBoolean(valeur);		
	}

	@Override
	protected java.lang.Boolean read(DataInputStream is) throws IOException {
		return is.readBoolean();
	}

}
