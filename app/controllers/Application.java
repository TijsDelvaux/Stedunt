package controllers;

import models.Advertisement;
import models.Conversation;
import models.Language;
import models.Message;
import models.Student;
import models.StudentAdvertisement;
import models.TutorAdvertisement;
import play.*;
import play.mvc.*;
import play.data.*; 
import static play.data.Form.*;
import views.html.*;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {


	
	@Security.Authenticated(Secured.class)
	public static Result index() {
	    return ok(start.render(
	        Student.find.byId(request().username())
	    )); 
	}
	
	
	@Security.Authenticated(Secured.class)
    public static Result start(){
    	return ok(start.render(
    	        Student.find.byId(request().username())
    	    )); 
    }
    
    public static Result login() {
        return ok(
            login.render(form(Login.class))
        );
    }
    
    public static Result register() {
        return ok(
            register.render(form(Register.class))
        );
    }
    
	@Security.Authenticated(Secured.class)
    public static Result admin(){
    	return ok(admin.render(
    	        Student.find.byId(request().username()),
    	        Student.find.all()
    	    )); 
    }
    
    public static Result registerNewUser() {
    	Form<Register> regForm = Form.form(Register.class).bindFromRequest();
        if (regForm.hasErrors()) {
            return badRequest(register.render(regForm));
        } else {
	    	return redirect(
	                routes.Application.login()
	            );
        }
    }
    
    public static Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
            routes.Application.login()
        );
    }
    
      public static Result authenticate() {
            Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
            if (loginForm.hasErrors()) {
                return badRequest(login.render(loginForm));
            } else {
                session().clear();
                session("email", loginForm.get().email);
                return redirect(
                    routes.Application.start()
                );
            }
        }
      
  	@Security.Authenticated(Secured.class)
      public static Result viewAllAdvertisements() {  	  
    	  return ok(
    	            viewAdvertisements.render(
    	            		Student.find.byId(request().username()), 
    	            		StudentAdvertisement.find.all(),
    	            		TutorAdvertisement.find.all()
    	            		)
    	        );
      }
  	
  	
  	@Security.Authenticated(Secured.class)
    public static Result viewMyOwnAdvertisements() {  	  
  	  return ok(
//  	            viewOwnAdvertisements.render(
//  	            		Student.find.byId(request().username()), 
//  	            		StudentAdvertisement.findStudentAdvInvolving(request().username()),
//  	            		TutorAdvertisement.findTutorAdvInvolving(request().username())
//  	            		)
  	            		
  	            		    	            viewOwnAdvertisements.render(
    	            		Student.find.byId(request().username()), 
    	            		StudentAdvertisement.find.all(),
    	            		TutorAdvertisement.find.all()
    	            		)
  	        );
    }

    @Security.Authenticated(Secured.class)
    public static Result viewMyAdvertisements() {
	     return ok(
	                myAdvertisements.render(Student.find.byId(request().username()))
	            );
    }
    
    public static Boolean hasStudAdv(String email) {
    	List<StudentAdvertisement> sal = StudentAdvertisement.find.all();
    	for(StudentAdvertisement sa: sal){
    		if(sa.student.email.equals(email)){
    			return true;
    		}
    	}
    	return false;
    }
    
    public static Boolean hasTutAdv(String email) {
    	List<TutorAdvertisement> sal = TutorAdvertisement.find.all();
    	for(TutorAdvertisement sa: sal){
    		if(sa.student.email.equals(email)){
    			return true;
    		}
    	}
    	return false;
    }
  	
  	@Security.Authenticated(Secured.class)
    public static Result addNewStudAdvertisementForm(Long src) {  
        	Form<StudentAdvertisementForm> adForm = Form.form(StudentAdvertisementForm.class).bindFromRequest();

        	
        	
            if (adForm.hasErrors()) {
            	
            	
            	System.out.println("ERRORS");
            	System.out.println(adForm.errorsAsJson());
            	System.out.println(adForm.errors().entrySet());

            	
            	
            	
                return badRequest(postNewStudentAdvertisement.render(Student.find.byId(request().username()),adForm,null,src));
            } else {
            	
            	String description = adForm.get().description;
            	String studies = adForm.get().studies;
            	boolean testAd = adForm.get().test;
            	
            	

            	if(testAd){
            		System.out.println("CREATED TESTAD");
            	}
            	
            	
            	StudentAdvertisement.create(Student.find.byId(request().username()), studies, description,testAd);
            	if(src==1){
              		return ok(
            	            viewAdvertisements.render(
            	            		Student.find.byId(request().username()), 
            	            		StudentAdvertisement.find.all(),
            	            		TutorAdvertisement.find.all()
            	            		)
            	        );
              		}
              		
              		else{
              		return ok(
              				viewOwnAdvertisements.render(
            	            		Student.find.byId(request().username()), 
            	            		StudentAdvertisement.find.all(),
            	            		TutorAdvertisement.find.all()
            	            		)
            	        );
              		}
            }
  		}
  	
  		
  	@Security.Authenticated(Secured.class)
  	    public static Result addNewTutAdvertisementForm(Long src) {  
  		Form<TutorAdvertisementForm> adForm = Form.form(TutorAdvertisementForm.class).bindFromRequest();
        if (adForm.hasErrors()) {
            return badRequest(postNewTutorAdvertisement.render(Student.find.byId(request().username()),adForm, null, src));
        } else {
        	if(src==1){
          		return ok(
        	            viewAdvertisements.render(
        	            		Student.find.byId(request().username()), 
        	            		StudentAdvertisement.find.all(),
        	            		TutorAdvertisement.find.all()
        	            		)
        	        );
          		}
          		
          		else{
          		return ok(
          				viewOwnAdvertisements.render(
        	            		Student.find.byId(request().username()), 
        	            		StudentAdvertisement.find.all(),
        	            		TutorAdvertisement.find.all()
        	            		)
        	        );
          		}
        }
        }
  	
  	@Security.Authenticated(Secured.class)
	    public static Result addNewMessageForm(Long id) {  
		Form<MessageForm> mesForm = Form.form(MessageForm.class).bindFromRequest();
	    if (mesForm.hasErrors()) {
	        return badRequest(postNewMessage.render(mesForm, id));
	    } else {
	    	
	    	Message m = new Message(mesForm.field("text").value().toString(), Student.find.byId(request().username()));
	    	
	    	Conversation c = null;
	    	
      		c = Conversation.find.byId(id.toString());    		
      		c.messages.add(m);
      		c.save();
	    		    	
        return redirect(
            routes.Application.viewMyConversation(id)
        );
    }
    }

  	@Security.Authenticated(Secured.class)
    public static Result addNewMessage(Long id) {
    	return redirect(
//                postNewMessage.render(form(MessageForm.class), id)
                routes.Application.viewMyConversation(id)
            );
    }
    
   
  	@Security.Authenticated(Secured.class)
    public static Result addNewStudAdvertisement(Long src) {
    	return ok(
                postNewStudentAdvertisement.render(Student.find.byId(request().username()),
                		form(StudentAdvertisementForm.class),null,src)
            );
//    	return ok(
//                postNewStudentAdvertisement.render(Student.find.byId(request().username()),
//                		form(StudentAdvertisementForm.class),StudentAdvertisement.findFromUser(request().username()))
//            );
    }
  	
  	@Security.Authenticated(Secured.class)
  	public static Result changeStudAdvertisement(Long adId, Long src){
  		StudentAdvertisement studentAd = StudentAdvertisement.find.byId(adId);
		return ok(
                changeStudentAdvertisement.render(Student.find.byId(request().username()),
                		form(StudentAdvertisementForm.class), studentAd, src)
            );
  	}
  	
  	//src: 1 = viewAdvertisements
  	//src: 2 = viewMyOwnAdvertisements
  	@Security.Authenticated(Secured.class)
    public static Result changeStudAdvertisementForm(Long adId, Long src) {  
  		
  		  		
        	Form<StudentAdvertisementForm> adForm = Form.form(StudentAdvertisementForm.class).bindFromRequest();
        	String description = adForm.get().description;
        	String studies = adForm.get().studies;
        	boolean testAd = adForm.get().test;

        	
        	StudentAdvertisement.create(Student.find.byId(request().username()), studies, description, adId, testAd);

        	
            if (adForm.hasErrors()) {
                return badRequest(changeStudentAdvertisement.render(Student.find.byId(request().username()),adForm,null,src));
            } else {
            	if(src==1){
              		return ok(
            	            viewAdvertisements.render(
            	            		Student.find.byId(request().username()), 
            	            		StudentAdvertisement.find.all(),
            	            		TutorAdvertisement.find.all()
            	            		)
            	        );
              		}
              		
              		else{
              		return ok(
              				viewOwnAdvertisements.render(
            	            		Student.find.byId(request().username()), 
            	            		StudentAdvertisement.find.all(),
            	            		TutorAdvertisement.find.all()
            	            		)
            	        );
              		}
            }
  		}
  	
  	@Security.Authenticated(Secured.class)
    public static Result addNewTutAdvertisement(Long src) {
    	return ok(
                postNewTutorAdvertisement.render(
                		Student.find.byId(request().username()),form(TutorAdvertisementForm.class), TutorAdvertisement.findFromUser(request().username()),src)
            );
    }
    
    public static long getConversationID(String stud1, String stud2){
    	List<Conversation> convs = Conversation.findConversationsOfStudent(Student.find.byId(stud1));
    	long id = -1; //default value, new conv needs to be created
    	if(stud1.equals(stud2)){
    		return -2;
    	}
    	for(Conversation c: convs){
    			if((c.participants.get(0).email.equals(stud1) && c.participants.get(1).email.equals(stud2)) ||
    			   (c.participants.get(0).email.equals(stud2) && c.participants.get(1).email.equals(stud1))	){
    				id = c.id;
    			}
    	}
    	if(id == -1){
    		Conversation c = new Conversation(Student.find.byId(stud1),Student.find.byId(stud2));
    		c.save();
    		id = c.id;
    	}
    	return id;
    	
    }
    
    
  	@Security.Authenticated(Secured.class)
    public static Result viewMyConversations() {

    	return ok(
                viewConversations.render(Student.find.byId(request().username()),  Conversation.findConversationsOfStudent(Student.find.byId(request().username())))
            );
    }
  	
  	@Security.Authenticated(Secured.class)
    public static Result viewMyConversation(Long id) {
  		Student s = Student.find.byId(request().username());
  		Conversation c = Conversation.find.byId(id.toString());
  		
  		if(!c.getParticipants().contains(s)){ //unauthorized access!
  			return redirect(
  	                routes.Application.viewMyConversations()
  	            );
  		}
  		else{
  			//mark all read
  			for(Message m: c.messages){
    			if(!m.sender.email.equals(s.email)){
    				m.setRead();
    				m.save();
    			}
  			}
  			
  			
  			
  		return ok(
                viewConversation.render(s,c,form(MessageForm.class))
            );
  		}
    }
  	
