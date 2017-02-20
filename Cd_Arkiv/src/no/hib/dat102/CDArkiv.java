package no.hib.dat102;

import no.hib.dat102.adt.CDArkivADT;

public class CDArkiv implements CDArkivADT {
	final static int STK = 100;
	private CD[] cdTabell;
	private int antall;

	public CDArkiv() {
		this(STK);
	}

	public CDArkiv(int maksAntall) {
		cdTabell = new CD[maksAntall];
		this.antall = 0;
	}

	@Override
	public CD[] hentCDTabell() {
		return cdTabell;
	}

	private void utvidKapasitet() {
		CD[] hjelpetabell = new CD[(int) Math.ceil(1.1 * cdTabell.length)];
		for (int i = 0; i < cdTabell.length; i++) {
			hjelpetabell[i] = cdTabell[i];
		}
		cdTabell = hjelpetabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		if (antall == cdTabell.length) {
			utvidKapasitet();
		}
		cdTabell[antall] = nyCd;
		antall++;

	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean tilstand = false;
		int posisjon = sokCdNr(cdNr);
		if (posisjon != -1) {
			cdTabell[posisjon] = cdTabell[antall - 1];
			cdTabell[antall - 1] = null;
			antall--;
			trimTab(cdTabell, antall); // må teste om dette funker, bare en
										// tanke...
			tilstand = true;
		}
		return tilstand;
	}

	private int sokCdNr(int cdNr) {
		int posisjon = -1;
		int i = 0;
		boolean funnet = false;

		while (!funnet && i < antall) {
			if (cdTabell[i].getCdNr() == cdNr) {
				posisjon = i;
				funnet = true;
			}
			i++;
		}
		return posisjon;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] resultatTittel = new CD[antall];
		int i = 0;

		while (i < antall) {
			if (cdTabell[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				resultatTittel[i] = cdTabell[i];
			}
			i++;
		}
		trimTab(resultatTittel, antall);
		return resultatTittel;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] resultatArtist = new CD[antall];
		int i = 0;

		while (i < antall) {
			if (cdTabell[i].getArtist().toLowerCase().contains(delstreng.toLowerCase())) {
				resultatArtist[i] = cdTabell[i];
			}
			i++;
		}
		trimTab(resultatArtist, antall);
		return resultatArtist;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallCDISjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger) {
				antallCDISjanger++;
			}
		}
		return antallCDISjanger;
	}

	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		}
		return cdtab2;
	}
}