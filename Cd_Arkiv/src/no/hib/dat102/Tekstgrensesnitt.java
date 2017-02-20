package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.adt.CDArkivADT;

public class Tekstgrensesnitt {
	private Scanner tast;

	/**
	 * Leser inn ny CD fra bruker
	 * @return CD
	 */
	public CD lesCd() {
		tast = new Scanner(System.in);

		int cdNr = (int) (Math.random() * 100);

		System.out.print("Artist/gruppe: ");
		String artist = tast.nextLine();
		
		System.out.print("Årstall: ");
		int lanseringsaar = tast.nextInt();

		System.out.print("Tittel: ");
		String tittel = tast.next();

		System.out.print("Sjanger: ");
		Sjanger sjanger = Sjanger.finnSjanger(tast.next());

		System.out.print("Oppgi plateselskap: ");
		String plateselskap = tast.next();

		CD nycd = new CD(cdNr, artist, tittel, lanseringsaar, sjanger, plateselskap);
		
		return nycd;
	}

	/**
	* Skriver ut CD info
	* @param cd
	 */
	public void visCD(CD cd) {
		System.out.println(cd.toString());
	}

	/**
	 * Søker CD tittel fra delstreng
	 * @param cda
	 * @param delstreng
	 */
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		CD[] cdsamling = cda.sokTittel(delstreng);

		for (int i = 0; i < cda.hentAntall(); i++) {
			if (cdsamling[i] != null) {
				System.out.println(cdsamling[i].getTittel());
			}
		}
	}

	/**
	 * Søker CD artist fra delstreng
	 * @param cda
	 * @param delstreng
	 */
	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) {
		CD[] cdsamling = cda.sokArtist(delstreng);

		System.out.println("\nFinner artister på " + delstreng + " : ");
		for (int i = 0; i < cda.hentAntall(); i++) {
			if (cdsamling[i] != null) {
				System.out.println(cdsamling[i].toString());
			}
		}
	}


	/**
	 * Skriver ut statistikk. Ant CDer og sjanger
	 * @param cda
	 */
	public void skrivUtStatistikk(CDArkivADT cda) {
		System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());
		for(Sjanger s : Sjanger.values()) {
			System.out.println("Antall CD'er med sjangeren "+s.name()+": " + cda.hentAntall(Sjanger.finnSjanger(s.name())));
		}
	}
}