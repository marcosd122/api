package br.com.doefacil.doefacil.controllers;

import br.com.doefacil.doefacil.models.Ong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.doefacil.doefacil.services.OngService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/ong")
public class OngController {

    @Autowired
    OngService ongService;

    @GetMapping("/details/{id}")
    public ResponseEntity<Ong> searchOng (@PathVariable("id") String id){
        try{
           Ong ong = ongService.search(id).get();
            return new ResponseEntity<>(ong, HttpStatus.OK);
        }catch (NullPointerException ex){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Ong>> searchAll(){
        try {
            return new ResponseEntity<>(ongService.searchAll(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Ong> registerOng(@RequestBody Ong ong) {
        try{
            Ong newOng =  ongService.save(ong);
            return new ResponseEntity<>(newOng,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{email}")
    public Ong searchAll(@PathVariable("email") String email){
        return ongService.findByEmail(email);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOngById (@PathVariable("id") String id){
        try{
            String deleteMessage = "Ong deletada com sucesso";
            ongService.deleteById(id);
            return new ResponseEntity<>(deleteMessage,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllOng() {
        try{
            String deleteMessage = "Todas as Ongs foram deletadas";
            ongService.deleteAll();
            return new ResponseEntity<>(deleteMessage,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ong> updateOng (@PathVariable ("id") String id, @RequestBody Ong updatedOng){
        try{
            Ong ongId = ongService.findById(id);
            Ong ong = ongService.updateOng(id, updatedOng);
            return new ResponseEntity<>(ong,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
