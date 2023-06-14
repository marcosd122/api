package br.com.doefacil.doefacil.services;

import br.com.doefacil.doefacil.models.Ong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.doefacil.doefacil.repositories.OngRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OngService {
    @Autowired
    OngRepository ongRepository;

    public Ong save(Ong ong){
        return ongRepository.save(ong);
    }

    public void delete(Ong ong){
        ongRepository.delete(ong);
    }

    public Optional<Ong> search (String id){
        return ongRepository.findById(id);
    }

    public List<Ong> searchAll(){
        return ongRepository.findAll();
    }

    public void deleteById(String id){
        Ong ong = ongRepository.findById(id).get();
        ongRepository.deleteById(id);
    }

    public void deleteAll(){
        ongRepository.deleteAll();
    }

    public Ong findById(String id){
        return ongRepository.findById(id).get();
    }

    public Ong findByEmail(String email) {
        return ongRepository.findByOngEmail(email);
    }

    public Ong updateOng(String id, Ong updatedOng){
        if (ongRepository.existsById(id)){
            updatedOng.set_id(id);
            ongRepository.save(updatedOng);
        }

        return updatedOng;
    }
}
