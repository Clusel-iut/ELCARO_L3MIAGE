package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeInteger extends Type<Integer> {
	
	public TypeInteger() {
		super();
		this.nomType = "TypeInteger";
	}

	@Override
	public void write(DataOutputStream os, Comparable<?> valeur) throws IOException {
		os.writeInt((int) valeur);
	}

	@Override
	public Integer read(DataInputStream is) throws IOException {
		return is.readInt();
	}

	@Override
	public Integer parse(String data) {
		return new Integer(data);
	}

	@Override
	public Class<? extends Comparable<?>> getType() {
		return Integer.class;
	}
	
}
