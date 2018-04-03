package stockage.type;

public class StringBuff implements Comparable<StringBuff> {
	
	@Override
	public String toString() {
		return sb.toString();
	}

	public StringBuffer sb;

	public StringBuff() {
		sb = new StringBuffer();
	}

	public StringBuff(String data) {
		sb = new StringBuffer(data);
	}

	@Override
	public int compareTo(StringBuff s) {
		return sb.toString().compareTo(s.toString());
	}

}
