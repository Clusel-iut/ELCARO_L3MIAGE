package stockage.type;

public class StringBuff implements Comparable<StringBuff> {
	public StringBuffer sb;

	public StringBuff() {
		sb = new StringBuffer();
	}

	@Override
	public int compareTo(StringBuff s) {
		return  sb.toString().compareTo(s.toString());
	}

}
