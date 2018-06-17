package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Fahrzeug;
import model.JuristischePartei;
import model.NatuerlichePartei;
import model.Partei;
import model.Vertrag;
import model.KfzKaufvertrag;
import model.Mietobjekt;
import model.Mietvertrag;

public class Database {

	private static Connection conn;

	// Speichert eine Natuerliche Partei in die Datenbank
	public static void writePartei(NatuerlichePartei np) {

		String strasse = np.getStrasse();
		int hausnummer = np.getHausnummer();
		String hausnummerZusatz = np.getHausnummerZusatz();
		int plz = np.getPlz();
		String ort = np.getOrt();
		int telnummer = np.getTelnummer();
		String name = np.getName();
		String vorname = np.getVorname();
		String personalausweisNr = np.getPersonalausweisNr();
		String ausstellungsbehoerde = np.getAusstellungsbehoerde();
		String ausstellungsdatum = dateToString(np.getAusstellungsdatum());
		String geburtsdatum = dateToString(np.getGeburtsdatum());

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "insert into Partei values (null, 'NatÃ¼rlichePartei', '" + strasse + "'," + hausnummer
					+ ", '" + hausnummerZusatz + "'," + plz + ", '" + ort + "', " + telnummer + ", null , null , '"
					+ name + "', '" + vorname + "', '" + personalausweisNr + "', '" + ausstellungsbehoerde + "', '"
					+ ausstellungsdatum + "', '" + geburtsdatum + "');";
			sta.executeUpdate(query);
			System.out.println("Partei upload succeeded!");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Speichert eine Juristische Partei in die Datenbank
		public static void writePartei(JuristischePartei jp) {

			String strasse = jp.getStrasse();
			int hausnummer = jp.getHausnummer();
			String hausnummerZusatz = jp.getHausnummerZusatz();
			int plz = jp.getPlz();
			String ort = jp.getOrt();
			int telnummer = jp.getTelnummer();
			String firmenname = jp.getFirmenname();
			String handelsregister = jp.getHandelsregister();

			try {
				conn = DatabaseCon.connect();
				Statement sta = conn.createStatement();

				String query = "insert into Partei values (null, 'JuristischePartei', '" + strasse + "'," + hausnummer
						+ ", '" + hausnummerZusatz + "'," + plz + ", '" + ort + "', " + telnummer + ", '" + firmenname
						+ "', '" + handelsregister + "',null,null,null,null,null,null)";
				sta.executeUpdate(query);
				System.out.println("Partei upload succeeded!");
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	// Liest eine Partei aus der Datenbank
	public static Partei readPartei(String vorname, String name) {

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "select * from Partei where vorname ='"+ vorname +"' and name = '"+ name +"';";
			ResultSet rs = sta.executeQuery(query);
			
			NatuerlichePartei np = new NatuerlichePartei();

			np.setId(rs.getInt("Partei_ID"));
			np.setStrasse(rs.getString("strasse"));
			np.setHausnummer(rs.getInt("hausnummer"));
			np.setHausnummerZusatz(rs.getString("hausnummerZusatz"));
			np.setPlz(rs.getInt("plz"));
			np.setOrt(rs.getString("ort"));
			np.setTelnummer(rs.getInt("telefonnummer"));
			np.setName(rs.getString("name"));
			np.setVorname(rs.getString("vorname"));
			np.setPersonalausweisNr(rs.getString("personalausweisNr"));
			np.setAusstellungsbehoerde(rs.getString("austellungsbehoerde"));
			np.setAusstellungsdatum(stringToDate(rs.getString("austellungsdatum")));
			np.setGeburtsdatum(stringToDate(rs.getString("geburtsdatum")));

			System.out.println("Partei download succeeded!");
			conn.close();

			return np;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static Partei readPartei(String firmenname) {
		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "select * from Partei where firmenname ='"+ firmenname +"';";
			ResultSet rs = sta.executeQuery(query);
		
			JuristischePartei jp = new JuristischePartei();
	
			jp.setId(rs.getInt("Partei_ID"));
			jp.setStrasse(rs.getString("strasse"));
			jp.setHausnummer(rs.getInt("hausnummer"));
			jp.setHausnummerZusatz(rs.getString("hausnummerZusatz"));
			jp.setPlz(rs.getInt("plz"));
			jp.setOrt(rs.getString("ort"));
			jp.setTelnummer(rs.getInt("telefonnummer"));
			jp.setFirmenname(rs.getString("firmenname"));
			jp.setHandelsregister(rs.getString("handelsregister"));
	
			System.out.println("Partei download succeeded!");
			conn.close();
			return jp;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
	
	public static Partei readPartei(int id) {		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "select * from Partei where Partei_ID ="+ id +";";
			ResultSet rs = sta.executeQuery(query);
		
			if(rs.getString("ParteiArt").equals("NatürlichePartei")) {
				NatuerlichePartei np = new NatuerlichePartei();

				np.setId(rs.getInt("Partei_ID"));
				np.setStrasse(rs.getString("strasse"));
				np.setHausnummer(rs.getInt("hausnummer"));
				np.setHausnummerZusatz(rs.getString("hausnummerZusatz"));
				np.setPlz(rs.getInt("plz"));
				np.setOrt(rs.getString("ort"));
				np.setTelnummer(rs.getInt("telefonnummer"));
				np.setName(rs.getString("name"));
				np.setVorname(rs.getString("vorname"));
				np.setPersonalausweisNr(rs.getString("personalausweisNr"));
				np.setAusstellungsbehoerde(rs.getString("austellungsbehoerde"));
				np.setAusstellungsdatum(stringToDate(rs.getString("austellungsdatum")));
				np.setGeburtsdatum(stringToDate(rs.getString("geburtsdatum")));

				System.out.println("Partei download succeeded!");
				conn.close();

				return np;
			}
			else if(rs.getString("ParteiArt").equals("JuristischePartei")) {
				JuristischePartei jp = new JuristischePartei();
		
				jp.setId(rs.getInt("Partei_ID"));
				jp.setStrasse(rs.getString("strasse"));
				jp.setHausnummer(rs.getInt("hausnummer"));
				jp.setHausnummerZusatz(rs.getString("hausnummerZusatz"));
				jp.setPlz(rs.getInt("plz"));
				jp.setOrt(rs.getString("ort"));
				jp.setTelnummer(rs.getInt("telefonnummer"));
				jp.setFirmenname(rs.getString("firmenname"));
				jp.setHandelsregister(rs.getString("handelsregister"));
		
				System.out.println("Partei download succeeded!");
				conn.close();
				return jp;
			}
			else {
				System.out.println("invalid ParteiArt");	
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}

	public static void wirteKfzKaufvertrag(KfzKaufvertrag vertrag, Fahrzeug fahrzeug) {
		
		writeFahrzeug(fahrzeug);

		writeKfzAttributes(vertrag);

		writeArrayList("Unfallschaeden", vertrag.getListeUnfallschaeden(), "KfzKaufvertrag");
		writeArrayList("Sondervereinbarungen", vertrag.getSondervereinbarungen(), "KfzKaufvertrag");
		writeArrayList("Beschaedigungen", vertrag.getBeschaedigungen(), "KfzKaufvertrag");

		System.out.println("complete");
	}

	public static void writeKfzAttributes(KfzKaufvertrag vertrag) {

        try {
            Connection conn = DatabaseCon.connect();
            Statement sta = conn.createStatement();

            ResultSet fID= sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = 'Fahrzeug'");
            int fahrzeugID = fID.getInt(1);
            
            int partei1ID= vertrag.getPartei1().getId();
            int partei2ID= vertrag.getPartei2().getId();

            String sql1 = "insert into KfzKaufvertrag values (null, "+fahrzeugID+", "+partei1ID+", "+partei2ID+", '"+ vertrag.getBezeichnung() +"',"
                    + booleanToInt(vertrag.isAlleinigesEigentum()) + "," + booleanToInt(vertrag.isAustauschmotor()) + ","
                    + vertrag.getAustauschmotorLaufleistung() + "," + booleanToInt(vertrag.isUnfallschaden()) + ","
                    + booleanToInt(vertrag.isUmmeldungUnverzueglich()) + ","
                    + booleanToInt(vertrag.isFahrzeugAbgemeldet()) + "," + booleanToInt(vertrag.isFahrzeugschein()) + ","
                    + booleanToInt(vertrag.isFahrzeugbrief()) + "," + booleanToInt(vertrag.isStillegungsBescheinigung())
                    + "," + booleanToInt(vertrag.isUntersuchungsbericht()) + "," + vertrag.getAnzahlSchluessel() + ","
                    + vertrag.getKaufpreis() + "," + vertrag.getAnzahlung() + ")";

            sta.executeUpdate(sql1);

            System.out.println("Fahrzeug Attribute upload succeeded!");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
	
	public static KfzKaufvertrag readKfzKaufvertrag(String bezeichnung) {

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			String query = "select * from KfzKaufvertrag where bezeichnung='" + bezeichnung +"';";
			ResultSet rsVertrag = sta.executeQuery(query);

			KfzKaufvertrag vertrag = new KfzKaufvertrag();
			int id = rsVertrag.getInt("KfzKaufvertrag_ID");
			
			vertrag.setId(id);
			vertrag.setBezeichnung(bezeichnung);
			vertrag.setPartei1(readPartei(rsVertrag.getInt("ParteiEins_ID")));
			vertrag.setPartei2(readPartei(rsVertrag.getInt("ParteiZwei_ID")));
			vertrag.setFahrzeug(readFahrzeug(id));
			vertrag.setAlleinigesEigentum(intToBoolean(rsVertrag.getInt("alleinigesEigentum")));
			vertrag.setAustauschmotor(intToBoolean(rsVertrag.getInt("austauschmotor")));
			vertrag.setAustauschmotorLaufleistung(rsVertrag.getInt("austauschmotorLaufleistung"));
			vertrag.setUnfallschaden(intToBoolean(rsVertrag.getInt("unfallschaden")));
			vertrag.setUmmeldungUnverzueglich(intToBoolean(rsVertrag.getInt("ummeldungUnverzueglich")));
			vertrag.setFahrzeugAbgemeldet(intToBoolean(rsVertrag.getInt("fahrzeugAbgemeldet")));
			vertrag.setFahrzeugschein(intToBoolean(rsVertrag.getInt("fahrzeugschein")));
			vertrag.setFahrzeugbrief(intToBoolean(rsVertrag.getInt("fahrzeugbrief")));
			vertrag.setStillegungsBescheinigung(intToBoolean(rsVertrag.getInt("stillegungsBescheinigung")));
			vertrag.setUntersuchungsbericht(intToBoolean(rsVertrag.getInt("untersuchungsbericht")));
			vertrag.setAnzahlSchluessel(rsVertrag.getInt("anzahlSchluessel"));
			vertrag.setKaufpreis(rsVertrag.getInt("kaufpreis"));
			vertrag.setAnzahlung(rsVertrag.getInt("anzahlung"));
			System.out.println("Fahrzeug Attribute download succeeded!");
			
			vertrag.setListeUnfallschaeden(readArrayList("unfallschaeden", "KfzKaufvertrag_ID", id));
			vertrag.setBeschaedigungen(readArrayList("beschaedigungen", "KfzKaufvertrag_ID", id));
			vertrag.setSondervereinbarungen(readArrayList("sondervereinbarungen", "KfzKaufvertrag_ID", id));
			
			conn.close();
			return vertrag;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}


	public static void writeFahrzeug(Fahrzeug fz) {
		String typ = fz.getTyp();
		String marke = fz.getMarke();
		String modell = fz.getModell();
		int fahrzeugIdNr = fz.getFahrzeugIdNr();
		int fahrzeugbriefNr = fz.getFahrzeugbriefNr();
		int gesamtfahrleistung = fz.getGesamtFahrLeistung();
		int ps = fz.getPs();
		int hubraum = fz.getHubraum();
		String naechstHauptuntersuchung = dateToString(fz.getNaechsteHauptuntersuchung());
		String co2Effizienz = fz.getCoZweiEffizienz();
		String amtlichesKennzeichen = fz.getAmtlichesKennzeichen();
		String erstzulassung = dateToString(fz.getErstzulassung());
		ArrayList<String> zusatzAusstattung = fz.getZusatzAusstattung();
		int vorbesitzer = fz.getAnzahlVorbesitzer();
		int gewerblicheNutzung = booleanToInt(fz.isGewerbNutzung());

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query1 = "insert into Fahrzeug values (null, '" + typ + "', '" + marke + "', '" + modell + "', "
					+ fahrzeugIdNr + ", " + fahrzeugbriefNr + ", " + gesamtfahrleistung + ", " + ps + ", " + hubraum
					+ ", '" + naechstHauptuntersuchung + "', '" + co2Effizienz + "', '" + amtlichesKennzeichen + "', '"
					+ erstzulassung + "', " + vorbesitzer + ", " + gewerblicheNutzung + ")";
			sta.executeUpdate(query1);

			writeArrayList("ZusatzAusstattung", zusatzAusstattung, "Fahrzeug");
			
			System.out.println("Fahrzeug upload succeeded!");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Fahrzeug readFahrzeug(int id) {
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			String query = "select * from Fahrzeug where Fahrzeug_ID ="+ id +";";
			ResultSet rs = sta.executeQuery(query);
			
			Fahrzeug fz = new Fahrzeug();
			fz.setTyp(rs.getString("typ"));
			fz.setMarke(rs.getString("marke"));
			fz.setModell(rs.getString("modell"));
			fz.setFahrzeugIdNr(rs.getInt("fahrzeugIdNr"));
			fz.setFahrzeugbriefNr(rs.getInt("fahrzeugbriefNr"));
			fz.setGesamtFahrLeistung(rs.getInt("gesamtFahrLeistung"));
			fz.setPs(rs.getInt("ps"));
			fz.setHubraum(rs.getInt("hubraum"));
			fz.setNaechsteHauptuntersuchung(stringToDate(rs.getString("naechsteHauptuntersuchung")));
			fz.setCoZweiEffizienz(rs.getString("coZweiEffizienz"));
			fz.setAmtlichesKennzeichen(rs.getString("amtlichesKennzeichen"));
			fz.setErstzulassung(stringToDate(rs.getString("erstzulassung")));
			fz.setZusatzAusstattung(readArrayList("ZusatzAusstattung", "Fahrzeug_ID", id));
			fz.setAnzahlVorbesitzer(rs.getInt("anzahlVorbesitzer"));
			fz.setGewerbNutzung(intToBoolean(rs.getInt("gewerbNutzung")));
			
			System.out.println("Fahrzeug download succeeded!");
			return fz;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
		
	}
	
	public static void writeMietvertrag(Mietvertrag mv, Mietobjekt mo) {
		writeMietobjekt(mo);
		
		writeMietvertragAttributes(mv);
		
		writeArrayList("Betriebskostenarten", mv.getBetriebskostenArten(), "Mietvertrag");
		writeArrayList("ArbeitenDieDerMieterVornehemenKann", mv.getArbeitenDieDerMieterVornehemnKann(), "Mietvertrag");
		writeArrayList("ArbeitenVorEinzug", mv.getArbeitenVorEinzug(), "Mietvertrag");		
		
		System.out.println("Completed");
	}
	
	public static void writeMietvertragAttributes(Mietvertrag mv) {
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			
			ResultSet rs= sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = 'Mietobjekt'");
			int MietobjektID = rs.getInt(1);
	            
	        int partei1ID= mv.getPartei1().getId();
	        int partei2ID= mv.getPartei2().getId();

			String sql = "insert into Mietvertrag values(null,"+  MietobjektID +","+ partei1ID +","+ partei2ID +",'"+mv.getBezeichnung() +"', '" + dateToString(mv.getMietbeginn()) + "','"
					+ dateToString(mv.getMietende()) + "'," + mv.getMonatsMiete() + "," + mv.getKeineMieterhoehungInJahren()
					+ "," + booleanToInt(mv.isPreisgebunden()) + "," + booleanToInt(mv.isOeffentlichGefoerdert())
					+ "," + mv.getHoechstMiete() + ",'" + dateToString(mv.getHoechstMieteBis()) + "',"
					+ mv.getHeizungWarmwasserKosten() + "," + booleanToInt(mv.isBetriebskostenPauschalbeistrag())
					+ "," + booleanToInt(mv.isBetriebskostenVorauszahlung()) + "," + mv.getBetriebskosten() + ","
					+ mv.getMieteGesamtbetrag() + ",'" + mv.getKontoinhaber() + "','" + mv.getIban() + "',"
					+ mv.getMaxHeizkostenInZweiAbrechnungsperioden() + "," + mv.getPauschale() + ","
					+ booleanToInt(mv.isEnergieausweis()) + ","
					+ booleanToInt(mv.isRichtigkeitEnergieausweisVersichert()) + ",'"
					+ mv.getZustaendigGartenpflege() + "','" + mv.getZustaendigGartengeraete() + "',"
					+ mv.getKaution() + "," + mv.getVerteilungHeizUndWarmwasserkosten() + ","
					+ booleanToInt(mv.isBetriebskostenAnteilWohnflaeche()) + ","
					+ booleanToInt(mv.isBetriebskostenEntwaesserungMuellabfuhrWasserversorgung()) + ",'"
					+ dateToString(mv.getAbrechnungszeitraumHeizUndBetriebskosten())+"')";
			
			sta.executeUpdate(sql);
			System.out.println("Mietvertag Attributes upload succeeded!");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static Mietvertrag readMietvertrag(String bezeichnung) {
		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			String query = "select * from Mietvertrag where bezeichnung='" + bezeichnung +"';";
			ResultSet rs = sta.executeQuery(query);

			int id = rs.getInt("Mietvertrag_ID");
			
			Mietvertrag mv = new Mietvertrag();
			
			mv.setId(id); 
			mv.setPartei1(readPartei(id));
			mv.setPartei2(readPartei(rs.getInt("ParteiZwei_ID")));
			mv.setMietobjekt(readMietobjekt(rs.getInt("Mietobjekt_ID")));
			mv.setMietbeginn(rs.getDate("Mietbeginn"));
			mv.setMietende(rs.getDate("Mietende"));
			mv.setMonatsMiete(rs.getFloat("MonatsMiete"));
			mv.setKeineMieterhoehungInJahren(rs.getFloat("keineMieterhoehungInJahren"));
			mv.setPreisgebunden(intToBoolean(rs.getInt("Preisgebunden")));
			mv.setOeffentlichGefoerdert(intToBoolean(rs.getInt("OeffentlichGefoerdert")));
			mv.setHoechstMiete(rs.getFloat("HoechstMiete"));
			mv.setHoechstMieteBis(rs.getDate("HoechstMieteBis"));
			mv.setHeizungWarmwasserKosten(rs.getFloat("HeizungWarmwasserKosten"));
			mv.setBetriebskostenPauschalbeistrag(intToBoolean(rs.getInt("BetriebskostenPauschalbeitrag")));
			mv.setBetriebskostenVorauszahlung(intToBoolean(rs.getInt("BetriebskostenVorauszahlung")));
			mv.setBetriebskosten(rs.getFloat("Betriebskosten"));
			mv.setMieteGesamtbetrag(rs.getFloat("MieteGesamtbetrag"));
			mv.setKontoinhaber(rs.getString("Kontoinhaber"));
			mv.setIban(rs.getString("Iban"));
			mv.setMaxHeizkostenInZweiAbrechnungsperioden(rs.getFloat("MaxHeizkostenInZweiAbrechnungsperioden"));
			mv.setPauschale(rs.getInt("Pauschale"));
			mv.setEnergieausweis(intToBoolean(rs.getInt("Energieausweis")));
			mv.setRichtigkeitEnergieausweisVersichert(intToBoolean(rs.getInt("RichtigkeitEnergieausweisVersichert")));
			mv.setZustaendigGartenpflege(rs.getString("ZustaendigGartenpflege"));
			mv.setZustaendigGartengeraete(rs.getString("ZustaendigGartengeraete"));
			mv.setKaution(rs.getInt("Kaution"));
			mv.setVerteilungHeizUndWarmwasserkosten(rs.getFloat("VerteilungHeizUndWarmwasserkosten"));
			mv.setBetriebskostenAnteilWohnflaeche(intToBoolean(rs.getInt("BetriebskostenAnteilWohnflaeche")));
			mv.setBetriebskostenEntwaesserungMuellabfuhrWasserversorgung(intToBoolean(rs.getInt("BetriebskostenEntwaesserungMuellabfuhrWasserversorgung")));
			mv.setAbrechnungszeitraumHeizUndBetriebskosten(rs.getDate("AbrechnungszeitraumHeizUndBetriebskosten"));	
			
			mv.setBetriebskostenArten(readArrayList("Betriebskostenarten", "Mietvertrag_ID", id));
			mv.setArbeitenDieDerMieterVornehemnKann(readArrayList("ArbeitenDieDerMieterVornehmenKann", "Mietvertrag_ID", id ));
			mv.setArbeitenVorEinzug(readArrayList("ArbeitenVorEinzug", "Mietvertrag_ID", id));
			
	        System.out.println("Download Izzzda");
	        conn.close();
	        
	        return mv;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		   }
	}
	
	public static void writeMietobjekt(Mietobjekt mo) {
		String strasse = mo.getStrasse();
		int hausNr = mo.getHausNr();
		String hausNrZusatz = mo.getHausNrZusatz();
		int plz = mo.getPlz();
		String ort = mo.getOrt();
		int etage = mo.getEtage();
		float wohnflaeche = mo.getWohnflaeche();
		float anzahlZimmer = mo.getAnzahlZimmer();
		int anzahlKuechen = mo.getAnzahlKuechen();
		int anzahlBadDuscheWC = mo.getAnzahlBadDuscheWc();
		int anzahlBodenraeumeSpeicher = mo.getAnzahlBodenraeumeSpeicher();
		int geragenplatz = booleanToInt(mo.isGaragenplatz());
		int gartenVorhanden = booleanToInt(mo.isGartenVorhanden());
		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query1 = "insert into Mietobjekt values (null, '" + strasse + "', " + hausNr + ", '" + hausNrZusatz + "', "
					+ plz + ", '" + ort + "', " + etage + ", " + wohnflaeche + ", " + anzahlZimmer
					+ ", " + anzahlKuechen + ", " + anzahlBadDuscheWC + ", " + anzahlBodenraeumeSpeicher + ", "
					+ geragenplatz + ", " + gartenVorhanden + ")";
			sta.executeUpdate(query1);
			
			System.out.println("Mietobjekt upload succeeded!");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Mietobjekt readMietobjekt(int id) {
		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query1 = "select * from Mietobjekt where Mietobjekt_ID ="+ id;
			ResultSet rs = sta.executeQuery(query1);
			
			Mietobjekt mo = new Mietobjekt();
			mo.setStrasse(rs.getString("strasse"));
			mo.setHausNr(rs.getInt("hausNr"));
			mo.setHausNrZusatz(rs.getString("hausNrZusatz"));
			mo.setPlz(rs.getInt("plz"));
			mo.setOrt(rs.getString("ort"));
			mo.setEtage(rs.getInt("etage"));
			mo.setWohnflaeche(rs.getFloat("wohnflaeche"));
			mo.setAnzahlZimmer(rs.getInt("anzahlZimmer"));
			mo.setAnzahlKuechen(rs.getInt("anzahlKuechen"));
			mo.setAnzahlBadDuscheWc(rs.getInt("anazhlBadDuscheWc"));
			mo.setAnzahlBodenraeumeSpeicher(rs.getInt("anzahlBodenraeumeSpeicher"));
			mo.setGaragenplatz(intToBoolean(rs.getInt("garagenplatz")));
			mo.setGartenVorhanden(intToBoolean(rs.getInt("gartenVorhanden")));
			
			System.out.println("Mietobjekt download succeeded!");
			conn.close();
			return mo;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public static ArrayList<String> readArrayList(String tabellenName, String spaltenname, int id) {
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			String queryUnfall = "select * from " + tabellenName + " where "+ spaltenname +" = "+ id;
			ResultSet rsUnfall = sta.executeQuery(queryUnfall);
			ArrayList<String> unfallschaeden = new ArrayList<>();

			while (rsUnfall.next()) {
				unfallschaeden.add(rsUnfall.getString("bezeichnung"));
			}
			System.out.println("Array download succeeded!");
			conn.close();
			return unfallschaeden;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static void writeArrayList(String tabellenName, ArrayList<String> liste, String vertragsArt) {	
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			ResultSet rs = sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = '" + vertragsArt + "'");
			int id = rs.getInt(1);

			if (liste!=null && !liste.isEmpty()) {
				for (String schaden : liste) {
					String sql2 = "insert into " + tabellenName + " values (null, " + id + " , '" + schaden + "')";
					sta.executeUpdate(sql2);
				}
				System.out.println("Array upload succeeded!");
			}else {
				System.out.println("Array empty");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteTable(int id, String tabellenName) {

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "delete from" + tabellenName + " where " + tabellenName + "_ID=" + id;
			sta.executeUpdate(query);

			System.out.println(tabellenName + " deleted");
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int booleanToInt(boolean bool) {
		if (bool == true)
			return 1;
		else
			return 0;
	}
	public static boolean intToBoolean(int i) {
		if (i == 0)
			return false;
		else
			return true;
	}
	public static String dateToString(Date date) {
		if(!(date == null)) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.format(date);
		}
		else {
			return null;
		}
	}
	public static Date stringToDate(String date) {
		if(!"null".equals(date)) {
			System.out.println("String");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date1 = df.parse(date);
				return date1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		} 
		else {
			return null;
		}
	}
}