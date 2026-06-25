package org.example.springbuild_pawsandfound.Controller;


import org.example.springbuild_pawsandfound.Models.AnimalShelter;
import org.example.springbuild_pawsandfound.Repository.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animalshelter")
public class AnimalController {
    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/form")
    public String getForm() {
        return  "<form method = 'post'>" +
                    "<label> Enter name: "
                    + "<input type ='text' name = 'name'> " +
                    "<label> Enter age: "+
                    "<input type = 'number' name = 'age'> " +
                    "<label> Enter species: " +
                    "<input type = 'text' name = 'species'> "+
                    "<input type = 'submit' >"+
                "</form>" ;
    }

    @PostMapping("form")
    //    public String handleForm(String name, int age){
    //        return "Hello : "+ name + " ! You are "+ age + " Years old!";
    //    }
    public String handleForm(AnimalShelter animal){
        animalRepository.save(animal);
        return "Hello : "+ animal.getName() + " ! You are "+ animal.getAge() + " Years old!";
    }


    @GetMapping("/animals")
    public List<AnimalShelter> getAllItems() {
        return animalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public AnimalShelter getItem(@PathVariable int id) {
        return animalRepository.findById(id).orElse(null);
    }

    @PostMapping("/animals")
    public AnimalShelter addItem(@RequestBody AnimalShelter animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/animals/{id}")
    public AnimalShelter updateItem(@PathVariable int id, @RequestBody AnimalShelter animal) {
        animal.setId(id);
        return animalRepository.save(animal);
    }

    @DeleteMapping("/animals/{id}")
    public void deleteItem(@PathVariable int id) {
        animalRepository.deleteById(id);
    }
}
