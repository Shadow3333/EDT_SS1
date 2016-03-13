package manager;

import java.util.ArrayList;
import java.util.List;

import models.EU;


/**
 * @author LELIEVRE Romain
 * @contributor DUBUIS Michael
 */

public class ManagerEUs {
	

	List<EU> eus = new ArrayList<EU>();
	
	/**
	 * @param dao
	 */
	public ManagerEUs() {
		EU ue1 = new EU();
		ue1.setId("aze");
		ue1.setName("aze");
		ue1.setDescription("aze");
		ue1.setNbCredits(23);
		
		EU ue2 = new EU();
		ue2.setId("azeaze");
		ue2.setName("azeaze");
		ue2.setDescription("azeaze");
		ue2.setNbCredits(852);
		eus.add(ue2);
		eus.add(ue1);
	}

	public void add (EU ue){
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
