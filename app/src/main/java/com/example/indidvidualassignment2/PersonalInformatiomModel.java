package com.example.indidvidualassignment2;

public class PersonalInformatiomModel {
    private String Name;
    private String Email;
    private String Phone;
    private String Hobbies;


    public PersonalInformatiomModel(String Name, String Email,String Phone,String Hobbies) {
        this.Name =Name;
        this.Email = Email;
        this.Phone  =Phone;
        this.Hobbies = Hobbies;

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Name = Email;
    }
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String Hobbies) {
        this.Hobbies = Hobbies;
    }
}
