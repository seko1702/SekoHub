package control;

import model.NatuerlichePartei;

import java.util.ArrayList;

import model.Fahrzeug;
import model.KfzKaufvertrag;
import model.NatuerlichePartei;

public class Main {

	public static void main(String[] args) {

		
		NatuerlichePartei np = new NatuerlichePartei();
		np.setStrasse("s");
		np.setHausnummer(1);
		np.setHausnummerZusatz("1a");
		np.setOrt("Berlin");
		np.setTelnummer(1234);
		np.setName("Hans");
		np.setVorname("sad");

		//Database.writeNatuerlichePartei(np);
		//np = Database.readNatuerlichePartei(3);
		System.out.println(np.getStrasse());
		Database db = new Database();
		
		
		
		
		NatuerlichePartei p1 = new NatuerlichePartei();
		NatuerlichePartei p2 = new NatuerlichePartei();
		Fahrzeug f1 = new Fahrzeug();
		
		p1.setStrasse("Senf 3");
		
		KfzKaufvertrag kv = new KfzKaufvertrag();
		
		kv.setAlleinigesEigentum(true);
		kv.setKaufpreis(45000);
		kv.setAnzahlSchluessel(2);
		ArrayList<String> unfallschaeden = new ArrayList<String>();
		unfallschaeden.add("Rechter Kotflügel Hinten Neu");
		unfallschaeden.add("Linker Kotflügel  Hinten Neu");
		kv.setListeUnfallschaeden(unfallschaeden);
		
		ArrayList<String> beschaedigungen = new ArrayList<String>();
		beschaedigungen.add("Sitze vorne gerissen");
		beschaedigungen.add("Licht rechts vorne kaputt");
		kv.setBeschaedigungen(beschaedigungen);
//		Database.writeArrayListCols(kv, "Beschaedigungen", kv.getBeschaedigungen());
		
		ArrayList<String> sondervereinbarung = new ArrayList<String>();
		sondervereinbarung.add("15% Anzahlung");
		sondervereinbarung.add("5 Tage Ummeldung");
		kv.setSondervereinbarungen(sondervereinbarung);
//		Database.writeArrayListCols(kv, "Sondervereinbarungen", kv.getSondervereinbarungen());
		
		kv.setAnzahlSchluessel(3);
		kv.setAnzahlung(110020);
		
		NatuerlichePartei p3 = Database.readNatuerlichePartei(6);
		
		System.out.println(p3.getStrasse());
		
		KfzKaufvertrag kv5 = new KfzKaufvertrag();
		kv5.setKaufpreis(50000);
		kv5.setListeUnfallschaeden(unfallschaeden);
		kv5.setSondervereinbarungen(sondervereinbarung);
		kv5.setBeschaedigungen(beschaedigungen);
		Database.wirteKfzKaufvertrag(kv5);
		
		
		kv.setListeUnfallschaeden(unfallschaeden);
//		Database.writeKfzKaufvertrag(kv);
		Database.wirteKfzKaufvertrag(kv);
		
		
//		System.out.println(kv.getBezeichnung());
		
//		Database.writeArrayListCols(kv, "Unfallschaeden", kv.getListeUnfallschaeden());
//		Database.writeKfzKaufvertrag(kv);
//		Database.writeUnfallschaeden(kv);
		
//		Database.writeNatuerlichePartei(p1);
		
		
		KfzKaufvertrag kv2 = Database.readKfzKaufvertrag(41);
		
		ArrayList<String> us = kv2.getListeUnfallschaeden();
		for (String string : us) {
			System.out.println("Außerhalb broda: "+string);
			
		}
		
		ArrayList<String> sv = kv2.getSondervereinbarungen();
		for (String string : sv) {
			
			System.out.println("sv: "+string);
			
		}
		
		System.out.println(kv2.getAnzahlung());
		
		
//		System.out.println(kv2.getListeUnfallschaeden().get(1));
		
//		Database.writeKfzKaufvertragKomplett(kv);
//		Database.writeKfzKaufvertrag(kv);
		
		
		
	}
}
