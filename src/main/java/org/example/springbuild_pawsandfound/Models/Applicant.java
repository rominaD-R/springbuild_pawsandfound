package org.example.springbuild_pawsandfound.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phoneNumber;

    public Applicant() {};

    public Applicant(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ManyToMany
    private List<AnimalShelter> appliedAnimals;

    public List<AnimalShelter> getAppliedAnimals() {
        return appliedAnimals;
    }

    public void setAppliedAnimals(List<AnimalShelter> appliedAnimals) {
        this.appliedAnimals = appliedAnimals;
    }
}
