package no.hib.dat102;

public class Butikker {

	private String navn;
	private Vare[] varer;
	private int[] lagerVarer;

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	private int maxAntallVarer;

	public int getMaxAntallVarer() {
		return maxAntallVarer;
	}

	public void setMaxAntallVarer(int maxAntallVarer) {
		this.maxAntallVarer = maxAntallVarer;
	}

	private int forsteLedig;

	public Butikker(String navn, int maxAntallVarer) {

		this.navn = navn;
		this.maxAntallVarer = maxAntallVarer;

		varer = new Vare[maxAntallVarer];
		lagerVarer = new int[maxAntallVarer];

		forsteLedig = 0;

	}

	public int finnVare(int vareNr) {

		int index = -1;

		for (int i = 0; i < varer.length; i++) {

			if (varer[i].equals(vareNr)) {
				index = i;

			}
		}

		return index;

	}

	public boolean erLedigPlass() {

		boolean erLedig = false;

		for (int i = 0; i < varer.length; i++) {

			if (varer.equals(null)) {
				erLedig = true;

				forsteLedig = i;
			}

		}

		return erLedig;
	}

	public void leggInnNyVare(int vareNr) {

		if (finnVare(vareNr) != -1) {
			System.out.println("Varen eksisterer allerede!");
		} else if (erLedigPlass() == false) {
			System.out.println("Lageret er fullt!");
		} else if (finnVare(vareNr) == -1) {

			Vare nyVare = new Vare(vareNr);

			for (int i = 0; i < varer.length; i++) {

				varer[forsteLedig] = nyVare;

			}

		}

	}

	public void slettVare(int vareNr) {

		int index = 0;

		if (finnVare(vareNr) != -1) {
			for (int i = 0; i < varer.length; i++) {
				if (varer[i].equals(vareNr)) {
					index = i;
				}

				varer[forsteLedig - 1] = varer[index];
				lagerVarer[forsteLedig - 1] = lagerVarer[index];

				varer[forsteLedig - 1] = null;
				lagerVarer[forsteLedig - 1] = 0;

			}

		} else {

			System.out.println("Varen eksisterer ikke!");
		}

	}

	public void detaljSalg(int vareNr) {

		if (finnVare(vareNr) != -1) {

			System.out.println("Varen eksisterer ikke!");

		} 
		
		for(int i = 0; i < lagerVarer.length; i++){
			
			
			
			
			
		}

	}

}
