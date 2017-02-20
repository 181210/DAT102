package no.hib.dat102;

import no.hib.dat102.adt.CDArkivADT;


public class CDArkivKlient {
	public static void main(String[] args) {
		CDArkivADT cda = new CDArkiv();
		Meny meny = new Meny(cda);
		meny.start();
	}
}
