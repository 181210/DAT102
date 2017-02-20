package no.hib.Dat102;

import no.hib.Dat102.adt.KoeADT;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private static final int STD = 100;
	private int front;
	private int bak;
	private int antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STD);
	}

	@SuppressWarnings("unchecked")
	public SirkulaerKoe(int startKapasitet) {
		koe = (T[]) (new Object[startKapasitet]);
		front = 0;
		bak = 0;
		antall = 0;
	}

	private void utvid() {
		@SuppressWarnings("unchecked")
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int soek = 0; soek < antall; soek++) {
			hjelpetabell[soek] = koe[front];
			front = (front + 1) % koe.length;
		}
		front = 0;
		bak = antall;
		koe = hjelpetabell;
	}

	@Override
	public T utKoe() throws EmptyCollectionException {
		T resultat = null;
		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}
		resultat = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		antall--;

		return resultat;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		T resultat = null;
		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}
		resultat = koe[front];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void innKoe(Object element) {
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = (T) element;
		bak = (bak + 1) % koe.length;
		antall++;

	}

}
