import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;


import models.Contact;
import models.ContactManager;

public class Main {

    static ContactManager contactManager = new ContactManager();
    public static void main(String[] args) throws ParseException {
        // try{
        // // Contact contact = new Contact("Pranay", "10/09/1999","9999999999");
        // // System.out.println(contact);
        
        // contactManager.addContact(new Contact("Ryan","11/11/1992","6135012424"));
        // contactManager.addContact(new Contact("Gio","11/11/1993","6477092344"));
        // contactManager.addContact(new Contact("Thomas","11/11/1994","8192256979"));
        // System.out.println(contactManager);
        
        // contactManager.removeContact("Gio");

        // System.out.println(contactManager);

        // }catch(ParseException e){
        //     System.out.println(e.getMessage());
        // } 
        // finally{
        //     System.out.println("process finished");
        // }
        // }
        try {
            loadContacts("contacts.txt");
            System.out.println("Contacts loaded");
            System.out.println("changed this to loaded 2");
            System.out.println("changed to 3");
            System.out.println(contactManager);
            manageContacts();
       }catch(FileNotFoundException e){
        System.out.println(e.getMessage());
       }
    }
    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */

    public static void manageContacts() throws ParseException {
        Scanner scan = new Scanner(System.in);
        

        while (true){
            System.out.println("What do you want to do. Type \n \t a - to add contact \n \t b - remove contact \n \t anything else to exit ");
            String command = scan.nextLine();
            if(command.equals("a")) {
                System.out.print("\tName: ");
                //pick up name.
                String name= scan.nextLine();
                System.out.print("\tPhone Number: ");
                //pick up number.
                String phoneNumber = scan.nextLine();
                System.out.print("\tBirth Date: ");
                //pick up birth date.
                String birthDate= scan.nextLine();
            try{
            contactManager.addContact(new Contact (name,phoneNumber,birthDate));
            }catch(ParseException e){
                System.out.println(e.getMessage());
            }
            System.out.println("added");
            }
            else if (command.equals("b")){
                System.out.println("Name to remove");
                String name = scan.nextLine();
                contactManager.removeContact(name);
            }
            else{
                break;
            }

        }
        scan.close();

    }




    public static void loadContacts(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan =  new Scanner(fis);

        while (scan.hasNextLine()){
            try{
                Contact contact = new Contact(scan.next(),scan.next(),scan.next());
                contactManager.addContact(contact);
            }catch(ParseException e){
                System.out.println(e.getMessage());
            }

        }
        scan.close();

    }}

    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */


