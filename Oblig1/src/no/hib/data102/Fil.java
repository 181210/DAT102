package no.hib.data102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hib.data102.Sjanger;
import no.hib.data102.adt.*;

public class Fil {

	public CDarkivADT cda;
	public String filnavn;
	public boolean utvid;
	private static String SKILLE = "#";
	public Meny meny;
	private int antall;
	
	
	

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	/**
	 * @param filnavn
	 * @return Referansen til CD-arkivet
	 * @throws java.io.IOException
	 */

	public CDarkivADT lesFraFil(String filnavn) {

		CDarkivADT cda = null;

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);

			// Oppretter CDarkiv
			cda = new CDarkiv(n);

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.finnSjanger(Integer.parseInt(felt[4]));
				String plselskap = felt[5];

				CD cd = new CD(nr, artist, tittel, aar, sjanger, plselskap);

				cda.leggTilCD(cd);
			}

			// 4 - Lukk filen
			innfil.close();

		} catch (FileNotFoundException unntak) {// arver fra IOException må stå
												// først
												// hvis ikke vil unntaket for
												// IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

		return cda;
	}

	public void lesFraFil1(String filnavn, String antallArkiv) {
		
		int antall = lesFraArkivFil(antallArkiv);
		
		
		String[] fil = new String[antall];

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			for (int i = 0; i < antall; i++) {

				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);

				fil[i] = felt[0];

				System.out.println(fil[i]);

			}

			System.out.println();

			innfil.close();

		} catch (FileNotFoundException e) {
			System.out.println("Finner ikke filen " + filnavn);
			
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

	}

	public void skrivTilFil(CDarkivADT cdarkiv, String filnavn, boolean utvid) {

		int antall = cdarkiv.hentAntall();
		
		//System.out.println("antall i skriv til fil" + antall);
		try {

			FileWriter cdaFil = new FileWriter(filnavn, false);

			PrintWriter utfil = new PrintWriter(cdaFil);

			utfil.println(antall);
			for (int i = 0; i < antall; i++) {
				utfil.print(cdarkiv.hentCDTabell()[i].getCDnr());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getAar());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getSjanger());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getPlateselskap());
				utfil.println();
			}

			utfil.close();

		} catch (IOException e) {
			System.err.println("Feil! : " + e);
			System.exit(1);

		}


	}

	/**
	 * 
	 * Skriver arkivnavn til fil.
	 *
	 * @param filnavn
	 * @param arkivNavn
	 * @param utvid
	 * 
	 */
	public int skrivTilFil(String filnavn, String arkivNavn, String arkivNummer, boolean utvid) {

		

		try {

			FileWriter fil = new FileWriter(arkivNavn, utvid);

			PrintWriter utFil = new PrintWriter(fil);

			utFil.println(filnavn);

			utFil.close();

		} catch (IOException e) {

		}
		
		setAntall(lesFraArkivFil(arkivNummer));

		return getAntall();
	}

	/*
	 * To
	 * 
	 * /** Overskriver antall øverst i fil.
	 * 
	 * @param arkivNavn
	 * 
	 * @param utvid
	 * 
	 * @param antall
	 */

	public void skrivTilFil(String arkivNavn, boolean utvid, int antall) {

		//System.out.println("Antall i fil: " + antall);

		try {
			FileWriter fil = new FileWriter(arkivNavn, utvid);

			PrintWriter utfil = new PrintWriter(fil);

			utfil.println(antall);

			utfil.close();
		} catch (IOException e) {

		}

	}

	public int lesFraArkivFil(String filnavn) {

		

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			setAntall(Integer.parseInt(linje));
			
			innfil.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}
		
		
		
		return getAntall();

	}
}// class
