package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeLong extends Type<Long> {

	public TypeLong() {
		super();
		this.nomType = "TypeLong";
	}

	@Override
	public void write(DataOutputStream os, Comparable<?> valeur) throws IOException {
		os.writeLong((long) valeur);
	}

	@Override
	public Long read(DataInputStream is) throws IOException {
		return is.readLong();
	}

	@Override
	public Long parse(String data) {
		return new Long(data);
	}

	@Override
	public Class<? extends Comparable<?>> getType() {
		return Long.class;
	}

}
