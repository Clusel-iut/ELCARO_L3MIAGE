package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeByte extends Type<Byte> {

	public TypeByte() {
		super();
		this.nomType = "TypeByte";
	}
	
	@Override
	public void write(DataOutputStream os, Comparable<?> valeur) throws IOException {
		os.writeByte((int) valeur);
		
	}

	@Override
	public Byte read(DataInputStream is) throws IOException {
		return is.readByte();
	}

	@Override
	public Byte parse(String data) {
		return new Byte(data);
	}

	@Override
	public Class<? extends Comparable<?>> getType() {
		return Byte.class;
	}



}
