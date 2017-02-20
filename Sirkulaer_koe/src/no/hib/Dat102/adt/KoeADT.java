package no.hib.Dat102.adt;

public interface KoeADT<T> {

	/**
	 * Legge til et element bak i køen.
	 * @param 
	 */
	public void innKoe(T element);

	/**
	 * Fjerner og returnerer elementet foran i køen.
	 * 
	 * @return 
	 */
	public T utKoe();

	/**
	 * Returnerer elementet foran i køen uten å fjerne det fra køen.
	 * @return
	 */
	public T foerste();
	
	/**
	 * Returnerer sann hvis denne køen ikke innholder noen elementer.. 
	 * @return
	 */
	public boolean erTom();
	
	/**
	 * Returnerer antall elementer i køen.
	 * @return 
	 */
	public int antall();
}

	
	

