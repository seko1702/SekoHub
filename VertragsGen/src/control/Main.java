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

		Database.writeNatuerlichePartei(np);
		
		Fahrzeug f1 = new Fahrzeug();
		f1.setTyp("sdf");
		f1.setModell("Test");
			
		KfzKaufvertrag kv = new KfzKaufvertrag();
		
		kv.setAlleinigesEigentum(true);
		kv.setKaufpreis(45000);
		kv.setAnzahlSchluessel(2);
		
		ArrayList<String> unfallschaeden = new ArrayList<>();
		unfallschaeden.add("Rechter Kotflügel Hinten Neu");
		unfallschaeden.add("Linker Kotflügel  Hinten Neu");
		kv.setListeUnfallschaeden(unfallschaeden);
		
		ArrayList<String> beschaedigungen = new ArrayList<>();
		beschaedigungen.add("Sitze vorne gerissen");
		beschaedigungen.add("Licht rechts vorne kaputt");
		kv.setBeschaedigungen(beschaedigungen);
		
		ArrayList<String> sondervereinbarung = new ArrayList<>();
		sondervereinbarung.add("15% Anzahlung");
		sondervereinbarung.add("5 Tage Ummeldung");
		kv.setSondervereinbarungen(sondervereinbarung);
						
		Database.wirteKfzKaufvertrag(kv);		
		
		KfzKaufvertrag kv2 = Database.readKfzKaufvertrag(41);

	}
}
