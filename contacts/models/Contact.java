package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
  
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;


    public Contact(String name, String phoneNumber, String birthDate) throws ParseException{
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        if(phoneNumber==null || phoneNumber.isBlank()|| phoneNumber.length()<5){
            throw new IllegalArgumentException("Invalid phonenumber");
        }
        this.phoneNumber=phoneNumber;

        this.birthDate=birthDate;
        this.age=toage(birthDate);

    }

    public Contact(Contact source){
        this.name = source.name;
        this.phoneNumber=source.phoneNumber;
        this.birthDate=source.birthDate;
        this.age=source.age;

    }

    public String getName() {
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null");
        }
        return name;
    }

    public String getPhoneNumber() {
        if(phoneNumber==null || phoneNumber.isBlank()|| phoneNumber.length()<5){
            throw new IllegalArgumentException("Invalid phonenumber");
        }
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toage(birthDate));
    }

    private void setAge(int age) {
        this.age = age;
    }



    public int toage(String birthDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        Date date = formatter.parse(birthDate);
        long toMilli = date.getTime();
        long diff = new Date().getTime() - toMilli;
        return (int)(TimeUnit.MILLISECONDS.toDays(diff) / 365);

    }

    public String toString(){
        return "Name: " + this.name + "\n" +
    "Phone number: " + this.phoneNumber + "\n" +
    "Birth Date: " + this.birthDate+ "\n" +
    "Age: " + this.age + " year old\n";
    }
  

}
