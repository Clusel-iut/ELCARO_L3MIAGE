package stockage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Dictionary;
import stockage.type.Type;


public class Schema {
	private Dictionary<String, Type> attributs;
	
	public Schema() {
		super();
	}
	
	public Schema(Dictionary<String, Type> attributs) {
		super();
		this.attributs = attributs;
	}
	
	public Schema(String fileName) throws FileNotFoundException {
		Schema schema = null;
	    XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
	    try {
	    	this.attributs = ((Schema)decoder.readObject()).attributs;
	    } finally {
	        decoder.close();
	    }
	}
	
	public void saveSchema(String fileName) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
        try {
            encoder.writeObject(this);
            encoder.flush();
        } finally {
            encoder.close();
        }
	}
	
}
