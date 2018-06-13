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

			String query = "insert into Partei values (null, 'NatürlichePartei', '" + strasse + "'," + hausnummer
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

		writeArrayListCols("Unfallschaeden", vertrag.getListeUnfallschaeden(), "KfzKaufvertrag");
		writeArrayListCols("Sondervereinbarungen", vertrag.getSondervereinbarungen(), "KfzKaufvertrag");
		writeArrayListCols("Beschaedigungen", vertrag.getBeschaedigungen(), "KfzKaufvertrag");

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
			
			vertrag.setListeUnfallschaeden(readArrayListCols("unfallschaeden", "KfzKaufvertrag_ID", id));
			vertrag.setBeschaedigungen(readArrayListCols("beschaedigungen", "KfzKaufvertrag_ID", id));
			vertrag.setSondervereinbarungen(readArrayListCols("sondervereinbarungen", "KfzKaufvertrag_ID", id));
			
			conn.close();
			return vertrag;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<String> readArrayListCols(String tabellenName, String spaltenname, int id) {

		conn = DatabaseCon.connect();
		Statement sta;
		try {
			sta = conn.createStatement();
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

	public static void writeArrayListCols(String tabellenName, ArrayList<String> liste, String vertragsArt) {

		conn = DatabaseCon.connect();
		try {
			Statement sta = conn.createStatement();

			ResultSet rs = sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = '" + vertragsArt + "'");
			int id = rs.getInt(1);

			if (!liste.isEmpty()) {
				for (String schaden : liste) {
					String sql2 = "insert into " + tabellenName + " values (null, " + id + " , '" + schaden + "')";
					sta.executeUpdate(sql2);
				}
				System.out.println("Array upload succeeded!");
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

			writeArrayListCols("ZusatzAusstattung", zusatzAusstattung, "Fahrzeug");
			
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
			fz.setZusatzAusstattung(readArrayListCols("ZusatzAusstattung", "Fahrzeug_ID", id));
			fz.setAnzahlVorbesitzer(rs.getInt("anzahlVorbesitzer"));
			fz.setGewerbNutzung(intToBoolean(rs.getInt("gewerbNutzung")));
			
			return fz;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	

		
	}
	
	public void writeMietvertrag(Mietvertrag mv) {
		
	}
	
	public void writeMietvertragAttributes(Mietvertrag miete) {
		try {
			conn = DatabaseCon.connect();
			Statement state = conn.createStatement();

			String sql = "insert into Mietvertrag values(null, null,'" + dateToString(miete.getMietbeginn()) + "','"
					+ dateToString(miete.getMietende()) + "'," + miete.getMonatsMiete() + "," + miete.getKeineMieterhoehungInJahren()
					+ "," + booleanToInt(miete.isPreisgebunden()) + "," + booleanToInt(miete.isOeffentlichGefoerdert())
					+ "," + miete.getHoechstMiete() + ",'" + dateToString(miete.getHoechstMieteBis()) + "',"
					+ miete.getHeizungWarmwasserKosten() + "," + booleanToInt(miete.isBetriebskostenPauschalbeistrag())
					+ "," + booleanToInt(miete.isBetriebskostenVorauszahlung()) + "," + miete.getBetriebskosten() + ","
					+ miete.getMieteGesamtbetrag() + ",'" + miete.getKontoinhaber() + "','" + miete.getIban() + "',"
					+ miete.getMaxHeizkostenInZweiAbrechnungsperioden() + "," + miete.getPauschale() + ","
					+ booleanToInt(miete.isEnergieausweis()) + ","
					+ booleanToInt(miete.isRichtigkeitEnergieausweisVersichert()) + ",'"
					+ miete.getZustaendigGartenpflege() + "','" + miete.getZustaendigGartengeraete() + "',"
					+ miete.getKaution() + "," + miete.getVerteilungHeizUndWarmwasserkosten() + ","
					+ booleanToInt(miete.isBetriebskostenAnteilWohnflaeche()) + ","
					+ booleanToInt(miete.isBetriebskostenEntwaesserungMuellabfuhrWasserversorgung()) + ",'"
					+ dateToString(miete.getAbrechnungszeitraumHeizUndBetriebskosten())+"')";
			
			state.executeUpdate(sql);
			System.out.println("Noice");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static Mietvertrag readMietvertrag(int id) {
		
		try {
			conn = DatabaseCon.connect();
			Statement stm = conn.createStatement();
			
			String query = "select ";
		    ResultSet res = stm.executeQuery(query);
			
			Mietvertrag mt = new Mietvertrag();
			
			mt.setId(id);   //ID f�r Vertrag
			//mt.setId(id); //Mietobjekt ID
			mt.setMietbeginn(res.getDate("Mietbeginn"));
			mt.setMietende(res.getDate("Mietende"));
			mt.setMonatsMiete(res.getFloat("MonatsMiete"));
			mt.setKeineMieterhoehungInJahren(res.getFloat("keineMieterhoehungInJahren"));
			mt.setPreisgebunden(intToBoolean(res.getInt("Preisgebunden")));
			mt.setOeffentlichGefoerdert(intToBoolean(res.getInt("OeffentlichGefoerdert")));
			mt.setHoechstMiete(res.getFloat("HoechstMiete"));
			mt.setHoechstMieteBis(res.getDate("HoechstMieteBis"));
			mt.setHeizungWarmwasserKosten(res.getFloat("HeizungWarmwasserKosten"));
			//ArrayList BetriebskostenArten
			mt.setBetriebskostenPauschalbeistrag(intToBoolean(res.getInt("BetriebskostenPauschalbeitrag")));
			mt.setBetriebskostenVorauszahlung(intToBoolean(res.getInt("BetriebskostenVorauszahlung")));
			mt.setBetriebskosten(res.getFloat("Betriebskosten"));
			mt.setMieteGesamtbetrag(res.getFloat("MieteGesamtbetrag"));
			mt.setKontoinhaber(res.getString("Kontoinhaber"));
			mt.setIban(res.getString("Iban"));
			mt.setMaxHeizkostenInZweiAbrechnungsperioden(res.getFloat("MaxHeizkostenInZweiAbrechnungsperioden"));
			//ArrayList ArbeitenDieDerMieterVornehmenKann
			mt.setPauschale(res.getInt("Pauschale"));
			//ArrayList ArbeitenVorEinzug
			mt.setEnergieausweis(intToBoolean(res.getInt("Energieausweis")));
			mt.setRichtigkeitEnergieausweisVersichert(intToBoolean(res.getInt("RichtigkeitEnergieausweisVersichert")));
			mt.setZustaendigGartenpflege(res.getString("ZustaendigGartenpflege"));
			mt.setZustaendigGartengeraete(res.getString("ZustaendigGartengeraete"));
			mt.setKaution(res.getInt("Kaution"));
			mt.setVerteilungHeizUndWarmwasserkosten(res.getFloat("VerteilungHeizUndWarmwasserkosten"));
			mt.setBetriebskostenAnteilWohnflaeche(intToBoolean(res.getInt("BetriebskostenAnteilWohnflaeche")));
			mt.setBetriebskostenEntwaesserungMuellabfuhrWasserversorgung(intToBoolean(res.getInt("BetriebskostenEntwaesserungMuellabfuhrWasserversorgung")));
			mt.setAbrechnungszeitraumHeizUndBetriebskosten(res.getDate("AbrechnungszeitraumHeizUndBetriebskosten"));		
			
	        System.out.println("Download Izzzda");
	        conn.close();
	        
	        return mt;
	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
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
	

