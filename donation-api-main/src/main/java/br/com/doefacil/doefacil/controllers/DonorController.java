package br.com.doefacil.doefacil.controllers;

import br.com.doefacil.doefacil.models.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.doefacil.doefacil.services.DonorService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/donor")
public class DonorController {

    @Autowired
    DonorService donorService;


    @GetMapping("/details/{id}")
    public Donor searchUser (@PathVariable("id") String id){
        return donorService.search(id).get();
    }

    @GetMapping("/list")
    public List<Donor> searchAll(){
        return donorService.searchAll();
    }

    @PostMapping("/register")
    public Donor registerDonor (@RequestBody Donor donor) {
        return donorService.save(donor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById (@PathVariable("id") String id) {
        donorService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Donor updateOng (@PathVariable ("id") String id, @RequestBody Donor updatedDonor){
        Donor donor = donorService.findById(id);
        return donorService.updateDonor(id, updatedDonor);
    }


}
