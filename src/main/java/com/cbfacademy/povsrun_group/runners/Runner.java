package com.cbfacademy.povsrun_group.runners;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "runners")
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    protected Long id;
    protected String firstName;
    protected String lastName;

    @Enumerated(EnumType.STRING)
    public Gender gender;

    public Runner(String firstName, String lastName, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Gender.convertInput(gender);
    }

    public Runner(){
        this("", "", "");
    }

    public Long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName(){
        return lastName; 
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender updatedGender){
        this.gender = updatedGender;
    }
}
