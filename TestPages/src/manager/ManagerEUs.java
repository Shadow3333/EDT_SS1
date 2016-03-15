package manager;

import java.util.ArrayList;
import java.util.List;

import models.EU;


/**
 * @author LELIEVRE Romain
 * @contributor DUBUIS Michael
 */

public class ManagerEUs {
	

	List<EU> eus;
	
	/**
	 * @param dao
	 */
	public ManagerEUs() {
		eus = new ArrayList<EU>();
		EU ue1 = new EU();
		ue1.setId("JEE12");
		ue1.setName("Java entreprise edition");
		ue1.setDescription("est une EU");
		ue1.setNbCredits(23);
		
		EU ue2 = new EU();
		ue2.setId("H0145");
		ue2.setName("haskell");
		ue2.setDescription("est surement une EU");
		ue2.setNbCredits(852);
		EU ue3 = new EU();
		ue3.setId("C1678");
		ue3.setName("Cryptographie");
		ue3.setDescription("est possiblement une EU");
		ue3.setNbCredits(852);
		eus.add(ue2);
		eus.add(ue3);
		eus.add(ue1);
		
	}

	public void save (EU ue){
		EU eu = new EU();
		eu.copy(ue);
		eus.add(eu);
	}
	
	public void remove (EU ue){
		eus.remove(ue);
	}
	
	public List<EU> findAll (){
		return eus;
	}
	
	public EU find (String id){
		for ( EU ue : eus){
			if (ue.getId() == id)
				return ue;
		}
		return null;
	}
	
}
