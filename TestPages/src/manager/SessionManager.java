package manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.openejb.jee.was.v6.ejb.SessionEnum;

import models.AbstractUser.PhoneType;
import models.Courses;
import models.EU;
import models.GroupStudent;
import models.Session;
import models.Student;
import models.Teacher;

public class SessionManager {
	
	List<Teacher> teachers;
	List<EU> eus;
	List<GroupStudent> students;
	List<Courses> courses;
	
	GroupStudent group1;
	GroupStudent group2;
	
	List<Session> sessions;
	
	
	public SessionManager (){
		teachers = new ArrayList<Teacher>();
		eus = new ArrayList<EU>();
		students = new ArrayList<GroupStudent>();
		courses = new ArrayList<Courses>();
		sessions = new ArrayList<Session>();
		
		
		group1 = new GroupStudent();
		group2 = new GroupStudent();
		
		Date birthDate = new Date();
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.HOUR,11);
        cal.set(Calendar.MINUTE, 00);
        birthDate = cal.getTime();
		Map<PhoneType, String> phones = new HashMap<PhoneType, String>();
		
		Teacher teacher1 = new Teacher();
		teacher1.setTeacher("Dupond", "Jean", "jeandDupond@test.com", birthDate, phones, "www.dupond.com");
		
		Teacher teacher2 = new Teacher();
		teacher2.setTeacher("Durand", "Paul", "paulDurand@test.com", birthDate, phones, "www.durand.com");
		
		teachers.add(teacher1);
		teachers.add(teacher2);
		
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
		
		eus.add(ue1);
		eus.add(ue2);
		
		Student student = new Student();
		student.setStudent("Phong", "Romain", "phongRomain@test.com", birthDate, phones, "www.phongRomain.com");
		
		Student student2 = new Student();
		student2.setStudent("Kameni", "Michelle", "kameniMichelle@test.com", birthDate, phones, "www.kameniMichelle.com");
		
		group1.addStudent(student);
		group1.addStudent(student2);
		
		Student student3 = new Student();
		student.setStudent("Gerard", "Claire", "gerardClaire@test.com", birthDate, phones, "www.gerardClaire.com");
		
		Student student4 = new Student();
		student2.setStudent("Zouai", "Dalal", "zouaiDalal@test.com", birthDate, phones, "www.zouaiDalal.com");
		
		group2.addStudent(student3);
		group2.addStudent(student4);
		
		students.add(group1);
		students.add(group2);
		
		Session sess = new Session();
		sess.setDate(birthDate);
		sess.setEu(ue2);
		sess.setNbHour(2);
		sess.setGroupStudent(group2);
		sess.setTeacher(student);
		sess.setType(EU.LessonType.CM);
		sessions.add(sess);
	}
		
	public void save (Session session){
		sessions.add(session);
	}
	
	public void remove (Session session){
		sessions.remove(session);
	}
	
	public List<Session> findAll (){
		return sessions;
	}
	
	public List<Teacher> findAllTeachers (){
		return teachers;
	}
	
	public List<EU> findAllEus (){
		return eus;
	}
	
	public List<GroupStudent> findAllGroups (){
		return students;
	}
	
	public Session find (Long id){
		for ( Session session : sessions){
			if ( session.getId() == id)
				return session;
		}
		return null;
	}
	
	public Teacher find(String email) {
		for (Teacher teacher : teachers) {
			if (teacher.getEmail().equals(email)) {
				return teacher;
			}
		}
        return null;
    }
}
