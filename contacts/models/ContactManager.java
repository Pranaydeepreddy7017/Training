package models;

import java.util.ArrayList;

public class ContactManager {
    ArrayList <Contact> contacts = new ArrayList <Contact>();
    
    public ContactManager(){
        this.contacts = new ArrayList<Contact>();
    }

    public Contact getContacts(int index) {
        // return new Contact contacts[index]   Try
        return new Contact(contacts.get(index));
    }

    public void setContacts(int index, Contact contact) {
       //  this.contacts[index] = new Contact (contact);   Try
       contacts.set(index,contact);
    }

    public void addContact(Contact contact){
        // contacts.add(contact); reference trap
        contacts.add(new Contact(contact));
    }

    public void removeContact(String contactName){

        if (contacts.size()==0){    // another way : contacts.isEmpty() - boolean
            throw new IllegalStateException("contacts list is empty");
        }

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName() == contactName){
                contacts.remove(i);
            }             
        }
    }

    public String toString() {
        String temp="";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
}
