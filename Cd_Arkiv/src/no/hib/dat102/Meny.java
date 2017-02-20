package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.adt.CDArkivADT;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private CDArkivADT cda;
	private int valg;
	private Scanner tast;

	public Meny(CDArkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public Tekstgrensesnitt getTekstgr() {
		return tekstgr;
	}

	public void setTekstgr(Tekstgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}

	public CDArkivADT getCda() {
		return cda;
	}

	public void setCda(CDArkivADT cda) {
		this.cda = cda;
	}

	public int getValg() {
		return valg;
	}

	public void setValg(int valg) {
		this.valg = valg;
	}

	public Scanner getTast() {
		return tast;
	}

	public void setTast(Scanner tast) {
		this.tast = tast;
	}

	public void start() {
		tast = new Scanner(System.in);
		hovedmeny();
		tast.close();
	}

	public void hovedmeny() {

		do {
			System.out.println("Velkommen til CD-arkivet\n" + "Hovedmeny:\n" + "1: Fortsett på eksisterende arkiv.\n"
					+ "2: Opprett ett nytt arkiv.\n" + "3: Avslutt");

			valg = tast.nextInt();

			switch (valg) {

			case 0:
				hovedmeny();

			case 1:

				System.out.print("Oppgi fil på arkiv: ");
				String filnavn = tast.next();
				cda = Fil.lesFraFil(filnavn + ".txt");
				undermeny();
				Fil.skrivTilFil(cda, filnavn + ".txt", false);
				break;
			case 2:

				System.out.print("Oppgi navn på arkiv: ");
				String Arkiv = tast.next();
				undermeny();
				Fil.skrivTilFil(cda, Arkiv + ".txt", false);
				break;
			case 3:
				break;
			default:
				System.out.println("Ikke definert valg.");
			}
		} while (valg != 3);
	}

	public void undermeny() {

		do {
			System.out.println("Undermeny:\n" + "0: Gå tilbake til hovedmeny\n" + "1: Legg til ny CD.\n"
					+ "2: Slett CD.\n" + "3: Søk på CD tittel.\n" + "4: Søk på artist/gruppe.\n" + "5: Skriv ut statistikk.\n" + 
					"6: Avslutt.");

			valg = tast.nextInt();

			switch (valg) {
			
			case 0: hovedmeny();
				break;
			case 1:

				CD nyCd = tekstgr.lesCd();
				cda.leggTilCd(nyCd);
				break;
			case 2:

				System.out.print("Oppgi CD-nummer: ");
				int cdNr = tast.nextInt();
				if (cda.slettCd(cdNr)) {
					System.out.println("Slettet CD, med cd-nummer: " + cdNr);
				} else {
					System.out.println("CD-nr: " + cdNr + " er ikke slettet");
				}
				break;
			case 3:

				System.out.print("Søk på tittel: ");
				String delstreng = tast.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 4:

				System.out.print("Søk på artist: ");
				String delstreng2 = tast.next();
				tekstgr.skrivUtCdArtist(cda, delstreng2);
				break;
			case 5:

				tekstgr.skrivUtStatistikk(cda);
				break;
			case 6:

				break;
			default:
				System.out.println("Ikke definert valg");
			}
		} while (valg != 6);
	}
}
