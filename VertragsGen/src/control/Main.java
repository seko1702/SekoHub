package control;

import model.NatuerlichePartei;
import model.Partei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Fahrzeug;
import model.JuristischePartei;
import model.KfzKaufvertrag;
import model.Mietobjekt;
import model.Mietvertrag;
import model.NatuerlichePartei;

public class Main extends Application  {

	public static void main(String[] args) {
	
//		NatuerlichePartei np = new NatuerlichePartei();
//		np.setStrasse("strasse");
//		np.setHausnummer(1);
//		np.setHausnummerZusatz("a");
//		np.setOrt("Berlin");
//		np.setTelnummer(123456789);
//		np.setName("Mustermann");
//		np.setVorname("Max");
//		Database.writePartei(np);
//		
//		JuristischePartei jp = new JuristischePartei();
//		jp.setStrasse("s");
//		jp.setHausnummer(1);
//		jp.setHausnummerZusatz("1a");
//		jp.setOrt("Berlin");
//		jp.setTelnummer(1234);
//		jp.setHandelsregister("testHandelsregsiter");
//		jp.setFirmenname("Contract GANG");		
//		Database.writePartei(jp);

//		Fahrzeug fz = new Fahrzeug();
//		fz.setTyp("test");
//		fz.setModell("test");
//		ArrayList<String> temp = new ArrayList<>();
//		temp.addAll(Arrays.asList("Rechter Kotflügel Hinten Neu","Linker Kotflügel  Hinten Neu"));
//		fz.setZusatzAusstattung(temp);
//
//		KfzKaufvertrag kv = new KfzKaufvertrag();
//		Partei p1 =  Database.readPartei("Max", "Mustermann");	
//		Partei p2 = Database.readPartei("Contract GANG");
//		kv.setPartei1(p1);
//		kv.setPartei2(p2);
//		
//		temp.clear();
//		temp.addAll(Arrays.asList("Rechter Kotflügel Hinten Neu","Linker Kotflügel  Hinten Neu"));
//		kv.setListeUnfallschaeden(temp);
//		
//		kv.setBezeichnung("TEst");
//		kv.setAlleinigesEigentum(true);
//		kv.setKaufpreis(45000);
//		kv.setAnzahlSchluessel(2);
//		
//		temp.clear();
//		temp.addAll(Arrays.asList("Sitze vorne gerissen","Licht rechts vorne kaputt"));
//		kv.setBeschaedigungen(temp);
//		temp.clear();
//		temp.addAll(Arrays.asList("15% Anzahlung","5 Tage Ummeldung"));
//		kv.setSondervereinbarungen(temp);
//		
//		Database.wirteKfzKaufvertrag(kv, fz);
		
//		Mietobjekt mo = new Mietobjekt();
//		mo.setStrasse("Musterstrasse");
//		mo.setOrt("Berlin");
//		mo.setPlz(34566);
//		mo.setAnzahlKuechen(5);
//		mo.setEtage(2);
//		
//		Mietvertrag mv = new Mietvertrag();
//		mv.setPartei1(Database.readPartei("Max", "Mustermann"));
//		mv.setPartei2(Database.readPartei("Contract GANG"));
//		mv.setMonatsMiete(3245);
//		mv.setPreisgebunden(true);
//		
//		Database.writeMietvertrag(mv, mo);
							
//		KfzKaufvertrag kv2 = Database.readKfzKaufvertrag("TEst");
//		System.out.println(kv2.getAnzahlSchluessel());

		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("/view/Startseite.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Vertragsgenerator");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
}
