package model;

import java.util.ArrayList;
import java.util.Date;

public class Fahrzeug {

	private String typ;
	private String marke;
	private String modell;
	private int fahrzeugIdNr;
	private int fahrzeugbriefNr;
	private int gesamtFahrLeistung;
	private int ps;
	private int hubraum;
	private Date naechsteHauptuntersuchung;
	private String coZweiEffizienz;
	private String amtlichesKennzeichen;
	private Date erstzulassung;
	private ArrayList<String> zusatzAusstattung;
	private int anzahlVorbesitzer;
	private boolean gewerbNutzung;
	
	
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getMarke() {
		return marke;
	}
	public void setMarke(String marke) {
		this.marke = marke;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public int getFahrzeugIdNr() {
		return fahrzeugIdNr;
	}
	public void setFahrzeugIdNr(int fahrzeugIdNr) {
		this.fahrzeugIdNr = fahrzeugIdNr;
	}
	public int getFahrzeugbriefNr() {
		return fahrzeugbriefNr;
	}
	public void setFahrzeugbriefNr(int fahrzeugbriefNr) {
		this.fahrzeugbriefNr = fahrzeugbriefNr;
	}
	public int getGesamtFahrLeistung() {
		return gesamtFahrLeistung;
	}
	public void setGesamtFahrLeistung(int gesamtFahrLeistung) {
		this.gesamtFahrLeistung = gesamtFahrLeistung;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getHubraum() {
		return hubraum;
	}
	public void setHubraum(int hubraum) {
		this.hubraum = hubraum;
	}
	public Date getNaechsteHauptuntersuchung() {
		return naechsteHauptuntersuchung;
	}
	public void setNaechsteHauptuntersuchung(Date naechsteHauptuntersuchung) {
		this.naechsteHauptuntersuchung = naechsteHauptuntersuchung;
	}
	public String getCoZweiEffizienz() {
		return coZweiEffizienz;
	}
	public void setCoZweiEffizienz(String coZweiEffizienz) {
		this.coZweiEffizienz = coZweiEffizienz;
	}
	public String getAmtlichesKennzeichen() {
		return amtlichesKennzeichen;
	}
	public void setAmtlichesKennzeichen(String amtlichesKennzeichen) {
		this.amtlichesKennzeichen = amtlichesKennzeichen;
	}
	public Date getErstzulassung() {
		return erstzulassung;
	}
	public void setErstzulassung(Date erstzulassung) {
		this.erstzulassung = erstzulassung;
	}
	public ArrayList<String> getZusatzAusstattung() {
		return zusatzAusstattung;
	}
	public void setZusatzAusstattung(ArrayList<String> zusatzAusstattung) {
		this.zusatzAusstattung = zusatzAusstattung;
	}
	public int getAnzahlVorbesitzer() {
		return anzahlVorbesitzer;
	}
	public void setAnzahlVorbesitzer(int anzahlVorbesitzer) {
		this.anzahlVorbesitzer = anzahlVorbesitzer;
	}
	public boolean isGewerbNutzung() {
		return gewerbNutzung;
	}
	public void setGewerbNutzung(boolean gewerbNutzung) {
		this.gewerbNutzung = gewerbNutzung;
	}

}
