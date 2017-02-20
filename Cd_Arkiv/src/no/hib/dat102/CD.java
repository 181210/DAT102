package no.hib.dat102;

public class CD {
	private int cdNr;
	private String artist;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String plateselskap;

	public CD(int cdNr, String artist, String tittel, int lanseringsaar, Sjanger sjanger, String plateselskap) {
		this.cdNr = cdNr;
		this.artist = artist;
		this.tittel = tittel;
		this.lanseringsaar = lanseringsaar;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public CD() {
		this(0, "", "", 0, null, "");
	}

	public int getCdNr() {
		return cdNr;
	}

	public void setCdNr(int cdNr) {
		this.cdNr = cdNr;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsaar() {
		return lanseringsaar;
	}

	public void setLanseringsaar(int lanseringsaar) {
		this.lanseringsaar = lanseringsaar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	@Override
	public String toString() {
		return "CDnr=" + cdNr + ", artist=" + artist + ", tittel=" + tittel + ", lanseringsår=" + lanseringsaar
				+ ", sjanger=" + sjanger + ", plateselskap=" + plateselskap;
	}
}
