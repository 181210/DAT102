package no.hib.data102.adt;

import no.hib.data102.CD;
import no.hib.data102.Sjanger;

public interface CDarkivADT {
	
	/**
	 * Returnerer en tabell av CD-er
	 */
	CD[] hentCDTabell();
	
	
	/**
	 * Legger til en ny CD
	 */
	void leggTilCD(CD nyCD);
	
	/**Sletter en CD hvis den fins
	 * 
	 */
	boolean slettCD(int CDnr);
	
	/**
	 * Søker og henter CD-er med en gitt delstreng
	 */
	CD[] sokTittel (String delstreng);
	
	/**
	 * Søker og henter artister emd en gitt delstreng
	 */
	CD[] sokArtist(String delstreng);
	
	/**
	 * Henter antall CD-er i arkivet
	 */
	int hentAntall();
	
	/**
	 * Henter antall CE-er for en gitt sjanger
	 */
	int hentAntall(Sjanger sjanger);
	

}
