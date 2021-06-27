//-----------------------------------
//Name: Bastian Struggl
//Projektname: Kontaktformular OOP
//Datum: 28.01.2019
//-----------------------------------


import java.util.*;
import java.util.Scanner;

public class Main {
	 static Scanner scan = new Scanner(System.in);
     static ArrayList<Kontakt> contactInformationArrayList = new ArrayList<Kontakt>();
 
	public static void main(String[] args) {
		menue();

  } 
//END of main-method		
//#####################################################################################################################
	
	// Menu-Method 
	public static void menue() {
		boolean breakCondition = true;
		do {
			System.out.println("-) Möchten Sie Kontakte hinzufügen, dann drücken Sie bitte (k)\n"
					          + "-) zum Entfernen von Kontakten die Taste (e) \n"
					          + "-) und zum Anzeigen aller Kontakte (a)\n"
					          + "-) zum Ändern der Informationen bestehender Kontakte (x)\n"
					          + "-) zum Beenden des Programms (c)");
			
			//-------------------------------------------------------------------------------
			String auswahl = scan.next(); //Input 
			char zeichen = auswahl.charAt(0); //Convert to char
			char zeichenLow = Character.toLowerCase(zeichen);   // Char to Lower Case 
			
			//--------------------------------------------------------------------------------
				switch (zeichenLow) {
					// Add new Contacts
					case 'k':
							 Kontakt k =arrayInput(); // Kontakt wird erstellt und per Konstruktor direkt mit Werten initialisiert
							 contactInformationArrayList.add(k); // Add new created contact to the ArrayList 
							 break;
					// Delete of Contacts
					case 'e':
							// Input Index-Number to remove the Contact with that INDEX
							 System.out.println("Geben Sie bitte die Index-Nummer des zu löschenden Kontakts an");
						 	 int indexToDelete;
							 while (true) {
						 		 indexToDelete = scan.nextInt();
						 		 if (indexToDelete < contactInformationArrayList.size() && indexToDelete >=  0) {
						 			 System.out.println("Ihr Kontakt " + contactInformationArrayList.get(indexToDelete) + "wird gelöscht!");
						 			 contactInformationArrayList.remove(indexToDelete);
						 			 break;
							 	}
							    else {
							    	System.out.println("Ihr Index existiert nicht, geben Sie einen gültigen ein");
							    }
							 }
							 
							 break;
					// Print all People with Information on the scrren
					case 'a':
							 int zaehler = 0;
					    	 for(Kontakt element: contactInformationArrayList){
					    		 String outputContactDatas =
					    				 "Kontakt Index: "+zaehler+") "+
					    				 "Name: "+element.getName()+
					    				 "\t\tTel: "+element.getTel()+
					    				 "\t\tEMail: "+element.geteMail()+
					    				 "\n-------------------------------------------------------------------------------------------------------------------------------";
					    		 System.out.println(outputContactDatas);		
					    		 zaehler++;
					    	 }
							 break;
					// Change values from an choosen object (about the index)
					case 'x':
							 changeInformationsInContact();
							 break;
					case 'c':
							 System.out.println("Programm wird beendet");
							 scan.close();
							 System.exit(1);
				}
			}
			while(breakCondition);
	}
	
