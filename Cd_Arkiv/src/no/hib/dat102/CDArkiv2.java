package no.hib.dat102;

import no.hib.dat102.adt.CDArkivADT;


public class CDArkiv2 implements CDArkivADT {
	private int antall;
	private LinearNode<CD> start;

	
	public CDArkiv2() {
		antall = 0;
		start = null;
	}

	@Override
	public CD[] hentCDTabell() {
		LinearNode<CD> node = start;
		CD[] cdtabell = new CD[antall];
		int i = 0;
		while (i < antall && node != null) {
			cdtabell[i] = node.getElement();
			node = node.getNeste();
			i++;
		}
		return cdtabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> node = new LinearNode<CD>(nyCd);

		node.setNeste(start);
		start = node;
		antall++;
	}

	private LinearNode<CD> finnCd(int cdNr) {
		LinearNode<CD> node = start;
		LinearNode<CD> node1 = start;
		while (node != null) {
			if (node.getElement().getCdNr() == cdNr) {
				return node1;
			}
			node1 = node;
			node = node.getNeste();
			
		}
		return null;
	}

	@Override
	public boolean slettCd(int cdNr) throws EmptyCollectionException {
		boolean erSlettet = false;
		if (erTom()) {
			throw new EmptyCollectionException("CDArkiv");
		}
		
		LinearNode<CD> resultat = finnCd(cdNr);

		if (resultat != null) {
			resultat.setNeste(resultat.getNeste());
			resultat = start;
			antall--;
			erSlettet = true;
		}
		
		return erSlettet;
	}

	private CD[] finnCder(String type, String soek) throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("CDArkiv");
		}
		CD[] cdTab = new CD[antall];
		LinearNode<CD> node = start;
		int i = 0;

		if (type.equals("Tittel")) {
			while (i < antall && node != null) {
				if (node.getElement().getTittel().contains(soek)) {
					cdTab[i] = node.getElement();
					node = node.getNeste();
					i++;
				}
			}
		} else if (type.equals("Artist")) {
			while (i < antall && node != null) {
				if (node.getElement().getArtist().contains(soek)) {
					cdTab[i] = node.getElement();
					node = node.getNeste();
					i++;
				}
			}
		}
		return cdTab;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		return finnCder("Tittel", delstreng);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		return finnCder("Artist", delstreng);
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallSjanger = 0;
		LinearNode<CD> node = start;
		LinearNode<CD> node1 = start;
		int teller = 1;
		while (teller <= antall) {
			if (node1.getElement().getSjanger() == sjanger) {
				antallSjanger++;
			}
			node1 = node;
			node = node.getNeste();
			teller++;
		}
		return antallSjanger;
	}

	private boolean erTom() {
		return (start == null);
	}

}