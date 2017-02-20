package no.hib.dat102;

import java.util.Scanner;

/**
 * Dette er klasse for vare.
 * 
 * @author kanen
 *
 */

public class Vare {

	private int vareNr;
	private String vareNavn;
	private double varePris;

	public int getVareNr() {
		return vareNr;
	}

	public void setVareNr(int vareNr) {
		this.vareNr = vareNr;
	}

	public String getVareNavn() {
		return vareNavn;
	}

	public void setVareNavn(String vareNavn) {
		this.vareNavn = vareNavn;
	}

	public double getVarePris() {
		return varePris;
	}

	public void setVarePris(double varePris) {
		this.varePris = varePris;
	}

	Scanner tast = new Scanner(System.in);

	/**
	 * Standard-konstruktør
	 */
	public Vare() {
		this(0, "", 0.0);
	}

	/**
	 * Konstruktør med varenummer parameter
	 * 
	 * @param vareNr
	 */
	public Vare(int vareNr) {
		this(vareNr, "", 0.0);
	}

	/**
	 * Kontruktør med alle variablene som parameter
	 * 
	 * @param vareNr
	 * @param vareNavn
	 * @param varePris
	 */
	public Vare(int vareNr, String vareNavn, double varePris) {
		this.vareNr = vareNr;
		this.vareNavn = vareNavn;
		this.varePris = varePris;
	}

	/**
	 * Leser inn informasjon om pris og navn fra bruker
	 * 
	 * @param vareNr
	 */
	public void lesVare(int vareNr) {

		System.out.println("Oppgi navn på varen: ");

		setVareNavn(tast.next());

		System.out.println("Oppgi varens pris: ");

		double pris = tast.nextDouble();

		if (pris < 0) {
			System.out.println("Vennligst oppgi en posistiv verdi!");
		} else {
			setVarePris(pris);
		}
	}

}
