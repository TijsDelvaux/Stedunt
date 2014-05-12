package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity 
public class Statistic  extends Model{
	

    @Id
    public long id;
    public Date date;
    public String page;
    
    public Statistic(Date date, String page){
    	this.date = date;
    	this.page = page;
    }

}
