package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeFloat extends Type<Float> {

	public TypeFloat() {
		super();
		this.nomType = "TypeFloat";
	}
	
	@Override
	public void write(DataOutputStream os, Float valeur) throws IOException {
		os.writeFloat(valeur);
		
	}

	@Override
	public Float read(DataInputStream is) throws IOException {
		return is.readFloat();
	}

	@Override
	public Float parse(String data) {
		return new Float(data);
	}

	

}
