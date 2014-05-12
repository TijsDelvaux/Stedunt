package models;

public enum Language {
	
	Nederlands{
		
		public String firstName(){return "Voornaam";}
		public String lastName(){return "Achternaam";}
		public String email(){return "Email";}
		public String password(){return "Wachtwoord";}
		public String language(){return "Taal";}
		public String toString() {return "Nederlands";}
		public String myTutorAdvertisements() {return "Mijn bijles-advertenties";}
		public String messages() {return "Berichten";}
		public String advertisement(){return "Advertentie";}
		public String advertisements(){return "Advertenties";}
		public String viewAdvertisements(){return "Bekijk advertenties";}
		public String myAdvertisements(){return "Mijn advertenties";}
		public String postAdvertisement(){return "Advertentie posten: ";}
		public String searchTutor(){return "Bijles zoeken";}
		public String giveTutoring(){return "Bijles geven";}
		public String tutorSearchers(){return "Bijleszoekenden";}
		public String tutors(){return "Bijlesgevers";}
		public String changeAdvertisements(){return "Advertenties bekijken of aanpassen: ";}
		public String newStudentAdvertisement(){return "Nieuwe advertentie bijleszoekende";}
		public String newTutorAdvertisement(){return "Nieuwe advertentie bijlesgever";}
		public String studies(){return "Studierichting";}
		public String course(){return "Vak";}
		public String description(){return "Beschrijving";}
		public String post(){return "Post";}
		public String save(){return "Opslaan";}
		public String tutorAdvertisement(){return "Advertentie bijlesgever";}
		public String studentAdvertisement(){return "Advertentie bijleszoekende";}
		public String alreadyTutorAdvertisement(){return "Je hebt al een bijlesgeversadvertentie, je kan deze hier aanpassen:";}
		public String alreadyStudentAdvertisement(){return "Je kan hier je bestaande advertentie aanpassen:";}
		public String price(){return "Prijs";}
		public String euroPerHour(){return "\u20AC/uur";}
		public String notYetAstudentAdvertention(){return "Je hebt nog geen bijleszoekeradvertentie geplaatst. Klik hier om er nu 1 te plaatsen!";}
		public String notYetATutorAdvertention(){return "Je hebt nog geen bijlesgeversadvertentie geplaatst. Klik hier om er nu 1 te plaatsen!";}
		public String placeAdvertisement(){return "Plaats advertentie";}
		public String conversations(){return "Conversaties";}
		public String conversationWith(){return "Conversatie met";}
		public String read(){return "Lees";}
		public String submit(){return "Verzend";}
		public String newMessage(){return "Nieuw bericht";}
		public String sendMessage(){return "Stuur bericht";}
		public String textFacebook(){return "StEDUnt heeft ook een eigen Facebook groep. In deze groep kan je niet alleen discusieren over deze web-app, maar ook over hoe je nu het best een bijlesgever vindt en andere studie gerelateerde zaken!";}	
		public String goToFacebookGroup(){return "Ga naar de Facebook groep";}
		
	}, 
	
	English{
		public String firstName(){return "Firstname";}
		public String lastName(){return "Lastname";}
		public String email(){return "Email";}
		public String password(){return "Password";}
		public String language(){return "Language";}
		public String toString() {return "English";}
		public String myTutorAdvertisements() {return "My tutor advertisements";}
		public String messages() {return "Messages";}
		public String advertisement(){return "Advertisement";}
		public String advertisements(){return "Advertisements";}
		public String viewAdvertisements(){return "View advertisements";}
		public String myAdvertisements(){return "My advertisements";}
		public String postAdvertisement(){return "Post an advertisement: ";}
		public String searchTutor(){return "Search a tutor";}
		public String giveTutoring(){return "Become a tutor";}
		public String tutorSearchers(){return "Tutor searchers";}
		public String tutors(){return "Tutors";}
		public String changeAdvertisements(){return "Change/view advertisement: ";}
		public String newStudentAdvertisement(){return "New advertisement for searching a tutor";}
		public String newTutorAdvertisement(){return "New tutor advertisement";}
		public String studies(){return "Studies";}
		public String course(){return "Course(s)";}
		public String description(){return "Description";}
		public String post(){return "Post";}
		public String save(){return "Save";}
		public String tutorAdvertisement(){return "Tutor advertisement";}
		public String studentAdvertisement(){return "Tutor-seaching advertisement";}
		public String alreadyTutorAdvertisement(){return "You already have a tutor advertisement, you can change it here:";}
		public String alreadyStudentAdvertisement(){return "You already have an advertisement for asking a tutor, you can change it here:";}
		public String price(){return "Price";}
		public String euroPerHour(){return "\u20AC/hour";}
		public String notYetAstudentAdvertention(){return "You don't have a tutor-searching advertisement yet. Click here to place one!";}
		public String notYetATutorAdvertention(){return "You don't have a tutor advertisement yet. Click here to place one!";}
		public String placeAdvertisement(){return "Place advertisement";}
		public String conversations(){return "Conversations";}
		public String conversationWith(){return "Conversation with";}
		public String read(){return "Read";}
		public String submit(){return "Submit";}
		public String newMessage(){return "New message";}
		public String sendMessage(){return "Send message";}
		public String textFacebook(){return "StEDUnt also has a Facebook group. In this group you can discuss about the web-app, what you think the best way is to find a tutor and other studie related business!";}
		public String goToFacebookGroup(){return "Go to the Facebook group";}
		
	};
	
	public abstract String toString();
	public abstract String myTutorAdvertisements();
	public abstract String messages();
	public abstract String advertisement();
	public abstract String advertisements();
	public abstract String viewAdvertisements();
	public abstract String myAdvertisements();
	public abstract String postAdvertisement();
	public abstract String searchTutor();
	public abstract String giveTutoring();
	public abstract String tutorSearchers();
	public abstract String tutors();
	public abstract String changeAdvertisements();
	public abstract String newStudentAdvertisement();
	public abstract String newTutorAdvertisement();
	public abstract String studies();
	public abstract String course();
	public abstract String description();
	public abstract String post();
	public abstract String save();
	public abstract String tutorAdvertisement();
	public abstract String studentAdvertisement();
	public abstract String alreadyTutorAdvertisement();
	public abstract String alreadyStudentAdvertisement();
	public abstract String price();
	public abstract String euroPerHour();
	public abstract String notYetAstudentAdvertention();
	public abstract String notYetATutorAdvertention();
	public abstract String placeAdvertisement();
	public abstract String conversations();
	public abstract String conversationWith();
	public abstract String read();
	public abstract String submit();
	public abstract String newMessage();
	public abstract String sendMessage();
	public abstract String textFacebook();
	public abstract String goToFacebookGroup();
}
