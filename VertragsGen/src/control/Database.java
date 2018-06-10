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
	public static void writeNatuerlichePartei(NatuerlichePartei np) {

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
			System.out.println("upload succeeded!");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Liest eine Natuerliche Partei aus der Datenbank
	public static NatuerlichePartei readNatuerlichePartei(int id) {

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "select * from Partei where Partei_ID=" + id;
			ResultSet rs = sta.executeQuery(query);

			NatuerlichePartei np = new NatuerlichePartei();

			np.setId(id);
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

			System.out.println("download succeeded!");
			conn.close();

			return np;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Speichert eine Juristische Partei in die Datenbank
	public static void writeJuristischePartei(JuristischePartei jp) {

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
			System.out.println("upload succeeded!");
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Liest eine Juristische Partei aus der Datenbank
	public static JuristischePartei readJuristischePartei(int id) {

		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();

			String query = "select  ";
			ResultSet rs = sta.executeQuery(query);

			JuristischePartei jp = new JuristischePartei();

			jp.setId(id);
			jp.setStrasse(rs.getString("strasse"));
			jp.setHausnummer(rs.getInt("hausnummer"));
			jp.setHausnummerZusatz(rs.getString("hausnummerZusatz"));
			jp.setPlz(rs.getInt("plz"));
			jp.setOrt(rs.getString("ort"));
			jp.setTelnummer(rs.getInt("telefonnummer"));
			jp.setFirmenname(rs.getString("firmenname"));
			jp.setHandelsregister(rs.getString("handelsregister"));

			System.out.println("download succeeded!");
			conn.close();

			return jp;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void wirteKfzKaufvertrag(KfzKaufvertrag vertrag, Fahrzeug fahrzeug, Partei p1, Partei p2) {
		
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

            ResultSet kID= sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = 'Partei'");
            int partei1ID= kID.getInt(1);
            int partei2ID= partei1ID-1;



            String sql1 = "insert into KfzKaufvertrag values (null, "+fahrzeugID+", "+partei1ID+", "+partei2ID+","
                    + booleanConv(vertrag.isAlleinigesEigentum()) + "," + booleanConv(vertrag.isAustauschmotor()) + ","
                    + vertrag.getAustauschmotorLaufleistung() + "," + booleanConv(vertrag.isUnfallschaden()) + ","
                    + booleanConv(vertrag.isUmmeldungUnverzueglich()) + ","
                    + booleanConv(vertrag.isFahrzeugAbgemeldet()) + "," + booleanConv(vertrag.isFahrzeugschein()) + ","
                    + booleanConv(vertrag.isFahrzeugbrief()) + "," + booleanConv(vertrag.isStillegungsBescheinigung())
                    + "," + booleanConv(vertrag.isUntersuchungsbericht()) + "," + vertrag.getAnzahlSchluessel() + ","
                    + vertrag.getKaufpreis() + "," + vertrag.getAnzahlung() + ")";

            sta.executeUpdate(sql1);

            System.out.println("Boom chaka laka");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
	
	public static KfzKaufvertrag readKfzKaufvertrag(int id) {

		try {

			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			String query = "select * from KfzKaufvertrag where KfzKaufvertrag_ID=" + id;
			ResultSet rsVertrag = sta.executeQuery(query);

			KfzKaufvertrag vertrag = new KfzKaufvertrag();

			vertrag.setId(id);
			vertrag.setAlleinigesEigentum(intConv(rsVertrag.getInt("alleinigesEigentum")));
			vertrag.setAustauschmotor(intConv(rsVertrag.getInt("austauschmotor")));
			vertrag.setAustauschmotorLaufleistung(rsVertrag.getInt("austauschmotorLaufleistung"));
			vertrag.setUnfallschaden(intConv(rsVertrag.getInt("unfallschaden")));
			vertrag.setUmmeldungUnverzueglich(intConv(rsVertrag.getInt("ummeldungUnverzueglich")));
			vertrag.setFahrzeugAbgemeldet(intConv(rsVertrag.getInt("fahrzeugAbgemeldet")));
			vertrag.setFahrzeugschein(intConv(rsVertrag.getInt("fahrzeugschein")));
			vertrag.setFahrzeugbrief(intConv(rsVertrag.getInt("fahrzeugbrief")));
			vertrag.setStillegungsBescheinigung(intConv(rsVertrag.getInt("stillegungsBescheinigung")));
			vertrag.setUntersuchungsbericht(intConv(rsVertrag.getInt("untersuchungsbericht")));
			vertrag.setAnzahlSchluessel(rsVertrag.getInt("anzahlSchluessel"));
			vertrag.setKaufpreis(rsVertrag.getInt("kaufpreis"));
			vertrag.setAnzahlung(rsVertrag.getInt("anzahlung"));

			vertrag.setListeUnfallschaeden(readArrayListCols(id, "unfallschaeden"));
			vertrag.setBeschaedigungen(readArrayListCols(id, "beschaedigungen"));
			vertrag.setSondervereinbarungen(readArrayListCols(id, "sondervereinbarungen"));

			conn.close();
			return vertrag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static ArrayList<String> readArrayListCols(int id, String tabellenName) {

		conn = DatabaseCon.connect();
		Statement sta;
		try {
			sta = conn.createStatement();
			String queryUnfall = "select * from " + tabellenName + " where KfzKaufvertrag_ID=" + id;
			ResultSet rsUnfall = sta.executeQuery(queryUnfall);
			ArrayList<String> unfallschaeden = new ArrayList<>();

			while (rsUnfall.next()) {

				unfallschaeden.add(rsUnfall.getString("bezeichnung"));
				System.out.println(rsUnfall.getString("bezeichnung"));

			}
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
			}

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
		int gewerblicheNutzung = booleanConv(fz.isGewerbNutzung());

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
	
	public void writeMietvertrag(Mietvertrag mv) {
		
	}
	
	public void writeMietvertragAttributes(Mietvertrag miete) {
		try {
			conn = DatabaseCon.connect();
			Statement state = conn.createStatement();

			String sql = "insert into Mietvertrag values(null, null,'" + dateToString(miete.getMietbeginn()) + "','"
					+ dateToString(miete.getMietende()) + "'," + miete.getMonatsMiete() + "," + miete.getKeineMieterhoehungInJahren()
					+ "," + booleanConv(miete.isPreisgebunden()) + "," + booleanConv(miete.isOeffentlichGefoerdert())
					+ "," + miete.getHoechstMiete() + ",'" + dateToString(miete.getHoechstMieteBis()) + "',"
					+ miete.getHeizungWarmwasserKosten() + "," + booleanConv(miete.isBetriebskostenPauschalbeistrag())
					+ "," + booleanConv(miete.isBetriebskostenVorauszahlung()) + "," + miete.getBetriebskosten() + ","
					+ miete.getMieteGesamtbetrag() + ",'" + miete.getKontoinhaber() + "','" + miete.getIban() + "',"
					+ miete.getMaxHeizkostenInZweiAbrechnungsperioden() + "," + miete.getPauschale() + ","
					+ booleanConv(miete.isEnergieausweis()) + ","
					+ booleanConv(miete.isRichtigkeitEnergieausweisVersichert()) + ",'"
					+ miete.getZustaendigGartenpflege() + "','" + miete.getZustaendigGartengeraete() + "',"
					+ miete.getKaution() + "," + miete.getVerteilungHeizUndWarmwasserkosten() + ","
					+ booleanConv(miete.isBetriebskostenAnteilWohnflaeche()) + ","
					+ booleanConv(miete.isBetriebskostenEntwaesserungMuellabfuhrWasserversorgung()) + ",'"
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
			
			mt.setId(id);   //ID für Vertrag
			//mt.setId(id); //Mietobjekt ID
			mt.setMietbeginn(res.getDate("Mietbeginn"));
			mt.setMietende(res.getDate("Mietende"));
			mt.setMonatsMiete(res.getFloat("MonatsMiete"));
			mt.setKeineMieterhoehungInJahren(res.getFloat("keineMieterhoehungInJahren"));
			mt.setPreisgebunden(intConv(res.getInt("Preisgebunden")));
			mt.setOeffentlichGefoerdert(intConv(res.getInt("OeffentlichGefoerdert")));
			mt.setHoechstMiete(res.getFloat("HoechstMiete"));
			mt.setHoechstMieteBis(res.getDate("HoechstMieteBis"));
			mt.setHeizungWarmwasserKosten(res.getFloat("HeizungWarmwasserKosten"));
			//ArrayList BetriebskostenArten
			mt.setBetriebskostenPauschalbeistrag(intConv(res.getInt("BetriebskostenPauschalbeitrag")));
			mt.setBetriebskostenVorauszahlung(intConv(res.getInt("BetriebskostenVorauszahlung")));
			mt.setBetriebskosten(res.getFloat("Betriebskosten"));
			mt.setMieteGesamtbetrag(res.getFloat("MieteGesamtbetrag"));
			mt.setKontoinhaber(res.getString("Kontoinhaber"));
			mt.setIban(res.getString("Iban"));
			mt.setMaxHeizkostenInZweiAbrechnungsperioden(res.getFloat("MaxHeizkostenInZweiAbrechnungsperioden"));
			//ArrayList ArbeitenDieDerMieterVornehmenKann
			mt.setPauschale(res.getInt("Pauschale"));
			//ArrayList ArbeitenVorEinzug
			mt.setEnergieausweis(intConv(res.getInt("Energieausweis")));
			mt.setRichtigkeitEnergieausweisVersichert(intConv(res.getInt("RichtigkeitEnergieausweisVersichert")));
			mt.setZustaendigGartenpflege(res.getString("ZustaendigGartenpflege"));
			mt.setZustaendigGartengeraete(res.getString("ZustaendigGartengeraete"));
			mt.setKaution(res.getInt("Kaution"));
			mt.setVerteilungHeizUndWarmwasserkosten(res.getFloat("VerteilungHeizUndWarmwasserkosten"));
			mt.setBetriebskostenAnteilWohnflaeche(intConv(res.getInt("BetriebskostenAnteilWohnflaeche")));
			mt.setBetriebskostenEntwaesserungMuellabfuhrWasserversorgung(intConv(res.getInt("BetriebskostenEntwaesserungMuellabfuhrWasserversorgung")));
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

	public static int booleanConv(boolean bool) {
		if (bool == true)
			return 1;
		else
			return 0;
	}

	public static String dateToString(Date date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date);
	}

	public static Date stringToDate(String date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date1 = df.parse(date);
			return date1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static boolean intConv(int i) {
		if (i == 0)
			return false;
		else
			return true;
	}
}
	

