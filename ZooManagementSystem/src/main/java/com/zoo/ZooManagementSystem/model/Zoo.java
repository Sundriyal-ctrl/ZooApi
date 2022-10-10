package com.zoo.ZooManagementSystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zoo {
    @Id
    int id;
    String name;
    @OneToMany(cascade = CascadeType.ALL)
    List<Animal> animalList;

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

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", NAME='" + name + '\'' +
                ", animalList=" + animalList +
                '}';
    }
}
