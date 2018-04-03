package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeShort extends Type<Short> {

	public TypeShort() {
		super();
		this.nomType = "TypeShort";
	}
	
	@Override
	public void write(DataOutputStream os, Short valeur) throws IOException {
		os.writeShort(valeur);
		
	}

	@Override
	public Short read(DataInputStream is) throws IOException {
		return is.readShort();
	}

	@Override
	public Short parse(String data) {
		return new Short(data);
	}

	

}
