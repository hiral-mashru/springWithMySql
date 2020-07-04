package io.example.demo.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    private String Name;
    private String EmailID;
    private String Password;

    public details() {
    }

    public details(String Name, String EmailID, String Password) {
        this.Name = Name;
        this.EmailID = EmailID;
        this.Password = Password;
    }

    public details(int ID, String name, String emailID, String password) {
        this.ID = ID;
        Name = name;
        EmailID = emailID;
        Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    @Override
    public String toString() {
        return "details{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", EmailID='" + EmailID + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
