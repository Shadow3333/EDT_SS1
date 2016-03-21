package controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import manager.SessionManager;
import models.Session;

@ManagedBean(name = "ScheduleController")
@SessionScoped
public class ScheduleController {
	
	SessionManager sessionM;
	private ScheduleModel eventModel;
	ScheduleEvent event = new DefaultScheduleEvent();

	@PostConstruct
    public void init() {
		sessionM = new SessionManager();
        eventModel = new DefaultScheduleModel();
        
        List<Session> listSession  = findAllSessions();
        for (Session currSession : listSession) {
			addEvent(currSession);
		}
        
    }
	
	public List<Session> findAllSessions(){
		return sessionM.findAll();
	}
	
	public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
	
	public void addEvent(Session currSession)
	{
		String text = "Teaching unit : " + currSession.getEu().getName() + "\n" +
					  "Teacher : " + currSession.getTeacher().getLastName() + "\n"+
					  currSession.getType();
		eventModel.addEvent(new DefaultScheduleEvent(text, currSession.getDate(),
													 getDateplusDuration(currSession)));
	}
	
	@SuppressWarnings("deprecation")
	private Date getDateplusDuration(Session currSession)
	{
		Date date = currSession.getDate();
		date.setHours(date.getHours()+currSession.getNbHour());
		return date;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
}