//  	@Security.Authenticated(Secured.class)
//  	public static Result createNewConversation(String receive) {
//  		//Make a conversation
//  		Student sender = Student.find.byId(request().username());
//  		Student receiver = Student.find.byId(receive);
//  		Conversation c = new Conversation(sender, sender, new Message("Test", sender));
//  		//Show all the conversations
//  		//Better: immediately go to the new conversation TODO!!
//  		return viewMyConversations();
//  	}
  	
  	
  	//src: 1 = viewAdvertisements
  	//src: 2 = viewMyOwnAdvertisements
  	@Security.Authenticated(Secured.class)
    public static Result deleteTutAdvertisement(Long id, Long src) {
  		Student s = Student.find.byId(request().username());
  		TutorAdvertisement ta = TutorAdvertisement.find.byId(id);
  		
  		try{
  		if(ta.student.email.equals(s.email)){
  			ta.delete();
  		}
  		}
  		catch(NullPointerException e){
  			
  		}
  		if(src==1){
  		return ok(
	            viewAdvertisements.render(
	            		Student.find.byId(request().username()), 
	            		StudentAdvertisement.find.all(),
	            		TutorAdvertisement.find.all()
	            		)
	        );
  		}
  		
  		else{
  		return ok(
  				viewOwnAdvertisements.render(
	            		Student.find.byId(request().username()), 
	            		StudentAdvertisement.find.all(),
	            		TutorAdvertisement.find.all()
	            		)
	        );
  		}
  		
  	}
  	
  	@Security.Authenticated(Secured.class)
    public static Result deleteStudAdvertisement(Long id, Long src) {
  		Student s = Student.find.byId(request().username());
  		StudentAdvertisement sa = StudentAdvertisement.find.byId(id);

  		try{  		
  		if(sa.student.email.equals(s.email)){
  			sa.delete();
  		}
  		}
  		catch(NullPointerException e){
  			
  		}
  		if(src==1){
  		return ok(
	            viewAdvertisements.render(
	            		Student.find.byId(request().username()), 
	            		StudentAdvertisement.find.all(),
	            		TutorAdvertisement.find.all()
	            		)
	        );
  		}
  		
  		else{
  		return ok(
  				viewOwnAdvertisements.render(
	            		Student.find.byId(request().username()), 
	            		StudentAdvertisement.find.all(),
	            		TutorAdvertisement.find.all()
	            		)
	        );
  		}
  		
  	}
  	
  	@Security.Authenticated(Secured.class)
    public static Result viewFacebook(){
    	return ok(viewFacebook.render(
    	        Student.find.byId(request().username())
    	    )); 
    }
  	
  	
    public static int numberOfUnreadMessagesOf(Student student){
    	int numberUnread = 0;
    	List<Conversation> conversations = Conversation.findConversationsOfStudent(student);
    	for(Conversation c: conversations){
    		for(Message m: c.messages){
    			if(!m.sender.email.equals(student.email) && !m.read){
    				numberUnread++;
    			}
    		}
    	}
    	return numberUnread;
    }
  	    
            
            
    public static class Login {

        public String email;
        public String password;
        
        public String validate() {
        	email = email.toLowerCase();
        	if (Student.authenticate(email, password) == null) {
              return "Invalid user or password";
            }
            return null;
        }

    }
    
    public static class Register {

        public String email;
        public String password;
        public String name;
        public String studies;
        public String lastName;
        public String language;
        
        public String validate() {
        	
            if (email.length()==0 | password.length()==0 | name.length()==0 | lastName.length()==0 | studies.length()==0) {
              return "Please fill in all required forms";
            }
            
            Language lang = Language.Nederlands;
            
            if(language.equals("EN")){
            	lang = Language.English;
            }
                     
            
            
        	Student s = new Student(email, name, lastName, password, lang, studies);
        	s.save();
        	
            return null;
        }
    }
    
    
    
    public static class StudentAdvertisementForm {

        public String studies;
    	public String description;
    	public boolean test;
        
        public String validate() {    
        	
        	if(test!= true && test!= false){
        		test=true;
        	}
        	       	
            if (studies.length()==0 | description.length()==0) {
              return "Please fill in all required forms";
            }
            
            if(request().username() == null){
            	return "username is null, make sure you are logged in";
            }
            

//            models.StudentAdvertisement.create(Student.find.byId(request().username()), studies, description, test);
            return null;
            
        }


    }
    
    public static class TutorAdvertisementForm {

        public String studies;
    	public String description;
    	public double price;
    	public boolean test;
        
        public String validate() {      
        	
        	if(test!= true && test!= false){
        		test=true;
        	}
        	
            if (studies.length()==0 | description.length()==0) {
              return "Please fill in all required forms";
            }
            
            if(request().username() == null){
            	return "username is null, make sure you are logged in";
            }
            
            models.TutorAdvertisement.create(Student.find.byId(request().username()), studies, description, price, test);
            return null;
            
        }

    }
    
    
    public static class MessageForm {

        public String text;
        
        public String validate() {     
        	
        	
            if (text.length()==0) {
              return "Please fill in all required forms";
            }
            
            if(request().username() == null){
            	return "username is null, make sure you are logged in";
            }

            
            return null;
            
        }

    }
    

}
