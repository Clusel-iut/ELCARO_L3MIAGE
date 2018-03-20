package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Float extends Type<java.lang.Float> {

	@Override
	protected void write(DataOutputStream os, java.lang.Float valeur) throws IOException {
		os.writeFloat(valeur);
		
	}

	@Override
	protected java.lang.Float read(DataInputStream is) throws IOException {
		return is.readFloat();
	}

	

}
