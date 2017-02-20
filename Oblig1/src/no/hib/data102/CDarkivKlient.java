package no.hib.data102;

import java.io.IOException;

import no.hib.data102.CDarkiv;
import no.hib.data102.Meny;
import no.hib.data102.adt.CDarkivADT;

public class CDarkivKlient {

	public static void main(String[] args) throws IOException {

		final int ANTALL = 20;

		CDarkivADT cda = (CDarkivADT) new CDarkiv(ANTALL);
		Meny meny = new Meny(cda);

		meny.start();

	}

}
