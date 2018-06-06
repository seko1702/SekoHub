package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.JuristischePartei;
import model.NatuerlichePartei;

import model.KfzKaufvertrag;
import model.Mietvertrag;

public class Database {
	
	private static Connection conn;
	
	//Speichert eine Natuerliche Partei in die Datenbank 
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
		String ausstellungsdatum = np.getAusstellungsdatum();
		String geburtsdatum = np.getGeburtsdatum();
	
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			
			String query = "insert into Partei values (null, 'NatÃ¼rlichePartei', '"+ strasse +"',"+ hausnummer +", '"+ hausnummerZusatz +"',"+ plz +", '"+ ort +"', "+ telnummer +", null , null , '"+ name +"', '"+ vorname +"', '"+ personalausweisNr +"', '"+ ausstellungsbehoerde +"', '"+ ausstellungsdatum +"', '"+ geburtsdatum +"');";
			sta.executeUpdate(query);
			System.out.println("upload succeeded!");
			conn.close();
		}
		catch(SQLException e) {
			 System.out.println(e.getMessage());
		}
	}
	
	//Liest eine Natuerliche Partei aus der Datenbank
	public static NatuerlichePartei readNatuerlichePartei(int id) {
		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			
			String query = "select * from Partei where Partei_ID="+ id;
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
			np.setAusstellungsdatum(rs.getString("austellungsdatum"));
			np.setGeburtsdatum(rs.getString("geburtsdatum"));
			
			System.out.println("download succeeded!");
			conn.close();
			
			return np;
		}
		catch(SQLException e) {
			 System.out.println(e.getMessage());
			 return null;
		}
	}
	
	//Speichert eine Juristische Partei in die Datenbank 
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
			
			
			String query = "insert into Partei values (null, 'JuristischePartei', '"+ strasse +"',"+ hausnummer +", '"+ hausnummerZusatz +"',"+ plz +", '"+ ort +"', "+ telnummer +", '"+ firmenname +"', '"+ handelsregister +"',null,null,null,null,null,null)" ;
			sta.executeUpdate(query);
			System.out.println("upload succeeded!");
			conn.close();
		}
		catch(SQLException e) {
			 System.out.println(e.getMessage());
		}
	}

	//Liest eine Juristische Partei aus der Datenbank
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
		}catch(SQLException e) {
			 System.out.println(e.getMessage());
			 return null;}
	}

	public static void writeKfzKaufvertrag(KfzKaufvertrag vertrag) {
		
		try {
			Connection conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			
			String sql1 = "insert into KfzKaufvertrag values (null, null, null, null,"+booleanConv(vertrag.isAlleinigesEigentum())+
					","+booleanConv(vertrag.isAustauschmotor())+","+vertrag.getAustauschmotorLaufleistung()+","+booleanConv(vertrag.isUnfallschaden())+
					","+booleanConv(vertrag.isUmmeldungUnverzueglich())+
					","+booleanConv(vertrag.isFahrzeugAbgemeldet())+","+booleanConv(vertrag.isFahrzeugschein())+
					","+booleanConv(vertrag.isFahrzeugbrief())+","+booleanConv(vertrag.isStillegungsBescheinigung())+","+booleanConv(vertrag.isUntersuchungsbericht())+
					","+vertrag.getAnzahlSchluessel()+","+vertrag.getKaufpreis()+","+vertrag.getAnzahlung()+")";
			
			
			
			sta.executeUpdate(sql1);
			
			System.out.println("Boom chaka laka");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
    public static void writeUnfallschaeden(KfzKaufvertrag vertrag) {
    	
    	Connection conn = DatabaseCon.connect();
    	try {
			Statement sta = conn.createStatement();
			String sql2 = "insert into Unfallschaeden values (null, "
					+ "(SELECT seq FROM sqlite_sequence WHERE name = KfzKaufvertrag),"+vertrag.getBezeichnung()+")";
			sta.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
	}
	
	//Loescht eine Partei aus der Datenbank
	public static void deletePartei(int id) {
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			
			String query = "delete from Partei where Partei_ID="+ id;
			sta.executeUpdate(query);
			
			System.out.println("Partei deleted");
			conn.close();
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    	
    	
    	
    }

	public static int booleanConv(boolean bool) {

		if (bool == true)
			return 1;
		else
			return 0;

	}

	// public KfzKaufvertrag readKfzKaufvertrag(int ID) {
	//
	// Statement sta;
	// try {
	// Connection conn = DatabaseCon.connect();
	// sta = conn.createStatement();
	// String sql = "SELECT * FROM KfzKaufvertrag WHERE id ="+ID+"";
	// ResultSet rs = sta.executeQuery(sql);
	// rs.next();
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	//
	//
	//
	//
	// }
	
	/**
	 * 
	 * Wer das liest ist doof hehe
	 * 
	 */
	
	public void writeMietvertrag(Mietvertrag miete) {

		try {
			conn = DatabaseCon.connect();
			Statement state = conn.createStatement();

			String sql = "insert into Mietvertrag values(null, null,'" + dateToString(miete.getMietbeginn()) + "','"
					+ dateToString(miete.getMietende()) + "'," + miete.getMonatsMiete() + "," + miete.getKeineMieterhoehungInJahren()
					+ "," + booleanConv(miete.isPreisgebunden()) + "," + booleanConv(miete.isOeffentlichGefoerdert())
					+ "," + miete.getHoechstMiete() + ",'" + dateToString(miete.getHoechstMieteBis()) + "',"
					+ miete.getHeizungWarmwasserKosten() + "," + booleanConv(miete.isBetriebskostenPauschalbeitrag())
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public static boolean intConv(int i) {
		if(i==0)
			return false;
		else
			return true;
	}
	
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static Mietvertrag readMietvertrag(int id) {
		
		try {
			conn = DatabaseCon.connect();
			Statement stm = conn.createStatement();
			
			String query = "select ";
		    ResultSet res = stm.executeQuery(query);
			
			Mietvertrag mt = new Mietvertrag();
			
			mt.setId(id);   //ID für Vertrag
			//mt.setIdt(idt); //Mietobjekt ID
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

	}
	

