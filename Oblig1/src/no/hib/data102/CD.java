package no.hib.data102;

public class CD {

	private int CDnr;
	private String artist;
	private String tittel;
	private int aar;
	private Sjanger sjanger;
	private String plateselskap;
	public int getCDnr() {
		return CDnr;
	}
	public void setCDnr(int cDnr) {
		CDnr = cDnr;
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
	public int getAar() {
		return aar;
	}
	public void setAar(int aar) {
		this.aar = aar;
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
	
	public CD(){
		CDnr = 0;
		artist = "";
		tittel = "";
		aar = 0;
		sjanger = null;
		plateselskap = "";
	}
	
	
	
	public CD(int CDnr, String artist, String tittel, int aar, Sjanger sjanger, String plateselskap) {
		this.CDnr = CDnr;
		this.artist = artist;
		this.tittel = tittel;
		this.aar = aar;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}
	
	
	
}
