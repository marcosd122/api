package br.com.doefacil.doefacil.repositories;

import br.com.doefacil.doefacil.models.Ong;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends MongoRepository<Ong,String> {

    Ong findByOngEmail(String email);

}
