package org.example.springbuild_pawsandfound.Controller;


import org.example.springbuild_pawsandfound.Repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animal/submit")
    public List<Animal> renderForm() {
        return """<form>
                <label>Name:</label>
                </form>""";
    }

    @GetMapping("/animals")
    public List<Animal> getAllItems() {
        return animalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public Animal getItem(@PathVariable int id) {
        return animalRepository.findById(id).orElse(null);
    }

    @PostMapping("/animals")
    public Animal addItem(@RequestBody Animal animal) {
        return animalRepository.save(movie);
    }

    @PutMapping("/animals/{id}")
    public Animal updateItem(@PathVariable int id, @RequestBody Animal animal) {
        book.setId(id);
        return animalRepository.save(book);
    }

    @DeleteMapping("/animals/{id}")
    public void deleteItem(@PathVariable int id) {
        animalRepository.deleteById(id);
    }
}
