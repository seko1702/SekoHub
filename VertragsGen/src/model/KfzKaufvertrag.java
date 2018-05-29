package model;

public class KfzKaufvertrag extends Vertrag {
	
	private int id; 
	private Fahrzeug fahrzeug;
	private boolean alleinigesEigentum;
	private boolean austauschmotor;
	private int austauschmotorLaufleistung;
	private boolean unfallschaden;
	private String[] listeUnfallschaeden;
	private String[] beschaedigungen;
	private boolean ummeldungUnverzueglich;
	private boolean fahrzeugAbgemeldet;
	private String[] sondervereinbarungen;
	private boolean fahrzeugschein;
	private boolean fahrzeugbrief;
	private boolean stillegungsBescheinigung;
	private boolean untersuchungsbericht;
	private int anzahlSchluessel;
	private int kaufpreis;
	private int anzahlung;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fahrzeug getFahrzeug() {
		return fahrzeug;
	}
	public void setFahrzeug(Fahrzeug fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	public boolean isAlleinigesEigentum() {
		return alleinigesEigentum;
	}
	public void setAlleinigesEigentum(boolean alleinigesEigentum) {
		this.alleinigesEigentum = alleinigesEigentum;
	}
	public boolean isAustauschmotor() {
		return austauschmotor;
	}
	public void setAustauschmotor(boolean austauschmotor) {
		this.austauschmotor = austauschmotor;
	}
	public int getAustauschmotorLaufleistung() {
		return austauschmotorLaufleistung;
	}
	public void setAustauschmotorLaufleistung(int austauschmotorLaufleistung) {
		this.austauschmotorLaufleistung = austauschmotorLaufleistung;
	}
	public boolean isUnfallschaden() {
		return unfallschaden;
	}
	public void setUnfallschaden(boolean unfallschaden) {
		this.unfallschaden = unfallschaden;
	}
	public String[] getListeUnfallschaeden() {
		return listeUnfallschaeden;
	}
	public void setListeUnfallschaeden(String[] listeUnfallschaeden) {
		this.listeUnfallschaeden = listeUnfallschaeden;
	}
	public String[] getBeschaedigungen() {
		return beschaedigungen;
	}
	public void setBeschaedigungen(String[] beschaedigungen) {
		this.beschaedigungen = beschaedigungen;
	}
	public boolean isUmmeldungUnverzueglich() {
		return ummeldungUnverzueglich;
	}
	public void setUmmeldungUnverzueglich(boolean ummeldungUnverzueglich) {
		this.ummeldungUnverzueglich = ummeldungUnverzueglich;
	}
	public boolean isFahrzeugAbgemeldet() {
		return fahrzeugAbgemeldet;
	}
	public void setFahrzeugAbgemeldet(boolean fahrzeugAbgemeldet) {
		this.fahrzeugAbgemeldet = fahrzeugAbgemeldet;
	}
	public String[] getSondervereinbarungen() {
		return sondervereinbarungen;
	}
	public void setSondervereinbarungen(String[] sondervereinbarungen) {
		this.sondervereinbarungen = sondervereinbarungen;
	}
	public boolean isFahrzeugschein() {
		return fahrzeugschein;
	}
	public void setFahrzeugschein(boolean fahrzeugschein) {
		this.fahrzeugschein = fahrzeugschein;
	}
	public boolean isFahrzeugbrief() {
		return fahrzeugbrief;
	}
	public void setFahrzeugbrief(boolean fahrzeugbrief) {
		this.fahrzeugbrief = fahrzeugbrief;
	}
	public boolean isStillegungsBescheinigung() {
		return stillegungsBescheinigung;
	}
	public void setStillegungsBescheinigung(boolean stillegungsBescheinigung) {
		this.stillegungsBescheinigung = stillegungsBescheinigung;
	}
	public boolean isUntersuchungsbericht() {
		return untersuchungsbericht;
	}
	public void setUntersuchungsbericht(boolean untersuchungsbericht) {
		this.untersuchungsbericht = untersuchungsbericht;
	}
	public int getAnzahlSchluessel() {
		return anzahlSchluessel;
	}
	public void setAnzahlSchluessel(int anzahlSchluessel) {
		this.anzahlSchluessel = anzahlSchluessel;
	}
	public int getKaufpreis() {
		return kaufpreis;
	}
	public void setKaufpreis(int kaufpreis) {
		this.kaufpreis = kaufpreis;
	}
	public int getAnzahlung() {
		return anzahlung;
	}
	public void setAnzahlung(int anzahlung) {
		this.anzahlung = anzahlung;
	}	

	
	
}
