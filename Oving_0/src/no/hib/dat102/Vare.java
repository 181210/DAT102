package no.hib.dat102;

import java.util.*;

public class Vare {

	private int vareNr;
	private String navn;
	private double pris;

	public int getVareNr() {
		return vareNr;
	}

	public void setVareNr(int vareNr) {
		this.vareNr = vareNr;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public Vare() {
		this(0,"",0.0);
	}

	public Vare(int vareNr) {
		this(vareNr, "", 0.0);
	}

	public Vare(int vareNr, String navn, double pris) {
		this.vareNr = vareNr;
		this.navn = navn;
		this.pris = pris;
	}

	public void lesVare(int vareNr) {

		Scanner tastatur = new Scanner(System.in);

		System.out.println("Vennligst oppgi varenavn: ");

		navn = tastatur.nextLine();

		System.out.println("Vennligst oppgi pris: ");
		
		pris = tastatur.nextDouble();
		
		while(pris < 0){

		if (pris < 0) {
			System.out.println("Prisen er ikke gyldig. Vennligt oppgi ny pris: ");
			
		} else {
			
			pris = tastatur.nextDouble();
		}
		
		}

		tastatur.close();

	}

}
