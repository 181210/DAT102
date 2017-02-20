package no.hib.Dat102;

import no.hib.Dat102.adt.KoeADT;

public class SKoeKlient {
	
	public static void main(String[] args) {
		
		KoeADT<Character> tegn = new SirkulaerKoe<Character>();
		
		String streng = "Dette er en test";
		int lengde = streng.length();
		System.out.println(streng);

		for (int i = 0; i < lengde; i++) {
			tegn.innKoe(new Character(streng.charAt(i)));
		}
		while (!tegn.erTom()) {
			Character tegn_obj = (Character) tegn.utKoe();
			System.out.print(tegn_obj);
		}
		System.out.println();
	}
}