	// Input METHOD for Contacts
	public static Kontakt arrayInput () {
		// Name Input
		System.out.println("Bitte geben Sie den Vornamen ein");
		String inputForname = scan.next();
		System.out.println("Bitte geben Sie den Nachnamen ein");
		String inputName = scan.next();
		String fullName = inputForname + " " + inputName;
		
		// fullName has to be 16 chars length (for a good formated console-output)
		if (fullName.length() < 16) {
	 		int numberToBeExpanded = 16 - fullName.length();
	 		String space = "";
	 		for (int i = 1; i <= numberToBeExpanded; i++) {
	 			space += " ";
	 		}
	 		fullName += space;
	 	}
	 	
		// Condition Check Telephonumber have to be digits
		System.out.println("Bitte geben Sie die Telefonnummer ein");
		String telNr;
		boolean breakCon = true;
		//Loop Only Digits Input no other chars
		do {
			telNr = scan.next();
			boolean trueOrFalse = isNumeric(telNr);
			if ( trueOrFalse == true) {
				System.out.println("Nummer bestätigt");
				breakCon = false;
			} else {
				System.out.println("Bitte geben Sie nur Zahlen ein");
				continue;
			}
		} while (breakCon);
		
		// Number have to be 11 chars (for a good formated console-output)
		//TODO nummern müssen 11 zeichen lang sein
		if (telNr.length() < 11) {
	 		int numberToBeExpanded = 11 - telNr.length();
	 		String space = "";
	 		for (int i = 1; i <= numberToBeExpanded; i++) {
	 			space += " ";
	 		}
	 		telNr += space;
	 	}
		
		// E-Mail Input
		System.out.println("Bitte geben Sie die E-Mail ein");
		String inputEmail = scan.next();
		Kontakt kunde = new Kontakt(fullName,telNr,inputEmail);
		return kunde;
	}
	// Auskunft PRINT METHOD for Start-Information
	public static void auskunft(){
		System.out.println("-) Möchten Sie Kontakte hinzufügen, dann drücken Sie bitte \"k\",\n"
		          + "-) zum Entfernen von Kontakten die Taste \"e\" \n"
		          + "-) und zum Anzeigen aller Kontakte \"a\"");
	}
	// METHOD to change the informations from the contacts
	public static void changeInformationsInContact() {
		System.out.println("Bitte geben Sie den Index des zu ändernden Kontakts ein");
		int indextoChangeArrayContact;
		while (true) {
			// Catch Errors: Only Number Input
			try {
				indextoChangeArrayContact = scan.nextInt();
				break;
			}
			catch (NumberFormatException e) {
				System.out.println("Sie dürfen nur Zahlen eingeben!"
						+ "\nGeben Sie den Namen ein");
			}
		}
		
		boolean breakCondition = true;
		while (breakCondition){
			//contactInformationArrayList.get(indextoChangeArrayContact);
			System.out.println("Was an dem Kontakt möchten sie ändern?"
					+ "\nWollen Sie den Namen ändern, die Taste (1) drücken"
					+ "\nWollen Sie die Telefonnummer ändern, die Taste (2) drücken"
					+ "\nWollen Sie die E-Mail ändern, die Taste (3) drücken");
			
			int numberDecision = scan.nextInt();
			switch (numberDecision) {
			case 1: System.out.println("Bitte neuen Voramen eingeben");
				 	String newForName = scan.next();
				 	System.out.println("Bitte neuen Nachnamen eingeben");
				 	String newSurName = scan.next();
				 	String newFullName =newForName + " " + newSurName;
				 	// newFullName has to be 16 chars length (for a good formated console-output)
				 	if (newFullName.length() < 16) {
				 		int numberToBeExpanded = 16 - newFullName.length();
				 		String space = "";
				 		for (int i = 1; i <= numberToBeExpanded; i++) {
				 			space += " ";
				 		}
				 		newFullName += space;
				 	}
				 	contactInformationArrayList.get(indextoChangeArrayContact).setName(newFullName);
					break;
			case 2: System.out.println("Bitte neue Telefonnummer eingben");
					boolean breakCon = true;
					//Loop Only Digits Input no other chars
					String newNumber = "";
					do {
						newNumber = scan.next();
						boolean trueOrFalse = isNumeric(newNumber);
						if ( trueOrFalse == true) {
							System.out.println("Nummer bestätigt");
							contactInformationArrayList.get(indextoChangeArrayContact).setTel(newNumber);
							breakCon = false;
						} else {
							System.out.println("Bitte geben Sie nur Zahlen ein");
							continue;
						}
						
					} while (breakCon);
					// Number have to be 11 chars (for a good formated console-output)
					//TODO nummern müssen 11 zeichen lang sein
					if (newNumber.length() < 11) {
				 		int numberToBeExpanded = 11 - newNumber.length();
				 		String space = "";
				 		for (int i = 1; i <= numberToBeExpanded; i++) {
				 			space += " ";
				 		}
				 		newNumber += space;
				 	}
					
					
					break;
			case 3: System.out.println("Bitte neue E-Mail eingben");
					String newEmail = scan.next();
					contactInformationArrayList.get(indextoChangeArrayContact).seteMail(newEmail);
					break;
			};

			// continue (F-key) or back to the main menu (H-Key)
			System.out.println("Wollen Sie noch weiter Daten eingeben, oder zurück zum Hauptmenü"
					+ "\nKontaktänderung fortsetzen (F) oder Hauptmenü (H) ");
			String auswahlMiniMenue = scan.next().toLowerCase();
			char auswahlChar = auswahlMiniMenue.charAt(0);
			if (auswahlChar == 'f') {
				changeInformationsInContact();
			}
			else if (auswahlChar == 'h') {
				menue();
				breakCondition = false;
				// TODO Hauptmenü-Rückkehr funktioniert nicht
			}
		}
	}
	//Condition CHECK is-Digit-METHOD
	public static boolean isNumeric (String string) {
		for (int i = 0; i < string.length(); i++) {
			if (! Character.isDigit(string.charAt(i))) {
				return false;
			}
		}return true;
	}
	
}
