package org.example.springbuild_pawsandfound.Controller;

import org.example.springbuild_pawsandfound.Models.AnimalShelter;
import org.example.springbuild_pawsandfound.Models.Applicant;
import org.example.springbuild_pawsandfound.Repository.ApplicantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantRepository applicantRepository;

    public ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @GetMapping("/form")
    public String getForm() {
        return  "<form method = 'post'>" +
                "<label> Enter name: "
                + "<input type ='text' name = 'name'> " +
                "<label> Enter phone number: "+
                "<input type = 'text' name = 'phoneNumber'> " +
                "<label> Enter ID of the animal you want: " +
                "<input type = 'number' name = 'animalId'> "+
                "<input type = 'submit' >"+
                "</form>" ;
    }

    @PostMapping("form")
    public String handleForm(Applicant applicant){
        applicantRepository.save(applicant);
        return "Hello : "+ applicant.getName() + " ! You applied for "+ " animal " + "!";
    }

    @GetMapping()
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<AnimalShelter> getAppliedAnimals(@PathVariable int id) {
        return applicantRepository.findById(id).get().getAppliedAnimals();
    }

    @PostMapping
    public Applicant addApplicant(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam int animalId) {
        Applicant applicant = new Applicant(name, phoneNumber);
       // applicant.setAppliedAnimals(animalRepository.findById(animalId));
        return applicantRepository.save(applicant);
    }

}
