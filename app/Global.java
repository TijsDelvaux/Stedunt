import play.*;
import play.libs.*;
import com.avaje.ebean.Ebean;
import models.*;
import java.util.*;

public class Global extends GlobalSettings {
    @Override
    public void onStart(Application app) {
        
    	if (Student.find.findRowCount() == 0) {
	    	Student serge = new Student("serge@gmail.com", "Serge", "Hendrickx","pass",Language.Nederlands, "Burgie");
	    	serge.save();
	    	StudentAdvertisement a = new StudentAdvertisement(serge, "aa", "bb",false);
	    	a.save();
	    	
	    	
	    	Student ine = new Student("ine@gmail.com", "Ine", "Jannsens",	"pass",Language.Nederlands, "Burgie");
	    	ine.save();
	    	TutorAdvertisement t = new TutorAdvertisement(ine, "aa", "bb", 20,true);
	    	t.save();
	    	
	    	
	    	Conversation c = new Conversation(serge, ine, new Message("Hey hey", serge));
	    	c.save();
	    	
	    	Student tijs = new Student("tIjs@gmail.com", "Tijs","Delvaux",	"pass",Language.Nederlands, "Archie");
	    	tijs.save();
	    	
	    	c = new Conversation(serge, tijs, new Message("Hey tijs", serge));
	    	c.save();
	    	
	    	
    	}
    }
}