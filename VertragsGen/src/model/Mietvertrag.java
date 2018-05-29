package model;

import java.util.Date;

public class Mietvertrag {
	
	private int id; 
	private Mietobjekt mietobjekt;
	private Date mietbeginn;
	private Date mietende;
	private float monatsMiete;
	private float keineMieterhoehungInJahren;
	private boolean preisgebunden;
	private boolean oeffentlichGefoerdert;
	private float hoechstMiete;
	private Date hoechstMieteBis;
	private float heizungWarmwasserKosten;
	private String[] betriebskostenArten;
	private boolean betriebskostenPauschalbeistrag;
	private boolean betriebskostenVorauszahlung;
	private float betriebskosten;
	private float mieteGesamtbetrag;
	private String kontoinhaber;
	private String iban;
	private float maxHeizkostenInZweiAbrechnungsperioden;
	private String[] arbeitenDieDerMieterVornehemnKann;
	private int pauschale;
	private String[] arbeitenVorEinzug;
	private boolean energieausweis;
	private boolean richtigkeitEnergieausweisVersichert;
	private Partei zustaendigGartenpflege;
	private Partei zustaendigGartengeraete;
	private int kaution;
	private float verteilungHeizUndWarmwasserkosten;
	private boolean betriebskostenAnteilWohnflaeche;
	private boolean betriebskostenEntwaesserungMuellabfuhrWasserversorgung;
	private Date abrechnungszeitraumHeizUndBetriebskosten;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Mietobjekt getMietobjekt() {
		return mietobjekt;
	}
	public void setMietobjekt(Mietobjekt mietobjekt) {
		this.mietobjekt = mietobjekt;
	}
	public Date getMietbeginn() {
		return mietbeginn;
	}
	public void setMietbeginn(Date mietbeginn) {
		this.mietbeginn = mietbeginn;
	}
	public Date getMietende() {
		return mietende;
	}
	public void setMietende(Date mietende) {
		this.mietende = mietende;
	}
	public float getMonatsMiete() {
		return monatsMiete;
	}
	public void setMonatsMiete(float monatsMiete) {
		this.monatsMiete = monatsMiete;
	}
	public float getKeineMieterhoehungInJahren() {
		return keineMieterhoehungInJahren;
	}
	public void setKeineMieterhoehungInJahren(float keineMieterhoehungInJahren) {
		this.keineMieterhoehungInJahren = keineMieterhoehungInJahren;
	}
	public boolean isPreisgebunden() {
		return preisgebunden;
	}
	public void setPreisgebunden(boolean preisgebunden) {
		this.preisgebunden = preisgebunden;
	}
	public boolean isOeffentlichGefoerdert() {
		return oeffentlichGefoerdert;
	}
	public void setOeffentlichGefoerdert(boolean oeffentlichGefoerdert) {
		this.oeffentlichGefoerdert = oeffentlichGefoerdert;
	}
	public float getHoechstMiete() {
		return hoechstMiete;
	}
	public void setHoechstMiete(float hoechstMiete) {
		this.hoechstMiete = hoechstMiete;
	}
	public Date getHoechstMieteBis() {
		return hoechstMieteBis;
	}
	public void setHoechstMieteBis(Date hoechstMieteBis) {
		this.hoechstMieteBis = hoechstMieteBis;
	}
	public float getHeizungWarmwasserKosten() {
		return heizungWarmwasserKosten;
	}
	public void setHeizungWarmwasserKosten(float heizungWarmwasserKosten) {
		this.heizungWarmwasserKosten = heizungWarmwasserKosten;
	}
	public String[] getBetriebskostenArten() {
		return betriebskostenArten;
	}
	public void setBetriebskostenArten(String[] betriebskostenArten) {
		this.betriebskostenArten = betriebskostenArten;
	}
	public boolean isBetriebskostenPauschalbeistrag() {
		return betriebskostenPauschalbeistrag;
	}
	public void setBetriebskostenPauschalbeistrag(boolean betriebskostenPauschalbeistrag) {
		this.betriebskostenPauschalbeistrag = betriebskostenPauschalbeistrag;
	}
	public boolean isBetriebskostenVorauszahlung() {
		return betriebskostenVorauszahlung;
	}
	public void setBetriebskostenVorauszahlung(boolean betriebskostenVorauszahlung) {
		this.betriebskostenVorauszahlung = betriebskostenVorauszahlung;
	}
	public float getBetriebskosten() {
		return betriebskosten;
	}
	public void setBetriebskosten(float betriebskosten) {
		this.betriebskosten = betriebskosten;
	}
	public float getMieteGesamtbetrag() {
		return mieteGesamtbetrag;
	}
	public void setMieteGesamtbetrag(float mieteGesamtbetrag) {
		this.mieteGesamtbetrag = mieteGesamtbetrag;
	}
	public String getKontoinhaber() {
		return kontoinhaber;
	}
	public void setKontoinhaber(String kontoinhaber) {
		this.kontoinhaber = kontoinhaber;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public float getMaxHeizkostenInZweiAbrechnungsperioden() {
		return maxHeizkostenInZweiAbrechnungsperioden;
	}
	public void setMaxHeizkostenInZweiAbrechnungsperioden(float maxHeizkostenInZweiAbrechnungsperioden) {
		this.maxHeizkostenInZweiAbrechnungsperioden = maxHeizkostenInZweiAbrechnungsperioden;
	}
	public String[] getArbeitenDieDerMieterVornehemnKann() {
		return arbeitenDieDerMieterVornehemnKann;
	}
	public void setArbeitenDieDerMieterVornehemnKann(String[] arbeitenDieDerMieterVornehemnKann) {
		this.arbeitenDieDerMieterVornehemnKann = arbeitenDieDerMieterVornehemnKann;
	}
	public int getPauschale() {
		return pauschale;
	}
	public void setPauschale(int pauschale) {
		this.pauschale = pauschale;
	}
	public String[] getArbeitenVorEinzug() {
		return arbeitenVorEinzug;
	}
	public void setArbeitenVorEinzug(String[] arbeitenVorEinzug) {
		this.arbeitenVorEinzug = arbeitenVorEinzug;
	}
	public boolean isEnergieausweis() {
		return energieausweis;
	}
	public void setEnergieausweis(boolean energieausweis) {
		this.energieausweis = energieausweis;
	}
	public boolean isRichtigkeitEnergieausweisVersichert() {
		return richtigkeitEnergieausweisVersichert;
	}
	public void setRichtigkeitEnergieausweisVersichert(boolean richtigkeitEnergieausweisVersichert) {
		this.richtigkeitEnergieausweisVersichert = richtigkeitEnergieausweisVersichert;
	}
	public Partei getZustaendigGartenpflege() {
		return zustaendigGartenpflege;
	}
	public void setZustaendigGartenpflege(Partei zustaendigGartenpflege) {
		this.zustaendigGartenpflege = zustaendigGartenpflege;
	}
	public Partei getZustaendigGartengeraete() {
		return zustaendigGartengeraete;
	}
	public void setZustaendigGartengeraete(Partei zustaendigGartengeraete) {
		this.zustaendigGartengeraete = zustaendigGartengeraete;
	}
	public int getKaution() {
		return kaution;
	}
	public void setKaution(int kaution) {
		this.kaution = kaution;
	}
	public float getVerteilungHeizUndWarmwasserkosten() {
		return verteilungHeizUndWarmwasserkosten;
	}
	public void setVerteilungHeizUndWarmwasserkosten(float verteilungHeizUndWarmwasserkosten) {
		this.verteilungHeizUndWarmwasserkosten = verteilungHeizUndWarmwasserkosten;
	}
	public boolean isBetriebskostenAnteilWohnflaeche() {
		return betriebskostenAnteilWohnflaeche;
	}
	public void setBetriebskostenAnteilWohnflaeche(boolean betriebskostenAnteilWohnflaeche) {
		this.betriebskostenAnteilWohnflaeche = betriebskostenAnteilWohnflaeche;
	}
	public boolean isBetriebskostenEntwaesserungMuellabfuhrWasserversorgung() {
		return betriebskostenEntwaesserungMuellabfuhrWasserversorgung;
	}
	public void setBetriebskostenEntwaesserungMuellabfuhrWasserversorgung(
			boolean betriebskostenEntwaesserungMuellabfuhrWasserversorgung) {
		this.betriebskostenEntwaesserungMuellabfuhrWasserversorgung = betriebskostenEntwaesserungMuellabfuhrWasserversorgung;
	}
	public Date getAbrechnungszeitraumHeizUndBetriebskosten() {
		return abrechnungszeitraumHeizUndBetriebskosten;
	}
	public void setAbrechnungszeitraumHeizUndBetriebskosten(Date abrechnungszeitraumHeizUndBetriebskosten) {
		this.abrechnungszeitraumHeizUndBetriebskosten = abrechnungszeitraumHeizUndBetriebskosten;
	}
	
	
	
}
