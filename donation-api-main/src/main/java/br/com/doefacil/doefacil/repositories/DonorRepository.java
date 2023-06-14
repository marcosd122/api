package br.com.doefacil.doefacil.repositories;

import br.com.doefacil.doefacil.models.Donor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends MongoRepository<Donor,String> {
}
