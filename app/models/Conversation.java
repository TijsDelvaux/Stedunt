package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;

import com.avaje.ebean.*;


@Entity
public class Conversation extends Model{


    @Id
    public long id;
    @ManyToMany
    public List<Student> participants;
    @OneToMany(cascade=CascadeType.ALL)
    public List<Message> messages;
    
    

	public Conversation(Student participant1, Student participant2, Message message){

		participants = new ArrayList<Student>();
		participants.add(participant1);
		participants.add(participant2);

		messages = new ArrayList<Message>();
		messages.add(message);
	}

	public Conversation(Student participant1, Student participant2) {
		participants = new ArrayList<Student>();
		participants.add(participant1);
		participants.add(participant2);

		messages = new ArrayList<Message>();
	}

	public int getNumberOfUnreadMessagesFor(Student student){
		int numberUnread = 0;
		for(Message m: messages){
			if(!m.sender.email.equals(student.email) && !m.read){
				numberUnread++;
			}
		}
		return numberUnread;
	}

	public static Finder<String,Conversation> find = new Finder<String,Conversation>(
	        String.class, Conversation.class
	    ); 



	public static List<Conversation> findConversationsOfStudent(Student student) {
        List<Conversation> conversations = find.all(); //dirty, should use query!!
        List<Conversation> involving = new ArrayList<Conversation>();
        
        for(Conversation c: conversations){
        	        	
        	if(c.participants.get(0).email.equals(student.email) | c.participants.get(1).email.equals(student.email)){
        		involving.add(c);
        	}
        }
        
        return involving;
        
    }

	public List<Student> getParticipants() {
		return participants;
	}



	public void setParticipants(List<Student> participants) {
		this.participants = participants;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}




}
