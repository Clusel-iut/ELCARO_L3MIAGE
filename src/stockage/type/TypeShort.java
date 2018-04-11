package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeShort extends Type<Short> {

	public TypeShort() {
		super();
		this.nomType = "TypeShort";
	}

	@Override public void write(DataOutputStream os, Comparable<?> valeur) throws IOException {
		os.writeShort((int) valeur);
	}

	@Override public Short read(DataInputStream is) throws IOException {
		return is.readShort();
	}

	@Override public Short parse(String data) {
		return new Short(data);
	}

	@Override public Class<? extends Comparable<?>> getType() {
		return Short.class;
	}
}
