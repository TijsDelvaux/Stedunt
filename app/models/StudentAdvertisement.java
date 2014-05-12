package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;


@Entity
public class StudentAdvertisement extends Advertisement {
	
	public StudentAdvertisement(Student student, String course, String description, boolean testAd){
		super(student,course,description, testAd);
	}

//	public StudentAdvertisement(Student student){
//		super(student);
//	}
	
	
	//static methods
	
	public static StudentAdvertisement create(Student student, String course, String description, boolean testAd) {

				
		StudentAdvertisement ad = new StudentAdvertisement(student, course, description, testAd);
		ad.save();
        return ad;
    }
	
	public static StudentAdvertisement create(Student student, String course, String description, Long id, boolean testAd) {
		StudentAdvertisement ad = StudentAdvertisement.find.byId(id);

		if(ad == null){
			ad = new StudentAdvertisement(student, course, description, testAd);
		}else{
			ad.setDescription(description);
			ad.setCourse(course);
		}
		ad.save();
        return ad;
	}
		
//	public static StudentAdvertisement create(Student student, String studies, String description, boolean testAd) {
//		
//		StudentAdvertisement ad = new StudentAdvertisement(student, studies, description, testAd);
//		ad.save();
//        return ad;
//    }
	
    public static Model.Finder<Long,StudentAdvertisement> find = new Model.Finder(Long.class, StudentAdvertisement.class);
	
    public static StudentAdvertisement findFromUser(String user) {
        try{
        	
        	System.out.println(user);
        	
        	return find.where()
            .eq("student_email", user)
            .findList().get(0);
        }
        catch(IndexOutOfBoundsException e){
        	return null;
        }
    }
    
    public static List<StudentAdvertisement> findAllFromUser(String user) {
    	List<StudentAdvertisement> list = new ArrayList<StudentAdvertisement>();
        try{
        	
        	System.out.println(user);
        	
        	list = find.where()
            .eq("student_email", user)
            .findList();
        }
        catch(IndexOutOfBoundsException e){
        	return null;
        }
        return list;
        
    }
    
    
    
    
    
//    public static List<StudentAdvertisement> findStudentAdvInvolving(String user) {
//        return find.where()
//            .eq("members.email", user)
//            .findList();
//    }
	
}
