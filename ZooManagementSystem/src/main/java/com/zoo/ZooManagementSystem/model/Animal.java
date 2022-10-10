package com.zoo.ZooManagementSystem.model;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
  private int animalId;
  private String animalTypeName;
  private String animalName;
  private String category;


    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalTypeName() {
        return animalTypeName;
    }

    public void setAnimalTypeName(String animalTypeName) {
        this.animalTypeName = animalTypeName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalTypeName='" + animalTypeName + '\'' +
                ", animalName='" + animalName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
