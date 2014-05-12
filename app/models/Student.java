package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.*;


import play.db.ebean.*;

import com.avaje.ebean.*;

@Entity
public class Student extends Model{
	
//	private StudentAdvertisement studentAdv;
//	private TutorAdvertisement tutorAdv;
//	private List<Message> messages;
	
    @Id
    public String email;
    public String name;
    public String password;
    public String lastName;
    public Language language;
    public String studies;
    @OneToMany(cascade=CascadeType.ALL)
    public List<Statistic> statistics;
    
    
	public Student(String email, String name, String lastName, String password, Language lang, String studies){
		this.email = email.toLowerCase();
		this.name = name;
		this.password = password;
		this.lastName = lastName;
		this.language = lang;
		this.studies = studies;
		this.statistics = new ArrayList<Statistic>();
		
	}
	
	
//	public static String createPassword(String clearString)  {
//	    return BCrypt.hashpw(clearString, BCrypt.gensalt());
//	}
//	
//	public static boolean checkPassword(String candidate, String encryptedPassword) {
//	    if (candidate == null) {
//	        return false;
//	    }
//	    if (encryptedPassword == null) {
//	        return false;
//	    }
//	    return BCrypt.checkpw(candidate, encryptedPassword);
//	}
	
	
	public List<Statistic> getStatistics(){
		return statistics;
	}
	
	public void newPage(Date date, String str){
		System.out.println("Newpage called");
		statistics.add(new Statistic(date, str));
		this.save();
	}
	
	public static Finder<String,Student> find = new Finder<String,Student>(
	        String.class, Student.class
	    ); 
	
	public static Student authenticate(String email, String password) {
        return find.where().eq("email", email.toLowerCase())
            .eq("password", password).findUnique();
    }
	
	public Language getLanguage(){
		return language;
	}

	public String getName() {
		return name;
	}
	
	public String getLastName(){
		return lastName;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}

	public String getStudies(){
		return studies;
	}

	
	
}
