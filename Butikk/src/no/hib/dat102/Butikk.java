package no.hib.dat102;

/**
 * 
 * @author kanen
 *
 */

public class Butikk {

	private String butikkNavn;
	private Vare[] vareTab;
	private int[] vareLager;
	private int antallVarer;

	public String getButikkNavn() {
		return butikkNavn;
	}

	public void setButikkNavn(String butikkNavn) {
		this.butikkNavn = butikkNavn;
	}

	public Vare[] getVareTab() {
		return vareTab;
	}

	public void setVareTab(Vare[] vareTab) {
		this.vareTab = vareTab;
	}

	public int[] getVareLager() {
		return vareLager;
	}

	public void setVareLager(int[] vareLager) {
		this.vareLager = vareLager;
	}

	public int getAntallVarer() {
		return antallVarer;
	}

	public void setAntallVarer(int antallVarer) {
		this.antallVarer = antallVarer;
	}

	public Butikk(String butikkNavn, int storrelse) {
		this.butikkNavn = butikkNavn;
		vareTab = new Vare[storrelse];
		vareLager = new int[storrelse];
		setAntallVarer(0);

	}

	/**
	 * Søker gjennom varetabellen etter vare
	 * 
	 * @param vareNr
	 * @return
	 */
	public int finnVare(int vareNr) {
		int vNummer = -1;

		for (int i = 0; i < vareTab.length; i++) {
			if (vareTab[i].getVareNr() == vareNr) {
				vNummer = i;
			}
		}

		return vNummer;
	}

	/**
	 * Sjekker om det er ledig plass i varetabellen
	 * 
	 * @return
	 */
	public boolean erLedigPlass() {
		boolean erLedig = false;

		for (int i = 0; i < vareTab.length; i++) {
			if (vareTab[i] == null) {
				erLedig = true;
			}
		}

		return erLedig;
	}

	/**
	 * Legger til vare dersom varen ikke eksisterer fra før og det er plass på
	 * lager.
	 * 
	 * @param vareNr
	 */
	public void leggInnNyVare(int vareNr) {

		if (finnVare(vareNr) == -1) {
			Vare vare = new Vare();
			vare.lesVare(vareNr);
			vareTab[getAntallVarer()] = vare;
			vareLager[getAntallVarer()] = 1;

		} else if (!erLedigPlass()) {
			System.out.println("Varelageret er fullt!");

		} else if (finnVare(vareNr) != -1) {
			System.out.println("Varen eksisterer allerede!");
		}

	}

	/**
	 * Sletter varen dersom den finnes på lageret
	 * 
	 * @param vareNr
	 */
	public void slettVare(int vareNr) {

		int plass = finnVare(vareNr);

		if (plass == -1) {
			System.out.println("Varen finnes ikke på lager!");
		} else if (plass != -1) {
			vareLager[vareNr] = 0;
			vareTab[vareNr] = null;
		}

		Vare[] hjelpeTab = new Vare[vareTab.length - 1];
		int[] hTab = new int[vareTab.length - 1];

		for (int i = 0; i < vareTab.length; i++) {
			if (vareTab[i] != null) {
				hjelpeTab[i] = vareTab[i];
			}

			setVareTab(hjelpeTab);
		}

		for (int j = 0; j < vareLager.length; j++) {
			if (vareTab[j].getVareNr() != vareNr) {
				hTab[j] = vareLager[j];
			}
		}

		setVareLager(hTab);

	}

	/**
	 * Minker antallet av varen med 1 dersom den finnes på lager
	 * 
	 * @param vareNr
	 */
	public void detaljSalg(int vareNr) {

		int plass = finnVare(vareNr);
		if (plass == -1) {
			System.out.println("Varen eksisterer ikke");
		} else if (finnVare(vareNr) != -1) {
			int lager = vareLager[vareNr];
			if (lager <= 0) {
				System.out.println("Det er tomt for varen på lager!");
			} else {
				vareLager[vareNr] = lager - 1;
			}
		}
	}

	/**
	 * Øker antallet av varen på lager dersom den finnes
	 * 
	 * @param vareNr
	 * @param tall
	 */
	public void grossInnkjop(int vareNr, int tall) {

		if (finnVare(vareNr) == -1) {
			System.out.println("Varen finnes ikke på lager!");
		} else if (finnVare(vareNr) != -1) {
			int antall = vareLager[vareNr];
			vareLager[vareNr] = antall + tall;
		}

	}

	/**
	 * Regner ut verdien av varelager
	 * 
	 * @return verdi av varelager
	 */
	public double salgsVerdi() {
		double verdi = 0.0;

		for (int i = 0; i < vareTab.length; i++) {
			verdi += vareTab[i].getVarePris();
		}

		return verdi;
	}

}
