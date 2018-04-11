package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeBoolean extends Type<Boolean> {

	public TypeBoolean() {
		super();
		this.nomType = "TypeBoolean";
	}

	@Override public void write(DataOutputStream os, Comparable<?> valeur) throws IOException {
		os.writeBoolean((boolean) valeur);		
	}

	@Override public Boolean read(DataInputStream is) throws IOException {
		return is.readBoolean();
	}

	@Override public Boolean parse(String data) {
		return new Boolean(data);
	}

	@Override public Class<? extends Comparable<?>> getType() {
		return Boolean.class;
	}
}
