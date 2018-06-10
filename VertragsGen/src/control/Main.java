package control;

import model.NatuerlichePartei;
import model.Partei;

import java.util.ArrayList;
import model.Fahrzeug;
import model.JuristischePartei;
import model.KfzKaufvertrag;
import model.NatuerlichePartei;

public class Main {

	public static void main(String[] args) {

		Partei p =  Database.readPartei("Hans", "sad");
		System.out.println(p.getId());
		
//		NatuerlichePartei np = new NatuerlichePartei();
//		np.setStrasse("s");
//		np.setHausnummer(1);
//		np.setHausnummerZusatz("1a");
//		np.setOrt("Berlin");
//		np.setTelnummer(1234);
//		np.setName("Hans");
//		np.setVorname("sad");
//
//		Database.writePartei(np);
//		
//		JuristischePartei jp = new JuristischePartei();
//		jp.setStrasse("s");
//		jp.setHausnummer(1);
//		jp.setHausnummerZusatz("1a");
//		jp.setOrt("Berlin");
//		jp.setTelnummer(1234);
//		jp.setHandelsregister("testHandelsregsiter");
//		
//		Database.writePartei(jp);
//		
//		Fahrzeug fz = new Fahrzeug();
//		fz.setTyp("sdf");
//		fz.setModell("Test");
//		ArrayList<String> zusatz = new ArrayList<>();
//		zusatz.add("Rechter Kotflügel Hinten Neu");
//		zusatz.add("Linker Kotflügel  Hinten Neu");
//		fz.setZusatzAusstattung(zusatz);
//		
//		Database.writeFahrzeug(fz);
//			
//		KfzKaufvertrag kv = new KfzKaufvertrag();
//		
//		kv.setAlleinigesEigentum(true);
//		kv.setKaufpreis(45000);
//		kv.setAnzahlSchluessel(2);
//		
//		ArrayList<String> unfallschaeden = new ArrayList<>();
//		unfallschaeden.add("Rechter Kotflügel Hinten Neu");
//		unfallschaeden.add("Linker Kotflügel  Hinten Neu");
//		kv.setListeUnfallschaeden(unfallschaeden);
//		
//		ArrayList<String> beschaedigungen = new ArrayList<>();
//		beschaedigungen.add("Sitze vorne gerissen");
//		beschaedigungen.add("Licht rechts vorne kaputt");
//		kv.setBeschaedigungen(beschaedigungen);
//		
//		ArrayList<String> sondervereinbarung = new ArrayList<>();
//		sondervereinbarung.add("15% Anzahlung");
//		sondervereinbarung.add("5 Tage Ummeldung");
//		kv.setSondervereinbarungen(sondervereinbarung);
//		
//		Database.wirteKfzKaufvertrag(kv, fz, np, jp);
//							
//		KfzKaufvertrag kv2 = Database.readKfzKaufvertrag(41);

	}
}
