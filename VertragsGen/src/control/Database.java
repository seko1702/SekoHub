package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.JuristischePartei;
import model.NatuerlichePartei;
import model.Vertrag;
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
			
			String query = "insert into Partei values (null, 'NatürlichePartei', '"+ strasse +"',"+ hausnummer +", '"+ hausnummerZusatz +"',"+ plz +", '"+ ort +"', "+ telnummer +", null , null , '"+ name +"', '"+ vorname +"', '"+ personalausweisNr +"', '"+ ausstellungsbehoerde +"', '"+ ausstellungsdatum +"', '"+ geburtsdatum +"');";
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
	
	
	public static ArrayList<String> readArrayListCols(int id, String tabellenName){
		
		conn = DatabaseCon.connect();
		Statement sta;
		try {
			sta = conn.createStatement();
			String queryUnfall = "select * from "+tabellenName+" where KfzKaufvertrag_ID="+id;
			ResultSet rsUnfall = sta.executeQuery(queryUnfall);
			ArrayList<String> unfallschaeden = new ArrayList<>();
			
			while(rsUnfall.next()) {
			
				unfallschaeden.add(rsUnfall.getString("bezeichnung"));
				System.out.println(rsUnfall.getString("bezeichnung"));
		
			}
			return unfallschaeden;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
		
	}
	
	
	public static KfzKaufvertrag readKfzKaufvertrag(int id) {
		
		
		try {
			
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			String query = "select * from KfzKaufvertrag where KfzKaufvertrag_ID="+ id;
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
			
			return vertrag;
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public static void writeKfzKaufvertragKomplett(KfzKaufvertrag vertrag) {
		
		
		writeKfzKaufvertrag(vertrag);
		
		writeArrayListCols("Unfallschaeden", vertrag.getListeUnfallschaeden(), "KfzKaufvertrag");
		writeArrayListCols("Sondervereinbarungen", vertrag.getSondervereinbarungen(), "KfzKaufvertrag");
		writeArrayListCols("Beschaedigungen", vertrag.getBeschaedigungen(), "KfzKaufvertrag");
		
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
			
			ResultSet rs = sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = 'KfzKaufvertrag'");
			int id = rs.getInt(1);
			
			System.out.println(id);
			
			String sql2 = "insert into Unfallschaeden values (null, "+id+" , '"+vertrag.getBezeichnung()+"')";
//			SELECT seq FROM sqlite_sequence WHERE name = KfzKaufvertrag
			
			System.out.println(sql2);
			sta.executeUpdate(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
	}
    
    public static void writeArrayListCols(Vertrag vertrag, String tabellenName, ArrayList<String> liste) {
    	
    	Connection conn = DatabaseCon.connect();
    	try {
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = 'KfzKaufvertrag'");
			int id = rs.getInt(1);
			
			
			
			for (String schaden : liste) {
				
				String sql2 = "insert into "+tabellenName+" values (null, "+id+" , '"+schaden+"')";
				sta.executeUpdate(sql2);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
 public static void writeArrayListCols(String tabellenName, ArrayList<String> liste, String vertragsArt) {
    	
    	Connection conn = DatabaseCon.connect();
    	try {
			Statement sta = conn.createStatement();
			
			ResultSet rs = sta.executeQuery("SELECT seq FROM sqlite_sequence WHERE name = '"+vertragsArt+"'");
			int id = rs.getInt(1);
			
			
			
			for (String schaden : liste) {
				
				String sql2 = "insert into "+tabellenName+" values (null, "+id+" , '"+schaden+"')";
				sta.executeUpdate(sql2);
				
			}
			
			
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
	
	public static void deleteTable(int id, String tabellenName) {
		
		try {
			conn = DatabaseCon.connect();
			Statement sta = conn.createStatement();
			
			String query = "delete from"+tabellenName+" where "+tabellenName+"_ID="+ id;
			sta.executeUpdate(query);
			
			System.out.println(tabellenName+" deleted");
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
	
	public static boolean intConv(int i) {
		if(i == 0)
			return false;
		else
			return true;
	}



}
