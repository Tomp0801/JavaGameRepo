package himmelskoerper;

import java.util.ArrayList;

/**
 * Ein Stern, um den Himmelsk�rper kreisen k�nnen
 * 
 * @author Thomas
 *
 */
public class Stern extends Himmelskoerper implements Bewohnbar
{
	/**
	 * Liste der Objekte, die diesen Stern umkreisen
	 */
	ArrayList<ImOrbit> objectsInOrbit;
	
	
	@Override
	void refresh() {
		// TODO Auto-generated method stub
		
	}

}
