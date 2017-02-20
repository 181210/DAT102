package no.hib.dat102;

import java.util.Iterator;

public class Medlem {
	/**
	 * Klasse for medlem
	 * 
	 * @author kanen
	 */

	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	/**
	 * Standard-konstruktør
	 */
	public Medlem() {
		navn = "";
		hobbyer = null;
		statusIndeks = -1;
	}

	/**
	 * Konstruktør Medlem
	 * 
	 * @param navn
	 * @param hobbyer
	 * @param statusIndeks
	 */
	public Medlem(String navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = statusIndeks;
	}

	/**
	 * Skriver ut informasjon om et medlem
	 */
	public void skrivUt() {
		Iterator<Hobby> itr = hobbyer.oppramser();

		System.out.println("Navn: " + navn);

		while (itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
		System.out.println("Status: " + statusIndeks);

	}

	/**
	 * Sammenligner to medlemmers hobbyer.
	 * @param medlem2
	 * @return passerSammen dersom hobbyene er like
	 */
	public boolean passerSammen(Medlem medlem2) {
		boolean passerSammen = false;

		if (hobbyer.erLik(medlem2.hobbyer)) {
			passerSammen = true;
		}

		return passerSammen;
	}

}
