package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;

import com.avaje.ebean.*;

import java.text.SimpleDateFormat;

@Entity
public class Message extends Model{
	
    @Id
    public long id;
    public String text;
    public Date date;
    public boolean read = false; //read by receiver
    @ManyToOne
    public Student sender;
    
	public Message(String text, Student sender){
		this.text = text;
		this.date = new Date();
		this.sender = sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}
	
	public String getSimpleDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm"); // Set your date format
		return sdf.format(date); // Get Date String according to date format
	}
	
//	public String getShortDate(){
//		return date.toString()+ " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
//	} 
	
	public Student getSender(){
		return sender;
	}
	
	public void setRead(){
		read = true;
	}

	
	
}