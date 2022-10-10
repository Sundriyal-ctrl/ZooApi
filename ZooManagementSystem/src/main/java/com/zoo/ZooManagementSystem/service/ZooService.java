package com.zoo.ZooManagementSystem.service;

import com.zoo.ZooManagementSystem.model.Animal;
import com.zoo.ZooManagementSystem.model.Zoo;
import com.zoo.ZooManagementSystem.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ZooService {
    @Autowired
    AnimalRepository animalRepository;
    public List<Zoo> getZoo()
    {
        return animalRepository.findAll();
    }

    public ResponseEntity setZoo(Zoo zoo)
    {
        HashMap hashMap=new HashMap();
        hashMap.put("Error","User Already Exits");
        if(animalRepository.findById(zoo.getId()).isPresent()) {
            return new ResponseEntity(Optional.of(hashMap),HttpStatus.ALREADY_REPORTED);
        }
        else
        return new ResponseEntity(Optional.of(animalRepository.save(zoo)), HttpStatus.FOUND);
    }


    public void setAnimal(int id, Animal animal)
    {

      if(animalRepository.findById(id).isPresent())
      {
          Zoo zoo=animalRepository.findById(id).get();
          List<Animal> animal1=zoo.getAnimalList();
          animal1.add(animal);
          zoo.setAnimalList(animal1);
          animalRepository.save(zoo);
      }

    }


   public ResponseEntity updateZoo(Zoo zoo)
   {
       HashMap hashMap=new HashMap();
       hashMap.put("Error","No User Exits");
       System.out.println(zoo);
       if(animalRepository.findById(zoo.getId()).isPresent()) {
          return new ResponseEntity(Optional.of(animalRepository.save(zoo)), HttpStatus.FOUND);

       }
       else
           return new ResponseEntity(Optional.of(hashMap),HttpStatus.ALREADY_REPORTED);
   }

   public ResponseEntity deleteZoo(int id)
   {
       HashMap hashMap = new HashMap();
      try {
          animalRepository.delete(animalRepository.findById(id).get());


          if (animalRepository.findById(id).isPresent()) {
              hashMap.put("Error", "User Not Delete");
              return new ResponseEntity(Optional.of(hashMap), HttpStatus.FOUND);
          } else {
              hashMap.put("Success", "User Delete");
              return new ResponseEntity(Optional.of(hashMap), HttpStatus.NOT_FOUND);
          }
      }
      catch (Exception e)
      {
          hashMap.put("Error", "User Not Present");
          return new ResponseEntity(Optional.of(hashMap), HttpStatus.NOT_FOUND);
      }
   }
}

