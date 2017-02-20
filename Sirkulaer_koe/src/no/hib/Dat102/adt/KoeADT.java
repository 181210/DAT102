package no.hib.Dat102.adt;

public interface KoeADT<T> {

	/**
	 * Legge til et element bak i k�en.
	 * @param 
	 */
	public void innKoe(T element);

	/**
	 * Fjerner og returnerer elementet foran i k�en.
	 * 
	 * @return 
	 */
	public T utKoe();

	/**
	 * Returnerer elementet foran i k�en uten � fjerne det fra k�en.
	 * @return
	 */
	public T foerste();
	
	/**
	 * Returnerer sann hvis denne k�en ikke innholder noen elementer.. 
	 * @return
	 */
	public boolean erTom();
	
	/**
	 * Returnerer antall elementer i k�en.
	 * @return 
	 */
	public int antall();
}

	
	

