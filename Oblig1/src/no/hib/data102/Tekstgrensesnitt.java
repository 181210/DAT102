package no.hib.data102;

import java.util.Scanner;

import no.hib.data102.Sjanger;
import no.hib.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {

	Scanner tastatur = new Scanner(System.in);

	/**
	 * Skriver inn opplysninger om en CD fra tastatur
	 */

	public CD lesCD() {

		int CDnr;
		String artist;
		String tittel;
		int aar;
		Sjanger sjanger;
		String plateselskap;

		CDnr = (int) (Math.random() * 10);

		System.out.println("Artist eller gruppe: ");
		artist = tastatur.next();

		System.out.println("Tittel: ");
		tittel = tastatur.next();

		System.out.println("År: ");
		aar = tastatur.nextInt();

		System.out.println("Kode for sjanger (ROCK(0), POP(1), OPERA(2), CLASSIC(3): ");
		sjanger = Sjanger.finnSjanger(tastatur.nextInt());

		System.out.println("Plateselskap: ");
		plateselskap = tastatur.next();

		CD nyCD = new CD(CDnr, artist, tittel, aar, sjanger, plateselskap);

		return nyCD;
	}

	/**
	 * Viser all informasjon om en CD
	 */
	public void visCD(CD cd) {

		System.out.println("CD-nummer: " + cd.getCDnr());
		System.out.println("Artist: " + cd.getArtist());
		System.out.println("Tittel: " + cd.getTittel());
		System.out.println("År: " + cd.getAar());
		System.out.println("Sjanger: " + cd.getSjanger());
		System.out.println("Plateselskap: " + cd.getPlateselskap());

	}

	/**
	 * Skriver ut CD-er med delstreng i tittel
	 */
	public void skrivUtDelstrengTittel(CDarkivADT cda, String delstreng) {

		CD[] hjelpeTab = cda.sokTittel(delstreng);

		if (hjelpeTab.length > 0) {

			for (int i = 0; i < hjelpeTab.length; i++) {
				System.out.println(hjelpeTab[i].getTittel());
			}

		} else {
			System.out.println("Det er ingen CDer med " + delstreng + " i tittelen.");
		}

	}

	/**
	 * Skriver ut CD-er med delstreng i artist
	 */
	public void skrivUtDelstrengArtist(CDarkivADT cda, String delstreng) {

		CD[] hjelpeTab = cda.sokArtist(delstreng);

		if (hjelpeTab.length > 0) {

			for (int i = 0; i < hjelpeTab.length; i++) {
				System.out.println(hjelpeTab[i].getArtist());
			}

		} else {
			System.out.println("Det er ingen CDer med " + delstreng + " i artistnavnet.");

		}
	}

	/**
	 * Skriver ut statistikk om arkivet
	 */
	public void skrivUtStatistikk(CDarkivADT cda) {

		System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());

		for (Sjanger s : Sjanger.values()) {
			System.out.println("Antall CD'er i sjanger " + s.name() + " er: " + cda.hentAntall(s));
		}

	}

}
