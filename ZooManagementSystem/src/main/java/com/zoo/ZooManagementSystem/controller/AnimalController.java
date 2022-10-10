package com.zoo.ZooManagementSystem.controller;

import com.zoo.ZooManagementSystem.model.Animal;
import com.zoo.ZooManagementSystem.model.Zoo;
import com.zoo.ZooManagementSystem.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    ZooService zooService;

    @GetMapping("/fetch")
    public List<Zoo> getZoo()
    {
        return zooService.getZoo();
    }

    @RequestMapping(value = "/insert",consumes = "application/JSON",method = RequestMethod.POST)
    public ResponseEntity setZoo(@RequestBody  Zoo zoo)
    {
        return zooService.setZoo(zoo);
    }

    @RequestMapping(value = "/update",consumes = "application/JSON",method = RequestMethod.PUT)
    public ResponseEntity updateZoo(@RequestBody  Zoo zoo)
    {
        return zooService.updateZoo(zoo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteZoo(@PathVariable  int id)
    {
        return zooService.deleteZoo(id);
    }
    @PostMapping("/animalinsert/{id}")
    public void get(@PathVariable  int id, @RequestBody Animal animal)
    {
     zooService.setAnimal(id,animal);
    }
}
