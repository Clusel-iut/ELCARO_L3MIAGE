package stockage.type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TypeDouble extends Type<Double> {
	
	/**
	 *  \\\\\\
	 */
	public TypeDouble() {
		super();
		this.nomType = "TypeDouble";
	}
	
	@Override
	public void write(DataOutputStream os, Double valeur) throws IOException {
		os.writeDouble(valeur);
		
	}

	@Override
	public Double read(DataInputStream is) throws IOException {
		return is.readDouble();
	}

	@Override
	public Double parse(String data) {
		return new Double(data);
	}



}
