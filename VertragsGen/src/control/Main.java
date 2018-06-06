package control;

import model.NatuerlichePartei;

import model.Fahrzeug;
import model.KfzKaufvertrag;
import model.Mietvertrag;
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
		
		String x = "Tst, Test, Test,"+db.booleanConv(true)+","+db.booleanConv(false);
		
		
		
		System.out.println(x);
		NatuerlichePartei p1 = new NatuerlichePartei();
		NatuerlichePartei p2 = new NatuerlichePartei();
		Fahrzeug f1 = new Fahrzeug();
		
		KfzKaufvertrag kv = new KfzKaufvertrag();
		
		kv.setAlleinigesEigentum(true);
		kv.setKaufpreis(30000);
		kv.setAnzahlSchluessel(3);
		kv.setBezeichnung("Rechter Kotflügel");
		
//		db.writeKfzKaufvertrag(kv);
//		db.writeUnfallschaeden(kv);
		
		Mietvertrag m = new Mietvertrag();
		m.setKaution(3000);
		
	    db.writeMietvertrag(m);
		
		
	}
}
