package no.hib.data102;

import java.util.Scanner;

import no.hib.data102.adt.CDarkivADT;

public class Meny {

	private Tekstgrensesnitt tgs;
	private CDarkivADT cda;
	private Fil fil;
	private String arkivNavn;
	private String arkivOversikt = "ArkivOversikt.txt";
	private String antallArkiv = "AntallArkiver.txt";

	private int forsteledig = 0;

	public int getForsteledig() {
		return forsteledig;
	}

	public void setForsteledig(int forsteledig) {
		this.forsteledig = forsteledig;
	}

	public String getArkivNavn() {
		return arkivNavn;
	}

	public void setArkivNavn(String arkivNavn) {
		this.arkivNavn = arkivNavn;
	}

	Scanner tastatur = new Scanner(System.in);

	public Meny(CDarkivADT cda) {
		this.cda = cda;
		tgs = new Tekstgrensesnitt();
		fil = new Fil();

	}

	public void start() {

		hovedMeny();

	}

	public void underMeny() {

		System.out.println("Meny:\n" + "0: Gå tilbake til hovedmeny\n" + "1: Legg til ny CD.\n" + "2: Søk etter CDer.\n"
				+ "3: Søk etter artist eller gruppe.\n" + "4: Skriv ut statistikk.");

		int valg = tastatur.nextInt();

		switch (valg) {

		case 0:
			hovedMeny();
			break;
		case 1:

			cda.leggTilCD(tgs.lesCD());
			fil.skrivTilFil(cda, getArkivNavn(), false);

			underMeny();

			break;
		case 2:

			System.out.println("Søk etter CDer: ");

			String sok = tastatur.next();

			cda.sokArtist(sok);

			tgs.skrivUtDelstrengTittel(cda, sok);

			underMeny();

			break;
		case 3:

			System.out.println("Søk etter artist eller gruppe: ");

			String sok1 = tastatur.next();

			cda.sokTittel(sok1);

			tgs.skrivUtDelstrengArtist(cda, sok1);

			underMeny();

			break;
		case 4:

			tgs.skrivUtStatistikk(cda);

			underMeny();

		}

	}

	public void hovedMeny() {

		int valg;

		System.out.println(

				"Velkommen til CD-arkivet\n" + "Hovedmeny:\n" + "1: Opprett ett nytt arkiv.\n"
						+ "2: Fortsett på eksisterende arkiv.");

		valg = tastatur.nextInt();

		if (valg != 1 && valg != 2) {
			System.out.println("Valget er ugyldig!");
			hovedMeny();

		} else {

			switch (valg) {
			case 1:

				System.out.println("Oppgi navn på nytt arkiv: ");

				setArkivNavn(tastatur.next() + ".txt");

				setForsteledig(getForsteledig() + 1);

				fil.skrivTilFil(antallArkiv, false, getForsteledig());

				fil.skrivTilFil(arkivNavn + "#", arkivOversikt, antallArkiv, true);

				fil.skrivTilFil(cda, arkivNavn, true);

				underMeny();

				// hovedMeny();

				break;
			case 2:

				System.out.println("Velg blant eksisterende arkiv:\n");

				fil.lesFraFil1(arkivOversikt, antallArkiv);

				System.out.println("Skriv inn filnavn: ");

				setArkivNavn(tastatur.next());

				fil.skrivTilFil(cda, getArkivNavn(), true);

				underMeny();

				break;
			}

		}

	}

}
