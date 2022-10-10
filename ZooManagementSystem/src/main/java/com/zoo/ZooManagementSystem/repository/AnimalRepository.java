package com.zoo.ZooManagementSystem.repository;

import com.zoo.ZooManagementSystem.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Zoo,Integer> {

}
