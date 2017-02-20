package no.hib.data102;

import no.hib.data102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {

	private CD[] CDTab;
	private int forsteLedig = 0;
	Fil fil;

	public int getForsteLedig() {
		return forsteLedig;
	}

	public void setForsteLedig(int forsteLedig) {
		this.forsteLedig = forsteLedig;
	}

	/**
	 * Kontruktør for oppretting av CD arkiv.
	 * 
	 * @param ANTALL
	 */
	public CDarkiv(int antall) {
		// antall = hentAntall();
		CDTab = new CD[antall];
	}

	@Override
	public CD[] hentCDTabell() {
		return CDTab;
	}

	@Override
	public void leggTilCD(CD nyCD) {

		System.out.println("Førsteledig: " + getForsteLedig());

		if (forsteLedig == CDTab.length) {
			utvidKap();
		}

		for (int i = 0; i < CDTab.length; i++) {
			if (CDTab[i] != null) {
				setForsteLedig(getForsteLedig()+1);
			}
		}

		CDTab[getForsteLedig()] = nyCD;
		System.out.println("Førsteledig etter CD lagt til: " + getForsteLedig());
		
		
		

	}

	@Override
	public boolean slettCD(int CDnr) {

		boolean erSlettet = false;

		for (int i = 0; i < CDTab.length; i++) {
			if (CDTab[i].getCDnr() == CDnr) {

				CDTab[i] = CDTab[forsteLedig - 1];
				System.out.println("CD nummer: " + i + " er slettet.");
				erSlettet = true;
			} else {
				System.out.println("CDen med nummer: " + CDnr + " eksisterer ikke.");
			}
		}

		return erSlettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		CD[] hjelpeTab;
		int antTreff = 0;
		int hjelpePosisjon = 0;

		for (int i = 0; i < CDTab.length; i++) {
			if (CDTab[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				antTreff++;
			}

		}

		hjelpeTab = new CD[antTreff];

		for (int j = 0; j < CDTab.length; j++) {
			if (CDTab[j].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				hjelpeTab[hjelpePosisjon] = CDTab[j];
				hjelpePosisjon++;
			}
		}

		return hjelpeTab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {

		CD[] hjelpeTab;
		int antTreff = 0;
		int hjelpePosisjon = 0;

		System.out.println("Lengde på CD tabell: " + CDTab.length);

		for (int i = 0; i < CDTab.length; i++) {
			if (CDTab[i].getArtist().toLowerCase().contains(delstreng.toLowerCase())) {
				antTreff++;
			}

		}

		hjelpeTab = new CD[antTreff];

		for (int j = 0; j < CDTab.length; j++) {
			if (CDTab[j].getArtist().toLowerCase().contains(delstreng.toLowerCase())) {
				hjelpeTab[hjelpePosisjon] = CDTab[j];
				hjelpePosisjon++;
			}
		}

		return hjelpeTab;
	}

	@Override
	public int hentAntall() {

	
		
		return getForsteLedig();
	}

	@Override
	public int hentAntall(Sjanger sjanger) {

		int antSjanger = 0;

		for (int k = 0; k < CDTab.length; k++) {

			if (CDTab[k].getSjanger().equals(sjanger)) {
				antSjanger++;
			}

		}

		return antSjanger;
	}

	/**
	 * Utvider kaoasiteten med 10% pluss en.
	 */
	private void utvidKap() {

		CD[] hjelpeTab = new CD[(int) Math.ceil(1.1 * CDTab.length) + 1];

		for (int i = 0; i < CDTab.length; i++) {
			hjelpeTab[i] = CDTab[i];
		}

		CDTab = hjelpeTab;
	}

}
