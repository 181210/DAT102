package no.hib.Dat102;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.Dat102.adt.KoeADT;

public class TestSirKoe {

	protected static final int SIZE = 100;

	private KoeADT<Character> koe;

	private Character c0 = 'A';
	private Character c1 = 'B';
	private Character c2 = 'C';
	private Character c3 = 'D';

	@Before
	public final void setup() {
		koe = new SirkulaerKoe<Character>(SIZE);
	}

	@Test
	public final void NyKoeErTom() {
		assertTrue(koe.erTom());
	}

	@Test
	public final void InnOgUtKoe() {
		koe.innKoe(c0);
		koe.innKoe(c1);
		koe.innKoe(c2);
		koe.innKoe(c3);
		try {
			assertEquals(c0, koe.utKoe());
			assertEquals(c1, koe.utKoe());
			assertEquals(c2, koe.utKoe());
			assertEquals(c3, koe.utKoe());

		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	@Test
	public final void InnOgUtKoeDuplikat() {
		koe.innKoe(c1);
		koe.innKoe(c1);
		koe.innKoe(c1);
		koe.innKoe(c3);
		try {
			assertEquals(c1, koe.utKoe());
			assertEquals(c1, koe.utKoe());
			assertEquals(c1, koe.utKoe());
			assertEquals(c3, koe.utKoe());

		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	@Test
	public final void InnUtInnInnUtForste() {
		try {
			koe.innKoe(c0);
			koe.utKoe();
			koe.innKoe(c0);
			koe.innKoe(c2);
			koe.utKoe();
			assertEquals(c2, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("Forste feilet uventet " + e.getMessage());
		}
	}

	@Test
	public final void erIkkeTom() {
		koe.innKoe(c0);
		koe.innKoe(c1);
		assertFalse(koe.erTom());
	}

	@Test
	public final void InnUtErTom() {
		try {
			koe.innKoe(c3);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("InnUtErTom feilet uventet " + e.getMessage());
		}
	}

	@Test
	public final void storrelse() {
		koe.innKoe(c0);
		koe.innKoe(c1);
		koe.innKoe(c2);
		assertEquals(3, koe.antall());
	}

	@Test(expected = EmptyCollectionException.class)
	public final void UtKoeFraTomKoeUnderflowed() throws EmptyCollectionException {
		koe.utKoe();
	}

	@Test
	public final void utvidUtvider() {
		for (int i = 0; i < 110; i++) {
			koe.innKoe(c0);
		}
		assertEquals(110, koe.antall());
	}
}