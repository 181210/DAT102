package no.hib.dat102;

import no.hib.dat102.Meny;
import no.hib.dat102.adt.CDArkivADT;

public class CDArkiv2Klient {
	public static void main(String[] args) {
		CDArkivADT cda = new CDArkiv2();
		Meny meny = new Meny(cda);
		meny.start();
	}
}