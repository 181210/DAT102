package no.hib.dat102.mengde.tabell;

public class EmptyCollectionException extends RuntimeException {

	private static final long serialVersionUID = 7844216752170093099L;

	public EmptyCollectionException(String collection) {
		super("" + collection + " er tom.");

	}
}