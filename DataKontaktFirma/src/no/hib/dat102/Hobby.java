package no.hib.dat102;

public class Hobby {
	
	/**
	 * Klasse for hobby
	 * @author kanen
	 */

	private String hobbyNavn;

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}

	/**
	 * Konstruktør for hobby
	 * 
	 * @param hobby
	 */
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	/**
	 * Returnerer hobbynavn med < >
	 */
	public String toString() {
		return "<" + hobbyNavn + ">";
	}

	/**
	 * Sammenligner to hobbyer
	 */
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

} //class
