package no.hib.dat102.mengde.tabell;

import no.hib.dat102.mengde.adt.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private final static int NOT_FOUND = -1;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	@SuppressWarnings("unchecked")
	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		@SuppressWarnings("unchecked")
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) throws EmptyCollectionException, NoSuchElementException {
		int soek = NOT_FOUND;
		if (erTom()) {
			throw new EmptyCollectionException("Mengde");
		}
		for (int indeks = 0; indeks < antall && soek == NOT_FOUND; indeks++) {
			if (tab[indeks].equals(element)) {
				soek = indeks;
			}
		}
		if (soek == NOT_FOUND) {
			throw new NoSuchElementException();
		}
		T resultat = tab[soek];

		tab[soek] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return resultat;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		TabellMengde<T> differensM = new TabellMengde<T>();
		T element;
		Iterator<T> teller = this.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				differensM.settInn(element);
			}
		}
		return differensM;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		TabellMengde<T> snittM = new TabellMengde<T>();
		T element;
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (this.inneholder(element))
				snittM.settInn(element);
		}
		return snittM;
	}

	@Override
	public boolean inneholder(T element) {
		int pos = -1;
		for (int i = 0; (i < antall) && (pos == -1); i++) {
			if (tab[i].equals(element))
				pos = i;
		}
		return (pos != -1);
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		boolean likeMengder = false;
		T element;
		TabellMengde<T> temp1 = new TabellMengde<T>();
		TabellMengde<T> temp2 = new TabellMengde<T>();

		if (antall() == m2.antall()) {
			temp1.leggTilAlle(this);
			temp2.leggTilAlle(m2);

			Iterator<T> soek = m2.oppramser();

			while (soek.hasNext()) {
				element = soek.next();
				if (temp1.inneholder(element)) {
					temp1.fjern(element);
					temp2.fjern(element);
				}
			}
			likeMengder = (temp1.erTom() && temp2.erTom());
		}
		return likeMengder;
	}

	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

}// class
