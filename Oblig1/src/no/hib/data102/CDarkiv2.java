package no.hib.data102;

import no.hib.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT{
	
	private int antall;
	 private LinearNode<CD> start;
	 

	@Override
	public CD[] hentCDTabell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTilCD(CD nyCD) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean slettCD(int CDnr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hentAntall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

}
