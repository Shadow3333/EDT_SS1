package manager;

import java.util.ArrayList;
import java.util.List;

import models.UE;


/**
 * @author LELIEVRE Romain
 * @contributor DUBUIS Michael
 */

public class ManagerEUs {
	
	UE eu = new UE();
	List<UE> eus = new ArrayList<UE>();
	
	/**
	 * @param dao
	 */
	public ManagerEUs() {
	}

	public void add (UE ue){
		eus.add(ue);
	}
	
	public void remove (UE ue){
		eus.remove(eu);
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
