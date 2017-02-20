package no.hib.dat102.adt;

import no.hib.dat102.CD;
import no.hib.dat102.Sjanger;

public interface CDArkivADT {

	/**
	 * Returnerer en tabell av CD-er
	 */
	CD[] hentCDTabell();
	
	/**
	 * Legger til en ny CD
	 */
	void leggTilCd(CD nyCd);

	/**Sletter en CD hvis den fins
	 * 
	 */
	boolean slettCd(int cdNr);

	/**
	 * Søker og henter CD-er med en gitt delstreng
	 */
	CD[] sokTittel(String delstreng);

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