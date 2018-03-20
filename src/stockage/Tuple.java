package stockage;

import java.util.List;

public class Tuple {
	private List<Attribut> attributs;

	public Tuple(List<Attribut> attributs) {
		super();
		this.attributs = attributs;
	}

	public List<Attribut> getAttributs() {
		return attributs;
	}

	public void setAttributs(List<Attribut> attributs) {
		this.attributs = attributs;
	}
	
	
}
