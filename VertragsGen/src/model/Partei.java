package model;

public abstract class Partei {
	
	private int id;
	private String strasse;
	private int hausnummer;
	private String hausnummerZusatz;
	private int plz;
	private String ort;
	private int telnummer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	public String getHausnummerZusatz() {
		return hausnummerZusatz;
	}
	public void setHausnummerZusatz(String hausnummerZusatz) {
		this.hausnummerZusatz = hausnummerZusatz;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public int getTelnummer() {
		return telnummer;
	}
	public void setTelnummer(int telnummer) {
		this.telnummer = telnummer;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	private String eMail;
	
	
}
