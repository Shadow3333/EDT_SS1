package manager;

import java.util.ArrayList;
import java.util.List;

import models.UE;


/**
 * @author LELIEVRE Romain
 * @contributor DUBUIS Michael
 */

public class ManagerEUs {
	

	List<UE> eus = new ArrayList<UE>();
	
	/**
	 * @param dao
	 */
	public ManagerEUs() {
		UE ue1 = new UE();
		ue1.setId("aze");
		ue1.setName("aze");
		ue1.setDescription("aze");
		ue1.setNbCredits(23);
		
		UE ue2 = new UE();
		ue2.setId("azeaze");
		ue2.setName("azeaze");
		ue2.setDescription("azeaze");
		ue2.setNbCredits(852);
		eus.add(ue2);
		eus.add(ue1);
	}

	public void add (UE ue){
		UE eu = new UE();
		eu.copy(ue);
		eus.add(eu);
	}
	
	public void remove (UE ue){
		eus.remove(ue);
	}
	
	public List<UE> findAll (){
		return eus;
	}
	
	public UE find (String id){
		for ( UE ue : eus){
			if (ue.getId() == id)
				return ue;
		}
		return null;
	}
	
}
