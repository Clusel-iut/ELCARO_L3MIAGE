package recherche;

import stockage.Tuple;

public abstract class Predicat {
	/**
	 * @param tuple : un tuple
	 * @return true si le tuple correspond au critère sinon false.
	 */
	public abstract boolean eval(Tuple tuple);

	/**
	 * @param attrIndex : 
	 * @param value : 
	 * @param operator :
	 * @return 
	 */
	public static Predicat createPredicat(int attrIndex, Object value, String operator) {
		Predicat pred = null;
		switch (operator) {
		case "=":
			pred = new Predicat() {
				@Override public boolean eval(Tuple tuple) {
					return tuple.getValue(attrIndex).equals(value);
				}
			};
			break;
		case ">":
			if (value.getClass() == Integer.class || value.getClass() == Double.class) {
				pred = new Predicat() {
					@Override public boolean eval(Tuple tuple) {
						return Integer.parseInt(tuple.getValue(attrIndex).toString()) > Integer.parseInt(value.toString());
					}
				};
			}
			break;
		case "<":
			if (value.getClass() == Integer.class || value.getClass() == Double.class) {
				pred = new Predicat() {
					@Override public boolean eval(Tuple tuple) {
						return Integer.parseInt(tuple.getValue(attrIndex).toString()) < Integer.parseInt(value.toString());
					}
				};
			}
			break;
		}
		return pred;
	}
}
