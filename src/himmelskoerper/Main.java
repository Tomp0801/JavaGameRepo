package himmelskoerper;

import java.util.Vector;

/**
 * Klasse für reine Testzwecke
 * 
 * Soll ein Sonnensystem mit Stern und Planeten und Monden sein
 * 
 * @author Thomas
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		/**
		 * Sonne des Sonnensystems
		 */
		Stern sonne;

		double masse = (1.989 * Math.pow(10, 30)); 
		float radius = 695700;
		sonne = new Stern(masse, radius);
		
		//Planeten hinzufügen
		Planet erde = new Planet(sonne, 149600000, 5.972 * Math.pow(10, 24), "fest");
		
		
		
		//"programmschleife"
		while (true) {
			erde.refresh();
			erde.printStatus();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
