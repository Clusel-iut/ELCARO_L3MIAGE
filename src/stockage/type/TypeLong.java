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
	public void write(DataOutputStream os, Long valeur) throws IOException {
		os.writeLong(valeur);
		
	}

	@Override
	public Long read(DataInputStream is) throws IOException {
		return is.readLong();
	}

	@Override
	public Long parse(String data) {
		return new Long(data);
	}



}
